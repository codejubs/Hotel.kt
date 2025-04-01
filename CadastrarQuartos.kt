package Hotel
//arrumar a questao do quarto ocupado
fun cadastrarQuartos() {
    val quartos = BooleanArray(20) { false } //inicializando com os quartos disponiveis.

    while (true) {
        print("\nFaça sua reserva!\n" +
                "---> Informe o nome completo do hóspede: ")
        val hospede = readln()

        var numeroquarto: Int
        while (true) {
            print("---> Informe o número do quarto de 1 a 20: ")
            numeroquarto = readln().toInt()
            // Verifica se o número do quarto é válido
            if (numeroquarto < 1 || numeroquarto > 20) {
                print("Informe um quarto válido!\n")}

            // Se o quarto já estiver ocupado
                else if (quartos[numeroquarto - 1]) {
                print("Esse quarto já está ocupado. Escolha outro\n")}

                else {
                    // Se o quarto estiver livre, ocupamos ele
                    print("Quarto livre.\n")
                    quartos[numeroquarto - 1] = true
                    break // Sai do loop se o quarto foi reservado
                }
        }

        //a fun valida a entrada do usuario, o armazenando nas variaveis.
        val valodiarias = valordiaria()
        val diadiarias = diasdiarias()

        //confimação
        val total = (valodiarias * diadiarias)
        println("$nomeusuario, você confirma a hospedagem para $hospede por $diadiarias para o $numeroquarto por R$$total?")
            val simnao = readln()

                if(simnao.equals("sim",ignoreCase = true)){
                    print("\n$nomeusuario, reserva feita para $hospede.")
                    print("\n---Lista dos Quartos---\n")
                    for(i in quartos.indices){
                        val lista = if (quartos[i]) "Ocupado" else "Livre"
                        print("Quartos ${i + 1}: $lista\n")
                    }
                }
                    else{
                        print("Reserva não confirmada. Voltando ao menu inicial")
                        continue //voltando pro inicio do loop
                }

            print("\nDeseja fazer mais uma reserva? ")
                val confimar = readln()
                if(confimar.equals("sim", ignoreCase = true)){
                    cadastrarQuartos()}
                   else{
                       print("Deseja sair? ")
                        val sair = readln()
                            if(sair.equals("sim", ignoreCase = true)){
                                print("Muito obrigada e até logo, $hospede!")}
                            else{
                                menu()}}
                        break}
}

fun valordiaria(): Double {
    while (true) {
        print("---> Qual valor da diária? ")
        val valor = readln().toDouble()

            if(valor > 0){
                return valor //retorna o valor se for válido (??)
            }
            else{
                print("Informe um valor válido!\n")
                }

    }
}

fun diasdiarias(): Int {
    while(true){
        print("---> Quantos dias será a diária? Escolha entre os dias (1 a 30)? ")
        val dias = readln().toInt()
            if(dias < 1 || dias > 30){
                print("Escolha apenas entre 1 a 30 dias!\n")
                diasdiarias() //retorna pra função pra recolocar ate uma diária válida
            }
        else{
            return dias //retorna a quantidade de dias se for válidos
            }
    }
}

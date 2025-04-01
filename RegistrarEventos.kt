package Hotel
fun registrarEventos() {
    val laranja = "Auditório Laranja"  // 150 + 70 cadeiras adicionais
    val colorado = "Auditório Colorado"

    print("\n-----Registrando Eventos-----\n")
    println("Qual número de convidados para o seu evento? ")
    val convidados = readln().toInt()

            if (convidados > 350) {
                print("Quantidade de convidados superior à capacidade máxima.\n")
                registrarEventos()
            }
            if (convidados <= 0) {
                print("Número de convidados inválidos.\n")
                registrarEventos()
            }
            if (convidados == 150) {
                print("Quantidade permitida!\n")
            }

        val auditorio: String
        if (convidados <= 220) {
            val incluir = if (convidados < 150) 150 - convidados
            else 0
            auditorio = laranja
            print("Use o auditório $auditorio (inclua mais $incluir cadeiras)\n")
        } else {
            auditorio = colorado
            print("Use o auditório $auditorio.\n")
        }

    print("Agora vamos ver a agenda do evento.\n")

    print(
        "\n---Reserva do auditório---\n" +
                "Aberto de Segunda a Sexta das 7hs às 23hs" +
                "\nSábados e Domingos apenas 7hs às 15hs\n"
    )

    println("\nQual o dia do seu evento?")
    val dia = readln()
    println("Qual a hora do seu evento? (apenas o número)")
    val hora = readln().toInt()

    val empresa: String
    if (auditoriodispo(dia, hora)) {
         print("Digite nome da empresa: ")
         empresa = readln()

        print("Auditório reservado para a empresa $empresa, $dia às $hora hs.\n")}
            else {
            print("Auditório não disponível.\n")
            return
        }

    //calculos dos garçons, //Garçons necessários para os convidados
    //ceil - para arredondamento de numeros
    val porconvidados = Math.ceil(convidados / 12.0).toInt()

    print("\n---Funcionários---\n")
    println("Qual a duração do evento em horas?")
    val duracao = readln().toInt()
    val porhora = Math.ceil(duracao / 2.0).toInt() //Garçons necessários para os convidados
    val totalgarcons = porconvidados + porhora //total

    if (duracao <= 0) {
        print("Duração inválida.\n")
        return
    }

    //custo por hora de um garçom
    val custoporgarcon = 10.50
    val custototal = totalgarcons * custoporgarcon * duracao

    print("--Será necessários $totalgarcons garçons no valor de R$$custototal--\n")
    print("Agora vamos calcular o custo do Buffet do hotel para o evento.\n")

    //Buffet
    val cafe = convidados * 0.80
    val agua = convidados * 0.40
    val cemSalgados = (convidados * 34) / 7
    val totalbuffet = cafe + agua + cemSalgados

    //relatorio
    print("\n--O evento precisará de $cafe litros de café, $agua litros de água e $cemSalgados Salgados.--")

    print(
        "\n\nRelatório" +
                "\nEvento no $auditorio;" +
                "\nNome da Empresa: $empresa;" +
                "\nData: $dia às $hora hs;" +
                "\nDuração do evento: $duracao horas;" +
                "\nQuantidade de garçons: $totalgarcons garçons;" +
                "\nQuantidade de convidados: $convidados convidados;" +
                "\n\nCusto dos garçons: R$$custototal" +
                "\nCusto do Buffet: R$$totalbuffet")

                println("\nGostaria de efetuar a reserva? ")
                val confirmarcao = readln()

                if (confirmarcao.equals("sim", ignoreCase = true)) {
                    print("$nomeusuario, reserva efetuada com sucesso")
                } else {
                    print("Reserva não efetuada.\n\n")
                    menu()
                }

}

//verificar a disponibilidade do auditorio.
fun auditoriodispo(dia: String, hora: Int): Boolean {
    return when (dia) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in 7..23
        "sabado", "domingo" -> hora in 7..23
        else -> false // dia inválido
    }
}


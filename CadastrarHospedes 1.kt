package Hotel

import kotlin.system.exitProcess

fun fichaHospede() {

    while (true) {
        print("""Cadastro de Hóspedes
        1. Cadastrar Família
        2. Cadastrar Hóspede 
        3. Pesquisar
        4. Sair
        Selecione uma das opções a cima: """)
        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarfamilia()
            2 -> cadastrohospede(listaHospedes)
            3 -> pesquisarHospede(listaHospedes)
            4 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarfamilia() {
    val valorpadrao = 100
    var meia = 0
    var gratuidade = 0
    var valortotal = 0.0

        while(true){
            print("\n---> Qual o nome do Hóspede? ")
            val nomehospede = readln()
                if(nomehospede.equals("pare", ignoreCase = true)){
                    break
                }
            print("---> Qual a idade do(a) $nomehospede? ")
            val idadehospede = readln().toInt()
                print("O(a) Hóspede $nomehospede, foi cadastrado(a) com sucesso!")

                when{
                    idadehospede < 6 -> {
                        print(" O(a) $nomehospede possui gratuidade!")
                        gratuidade++
                    }
                    idadehospede > 60 -> {
                        print(" O(a) $nomehospede possui meia-entrada!")
                        valortotal += valorpadrao/2 //Adiciona metade da diária ao total
                        meia++
                    }
                        else -> {
                            print(" O(a) $nomehospede paga a diária completa")
                            valortotal += valorpadrao}}}

    print("\n$nomeusuario, o valor total das hospedagens é: R$$valortotal; $gratuidade gratuidade(s); $meia meia(s) \n\n")

}
val listaHospedes = mutableListOf<Hospede>()

data class Hospede(
    val nome: String)

fun cadastrohospede(listaHospedes: MutableList<Hospede>){
    for(n in 1..15){
        print("\nQual nome do Hóspede? ")
            val nome = readln()
            listaHospedes.add(Hospede(nome))
        print("Hóspede $nome foi cadastrada(o) com sucesso!\n")
            fichaHospede()
    }
}

fun pesquisarHospede(listaHospedes: MutableList<Hospede>) {
    print("Informe o nome do(a) Hóspede: \n")
    val nome = readln()
    // Se o nome do hóspede estiver na lista, exibir o nome do hóspede.
    if (listaHospedes.any {it.nome.contains(nome, ignoreCase = true)}){
        println("Encontramos a(s) hóspede(s): $nome")
        // filter irá filtrar a lista de hóspedes e exibir apenas os que contém o nome informado.
        listaHospedes.filter {it.nome.contains(nome, ignoreCase = true)} //
            .forEach { println(it) } // forEach irá exibir cada hóspede encontrado.

    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            fichaHospede()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
}
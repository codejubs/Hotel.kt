package Hotel

import kotlin.math.tan

const val hotel = "Hotel Milu"
var nomeusuario = ""
fun main() {
    iniciar()
}

fun iniciar() {
    print("---Bem vindo ao $hotel!---\n")
    println("Como se chama? ")
    nomeusuario = readln()
    println("Agora digite sua senha: ")
    val senha = readln().toInt()
        if(senha != 2678){
            print("Senha incorreta!\n")
            iniciar()}
                else{
                    menu()
                    }
}
fun menu (){
    print("Bem vindo ao $hotel, $nomeusuario. É um imenso prazer ter você por aqui!\n")
    print("1. Cadastrar Quatros\n" +
            "2. Cadastrar Hospedes\n" +
            "3. Registrar Eventos\n" +
            "4. Abastecimento de Automoveis\n" +
            "5. Empresas Ar\n" +
            "6. Sair do Hotel\n" +
            "Escolha uma das opções a cima: ")

                val escolha = readln().toIntOrNull()
                when (escolha) {
                    1 -> cadastrarQuartos()
                    2 -> fichaHospede()
                    3 -> registrarEventos()
                    4 -> abastecimentoDeAutomoveis()
                    5 -> empresasAR()
                    6 -> sairDoHotel()
                    else -> erro()
                }
}


fun abastecimentoDeAutomoveis() {
    val tanque = 42

    println("Qual o valor do álcool no posto Miau Oil?")
       val alcool = readln().toDouble()
    println("Qual o valor da gasolina no posto Miau Oil?")
       val gasolina = readln().toDouble()

    println("Qual o valor do alcool no posto Sucka Oil?")
        val alcool2 = readln().toDouble()
    println("Qual o valor da gasolina no posto Sucka Oil?")
        val gasolina2 = readln().toDouble()

                                 //determinando o mais barato
                     //posto 1
            if(alcool < gasolina * 0.7){
                print("$nomeusuario, é mais barato abastecer com alcool no posto Miau Oil!\n")}

                else if (alcool > gasolina * 0.7){
                print("$nomeusuario, é mais barato abastecer com gasolina no posto Sucka Oil!\n")}

                    //posto 2
                else if (alcool2 < gasolina2 * 0.7){
                    print("$nomeusuario, é mais barato abastecer com alcool no posto Sucka Oil!\n")}

                 else if (alcool2 > gasolina2 * 0.7){
                    print("$nomeusuario, é mais barato abastecer com gasolina no posto Miau Oil!\n")
                }
}

fun sairDoHotel() {
    println("\nVocê deseja sair?")
    val confirma = readln() // digite true ou false ou 1 ou 0
    if (confirma.equals("sim", ignoreCase = true)){
        print("Muito obrigada e até logo, $nomeusuario!")


    } else{
        iniciar()
    }
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    iniciar()
}
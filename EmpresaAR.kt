package Hotel

fun empresasAR(){
        var menorvalor: Double = 0.0
        var menorempresa: String

        while(true){
                println("\nQual o nome da empresa?")
                val empresa = readln()

                println("Qual valor por aparelho?")
                val valor  = readln().toDouble()

                println("Qual a quantidade de aparelhos?")
                val quantidadeAparelhos = readln().toInt()

                println("Qual a porcentagem de desconto?")
                 val desconto = readln().toInt()
                        if(desconto < 0){
                              print("Desconto inválido.\n")
                            empresasAR()
                        }

                println("Qual número mínimo de aparelhos para conseguir o desconto?")
                val descontoMinino = readln().toInt()

            // aplica o desconto se a quantidade de aparelhos for menor ou igual ao desconto minino.
                    var total = 0.0
            total = if(descontoMinino < quantidadeAparelhos){
                valor * quantidadeAparelhos * (1 - desconto / 100.0)

            } else{
                valor * quantidadeAparelhos
            }

                        print("O Serviço de $empresa custará R$$total.\n")

                  // verifica se o valor total é o menor encontrado
                        if(menorvalor < valor){
                            menorvalor = total
                            menorempresa = empresa
                        }

                        print("Deseja informar novos dados, $nomeusuario?")
                            val confirma = readln()
                            if(confirma.equals("sim",ignoreCase = true)){
                                empresasAR()
                            } else {
                                print("O orçamento de menor valor é o [$empresa por R$$total].")
                            }






        }




}

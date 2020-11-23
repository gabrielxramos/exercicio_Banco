package dh.android.aula13

fun main() {
    val bancoTeste = Banco()
    println("Bem ao Banco Digital Bank\n")
    println("Deseja criar uma conta?\nDigite 1 para conta corrente ou 2 para conta poupança")
    var opcao = readLine()
    var numeroDaConta :Int

    when (opcao) {
        "1" -> {
            println("Você é selecionou a conta corrente")
            println("Digite o numero da conta")
            numeroDaConta = readLine()!!.toInt()
            var contacorrente1 = ContaCorrente(0.5, numeroDaConta, 0.0)
            bancoTeste.inserirConta(contacorrente1)
        }
        "2" -> {
            println("Você é selecionou a conta poupança")
            println("Digite o numero da conta")
            numeroDaConta = readLine()!!.toInt()
            var contapoupanca1 = ContaPoupanca(100.0, numeroDaConta, 0.0)
            bancoTeste.inserirConta(contapoupanca1)

        }
        else -> println("Opção invalida")
    }
    bancoTeste.mostrarDados()
}

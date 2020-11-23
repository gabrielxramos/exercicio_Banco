package dh.android.aula13

class ContaCorrente(var taxaDeOperacao: Double, numConta: Int, saldo:Double):ContaBancaria(numConta,saldo), Imprimivel{
    override fun saque(valor: Double) : Double {
        if((valor+taxaDeOperacao)<=saldo){
        saldo-=(valor+taxaDeOperacao)
            println("Saque de valor R$$valor em sua conta com taxa de operação de $taxaDeOperacao. Saldo atual $saldo")
            return valor
        } else
            println("Saldo insuficiente")
        return 0.0
    }

    override fun depositar(valor: Double) {
        saldo+=valor
        saldo-=taxaDeOperacao
            println("Deposito de valor R$$valor em sua conta com taxa de operação de $taxaDeOperacao. Saldo atual $saldo")
    }


    override fun mostrarDados() {
      println("Essa conta corrente possui o número $numConta, o saldo atual é de R$$saldo e possui uma tx de operação de $taxaDeOperacao")
    }

    override fun transferir(valor: Double, contaBancaria: ContaBancaria){
        if (saque(valor) != 0.0) {
            saque(valor)
            contaBancaria.depositar(valor)
            println("Transferencia do valor R$$valor. Para a conta ${contaBancaria.numConta}, transferido com sucesso")
        } else println("Impossivel realizar transação")
    }

}
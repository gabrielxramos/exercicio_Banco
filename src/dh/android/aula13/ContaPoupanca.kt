package dh.android.aula13

class ContaPoupanca(var limite:Double, numConta: Int, saldo: Double): ContaBancaria(numConta, saldo), Imprimivel {
    override fun saque(valor: Double) :Double {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de valor $valor em sua conta. Saldo atual $saldo")
            return valor
        } else if (valor > saldo && valor < saldo + limite) {
            var excedente = valor - saldo
            saldo -= valor - excedente
            limite -= excedente
            println("Saque de valor $valor em sua conta. Saldo atual $saldo.\n" +
                    " Foi necessário utilização de $excedente de seu limite.\n" +
                    " Saldo do limite $limite")
            return valor
        } else {
            println("Saldo insuficiente")
            return 0.0
        }
    }

    override fun depositar(valor: Double) {
        saldo+=valor
        println("Deposito de valor $valor em sua conta. Saldo atual $saldo")
    }

    override fun mostrarDados() {
        println("Essa conta poupança possui o número $numConta, o saldo atual é de R$$saldo e possui um limite de $limite")
    }

    override fun transferir(valor: Double, contaBancaria: ContaBancaria){
        if (saque(valor) != 0.0) {
            saque(valor)
            contaBancaria.depositar(valor)
            println("Transferencia do valor R$$valor. Para a conta ${contaBancaria.numConta}, transferido com sucesso")
        } else println("Impossivel realizar transação")
    }

}
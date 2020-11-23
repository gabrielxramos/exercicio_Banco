package dh.android.aula13

abstract class ContaBancaria(val numConta:Int, var saldo: Double) {

    abstract fun saque (valor:Double): Double

    abstract fun depositar (valor: Double)

    abstract fun transferir (valor: Double, contaBancaria: ContaBancaria)
}
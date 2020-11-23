package dh.android.aula13

class Banco():Imprimivel {
    val listaDeContas = mutableListOf<ContaBancaria>()

    fun inserirConta (conta: ContaBancaria){
        listaDeContas.add(conta)
    }

    fun removerConta (conta: ContaBancaria){
        listaDeContas.remove(conta)
    }

    fun procurarConta(numeroConta: Int) :ContaBancaria? {
        for (procurar in listaDeContas) {
            if (procurar.numConta == numeroConta) {
                println("A sua conta é ${procurar.numConta}")
                return procurar
            }
        }
        println("Essa conta não existe")
        return null
    }

    override fun mostrarDados() {
        for (lista in listaDeContas){
            println(lista.numConta)
        }
    }


}


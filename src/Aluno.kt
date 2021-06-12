class Aluno (var nome: String, var sobrenome: String, var codigoDeAluno: Int) {
    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Aluno -> {
                if(this.codigoDeAluno == other.codigoDeAluno) return true
                return false
            } else -> {
                return super.equals(other)
            }
        }
    }
}
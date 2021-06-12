abstract class Professor() {
    abstract var nome: String
    abstract var sobrenome: String
    abstract var tempoDeCasa: Int
    abstract var codigoDeProfessor: Int

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Professor -> {
                if(this.codigoDeProfessor == other.codigoDeProfessor) return true
                return false
            } else -> {
                return super.equals(other)
            }
        }
    }
}
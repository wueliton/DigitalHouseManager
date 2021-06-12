class Curso (
    var nome: String,
    var codigoDeCurso: Int,
    var quantidadeMaxima: Int,
    var professorTitular: Professor? = null,
    var professorAdjunto: Professor? = null,
    var alunosMatriculados: MutableList<Aluno> = mutableListOf()) {

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if(alunosMatriculados.count() < quantidadeMaxima) {
            alunosMatriculados.add(umAluno)
            return true
        }
        return false
    }

    fun excluirAluno(umAluno: Aluno) {
        alunosMatriculados.remove(umAluno)
    }

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is Curso -> {
                if(this.codigoDeCurso == other.codigoDeCurso) return true
                return false
            } else -> {
                return super.equals(other)
            }
        }
    }

    override fun toString(): String {
        return nome
    }
}
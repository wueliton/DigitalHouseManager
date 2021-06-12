class ProfessorAdjunto(
    override var nome: String,
    override var sobrenome: String,
    override var tempoDeCasa: Int = 0,
    override var codigoDeProfessor: Int,
    var quantidadeDeHoras: Int,
) : Professor()
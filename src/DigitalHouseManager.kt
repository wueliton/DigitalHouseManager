class DigitalHouseManager(
    private var alunos: MutableList<Aluno> = mutableListOf(),
    private var professores: MutableList<Professor> = mutableListOf(),
    private var cursos: MutableList<Curso> = mutableListOf(),
    private var matriculas: MutableList<Matricula> = mutableListOf()) {
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val curso = Curso(nome, codigoDeCurso = codigoCurso, quantidadeMaxima = quantidadeMaximaDeAlunos)
        val procCurso = cursos.find { it == curso }
        if(procCurso !== null) return println("Já existe um Curso cadastrado com o mesmo código, altere e tente novamente")
        cursos.add(curso)
        return println("Curso ${curso.nome} adicionado com sucesso.")
    }

    fun excluirCurso(codigoCurso: Int) {
        val curso = cursos.find { it.codigoDeCurso == codigoCurso }
        if(curso == null) return println("Não foi localizado nenhum Curso com o código informado.")
        cursos.remove(curso)
        return println("Curso ${curso.nome} adicionado com sucesso.")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professor = ProfessorAdjunto(nome, sobrenome, codigoDeProfessor = codigoProfessor, quantidadeDeHoras = quantidadeDeHoras)
        val procProfessor = professores.find {it == professor}
        if(procProfessor !== null) return println("Já existe um Professor cadastrado com o mesmo código, altere e tente novamente.")
        professores.add(professor)
        return println("Professor ${professor.nome} cadastrado com sucesso.")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professor = ProfessorTitular(nome, sobrenome, codigoDeProfessor = codigoProfessor, especialidade = especialidade)
        val procProfessor = professores.find {it == professor}
        if(procProfessor !== null) return println("Já existe um Professor cadastrado com o mesmo código, altere e tente novamente.")
        professores.add(professor)
        return println("Professor ${professor.nome} cadastrado com sucesso.")
    }

    fun excluirProfessor(codigoProfessor: Int) {
        val professor = professores.find { it.codigoDeProfessor == codigoProfessor }
        if(professor == null) return println("Não foi localizado nenhum professor com o código ${codigoProfessor}.")
        professores.remove(professor)
        return println("Professor ${professor.nome} (${professor.codigoDeProfessor}) removido com sucesso.")
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        val procuraAluno = alunos.find {it == aluno}
        if(procuraAluno !== null) return println("Já existe um Aluno cadastrado com o mesmo código, altere e tente novamente.")
        alunos.add(aluno)
        return println("Aluno ${aluno.nome} cadastrado com sucesso.")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        if(alunos.count() <= 0) return println("Nenhum Aluno cadastrado, cadastre um Aluno para realizar a Matrícula.")
        if(cursos.count() <= 0) return println("Nenhum Curso cadastrado, cadastre um Curso para realizar a Matrícula.")

        val aluno = alunos.find { it.codigoDeAluno == codigoAluno }
        val curso = cursos.find { it.codigoDeCurso == codigoCurso }

        if(aluno == null) return println("Aluno inexistente, verifique o código e tente novamente.")
        else if(curso == null) return println("Curso inexistente, verifique o código e tente novamente.")
        else {
            if(curso.adicionarUmAluno(aluno)){
                matriculas.add(Matricula(aluno, curso))
                return println("Aluno ${aluno.nome} cadastrado no curso ${curso.nome} com sucesso.")
            }
            else return println("Não foi possível realizar a matrícula pois não há vagas.")
        }
    }

    fun alocarProfessor(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val curso = cursos.find { it.codigoDeCurso == codigoCurso }
        val professorTitular = professores.find { it.codigoDeProfessor == codigoProfessorTitular }
        val professorAdjunto = professores.find { it.codigoDeProfessor == codigoProfessorAdjunto }

        if(curso == null) return println("Curso inexistente, verifique o código e tente novamente.")
        else if(professorTitular == null || professorTitular !is ProfessorTitular) return println("Professor Titular inexistente, verifique o código e tente novamente.")
        else if(professorAdjunto == null || professorAdjunto !is ProfessorAdjunto) return println("Professor Adjunto inexistente, verifique o código e tente novamente.")
        else {
            val index = cursos.indexOf(curso)
            cursos[index].professorAdjunto = professorAdjunto
            cursos[index].professorTitular = professorTitular
            println("Professor ${professorTitular.nome} adicionado como Titular do curso ${curso.nome}")
            println("Professor ${professorAdjunto.nome} adicionado como Adjunto do curso ${curso.nome}")
        }
    }

    fun consultarMatricula(codigoAluno: Int) {
        val findAluno = alunos.find { aluno -> aluno.codigoDeAluno == codigoAluno }
        if(findAluno !== null) {
            val matriculasDoAluno = matriculas.filter { matricula -> matricula.aluno.codigoDeAluno == codigoAluno}
            if(matriculasDoAluno.count() > 0) {
                println("O aluno ${findAluno.nome} está matriculado nos cursos:")

                matriculasDoAluno.forEach {
                    println(it.curso.nome)
                }
            }
            else {
                println("O aluno ${findAluno.nome} não está matriculado em nenhum curso.")
            }
        }
        else {
            println("Código de Aluno informado não localizado, verifique o código e tente novamente.")
        }
    }
}
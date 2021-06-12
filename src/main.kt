fun main() {
    val digitalManager = DigitalHouseManager()
    digitalManager.registrarProfessorTitular("Cesar", "Rodrigues", 1001, "android")
    digitalManager.registrarProfessorAdjunto("Eduardo", "Misina", 1002, 343434)
    digitalManager.registrarProfessorTitular("Pedro", "Alves", 1003, "angular")
    digitalManager.registrarProfessorAdjunto("Rafael", "Gomes", 1004, 43)
    digitalManager.registrarCurso("Full Stack", 20001, 3)
    digitalManager.registrarCurso("Android", 20002, 2)
    digitalManager.alocarProfessor(20001,1001,1002)
    digitalManager.alocarProfessor(20002, 1003, 1004)
    digitalManager.matricularAluno("Isabela","Pereira", 4001)
    digitalManager.matricularAluno("Diego","Silva", 4002)
    digitalManager.matricularAluno("Ana","Barcelona", 4003)
    digitalManager.matricularAluno("Mariana","Spadafora", 4004)
    digitalManager.matricularAluno("Olivia","Almeida", 4005)
    digitalManager.matricularAluno(4001,20001)
    digitalManager.matricularAluno(4002,20001)
    digitalManager.matricularAluno(4003,20001)
    digitalManager.matricularAluno(4003,20002)
    digitalManager.matricularAluno(4004,20002)
    digitalManager.matricularAluno(4005,20002)

    println(digitalManager);

    digitalManager.consultarMatricula(4003)
}
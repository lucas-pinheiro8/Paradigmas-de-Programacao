import java.util.Date;

static void main() {
    Aluno al1 = new Aluno(1, "Joao", "6", "SI");
    Aluno al2 = new Aluno(2, "Lucas", "8", "ESO");
    Disciplina ds1 = new Disciplina(1, "Programação Orientada à Objetos", "Daniel");

    ds1.matricularAluno(al1);
    ds1.matricularAluno(al2);
    Avaliacao av1 = ds1.criarAvaliacao(1, "Prova Semestral");

    av1.adicionarQuestao(1, "O que é POO?", 2);
    av1.adicionarQuestao(2, "Explique encapsulamento", 3);
    av1.adicionarQuestao(3, "O que é todo-parte?", 5);

    System.out.println(ds1.toString());
}


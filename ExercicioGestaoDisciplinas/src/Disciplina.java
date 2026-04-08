import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome, professor;
    private ArrayList<Aluno> Alunos;
    private ArrayList<Avaliacao> Avaliacoes;

    public Disciplina(){
    }

    public Disciplina(int id, String nome, String professor){
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.Alunos = new ArrayList<>();
        this.Avaliacoes = new ArrayList<>();
    }

    public void matricularAluno(Aluno a){
        Aluno aux = new Aluno();
        this.Alunos.add(a);
        System.out.println("Aluno adicionado à Disciplina!!");
    }

    public Avaliacao criarAvaliacao(int id, String nome){
        Avaliacao aux = new Avaliacao(id, nome);
        this.Avaliacoes.add(aux);
        System.out.println("Avaliação adicionada à Disciplina!!");
        return aux;
    }

    @Override
    public String toString() {
        return "\nDisciplina{\n" +
                "id = " + id +
                ", \nnome = '" + nome + '\'' +
                ", \nprofessor = '" + professor + '\'' +
                ", \nAlunos = " + Alunos +
                ", \nAvaliacoes = " + Avaliacoes +
                '}';
    }
}


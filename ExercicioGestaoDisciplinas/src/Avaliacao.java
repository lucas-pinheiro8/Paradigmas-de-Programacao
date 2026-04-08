import java.util.ArrayList;

public class Avaliacao {
    private int id;
    private String nome;
    private ArrayList<Questao> Questoes;

    public Avaliacao() {
        this.Questoes = new ArrayList<>();
    }

    public Avaliacao(int id, String nome, ArrayList<Questao> questoes) {
        this.id = id;
        this.nome = nome;
        this.Questoes = questoes;
    }

    public Avaliacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.Questoes = new ArrayList<>();
    }

    void adicionarQuestao(int num, String texto, float peso){
        Questao aux = new Questao(num, texto, peso);
        this.Questoes.add(aux);
        System.out.println("Questão adicionada à Avaliação com sucesso!!");
    }

    @Override
    public String toString() {
        return "\nAvaliacao{\n" +
                "id = " + id +
                ", \nnome = '" + nome + '\'' +
                ", \nQuestoes = " + Questoes +
                '}';
    }
}
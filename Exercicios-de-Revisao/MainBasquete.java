
class Atleta {
    private int id;
    private String nome;
    private String posicao;

    public Atleta(int id, String nome, String posicao) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() { return nome; }
    public String getPosicao() { return posicao; }

    @Override
    public String toString() {
        return nome + " | Posição: " + posicao;
    }
}


class Time {
    private int id;
    private String nome;
    private String tecnico;

    // O Time GUARDA referências para atletas externos
    private ArrayList<Atleta> atletas;

    public Time(int id, String nome, String tecnico) {
        this.id = id;
        this.nome = nome;
        this.tecnico = tecnico;
        this.atletas = new ArrayList<>();
    }

    // Método de agregação: recebe um atleta que já existe lá fora
    public void contratarAtleta(Atleta a) {
        atletas.add(a);
        System.out.println(a.getNome() + " foi contratado pelo " + this.nome + "!");
    }

    public void listarElenco() {
        System.out.println("\n=== Elenco do " + nome + " (Técnico: " + tecnico + ") ===");
        for (Atleta a : atletas) {
            System.out.println(" - " + a);
        }
    }
}


public class MainBasquete {
    public static void main(String[] args) {

        // Os atletas são criados FORA do Time — vida própria!
        Atleta atleta1 = new Atleta(1, "Lucas Mariano", "Armador");
        Atleta atleta2 = new Atleta(2, "Rafael Costa", "Pivô");
        Atleta atleta3 = new Atleta(3, "Diego Moura", "Ala");

        Time francaBasquete = new Time(1, "Franca Basquete", "Paulo Henrique");
        francaBasquete.contratarAtleta(atleta1);
        francaBasquete.contratarAtleta(atleta2);
        francaBasquete.contratarAtleta(atleta3);

        francaBasquete.listarElenco();

      
        System.out.println("\n--- Anulando o objeto 'francaBasquete' ");
        francaBasquete = null;

        // O Time foi "destruído", mas os atletas continuam existindo!
        System.out.println("\nO Time foi anulado, mas os atletas ainda existem:");
        System.out.println(atleta1);
        System.out.println(atleta2);
        System.out.println(atleta3);
    }
}

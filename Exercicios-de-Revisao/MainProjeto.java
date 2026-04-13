class Programador {
    private int id;
    private String nome;
    private String linguagemPrincipal;

    public Programador(int id, String nome, String linguagemPrincipal) {
        this.id = id;
        this.nome = nome;
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getNome() { return nome; }
    public String getLinguagemPrincipal() { return linguagemPrincipal; }

    @Override
    public String toString() {
        return nome + " | Linguagem: " + linguagemPrincipal;
    }
}


class Projeto {
    private int id;
    private String nomeProjeto;
    private ArrayList<Programador> programadores;

    public Projeto(int id, String nomeProjeto) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.programadores = new ArrayList<>();
    }

    public void adicionarProgramador(Programador p) {
        programadores.add(p);
    }

    // Método para listar todos os programadores do projeto
    public void listarProgramadores() {
        System.out.println("\n=== Programadores do Projeto: " + nomeProjeto + " ===");
        if (programadores.isEmpty()) {
            System.out.println("Nenhum programador alocado ainda.");
        } else {
            for (Programador p : programadores) {
                System.out.println(" - " + p);
            }
        }
        System.out.println("Total: " + programadores.size() + " programador(es)");
    }
}


public class MainProjeto {
    public static void main(String[] args) {

        // Programadores existem de forma independente
        Programador p1 = new Programador(1, "Fernanda Rocha", "Java");
        Programador p2 = new Programador(2, "Bruno Alves", "Python");
        Programador p3 = new Programador(3, "Camila Neves", "JavaScript");

        Projeto projetoApp = new Projeto(1, "App Mobile de Vendas");
        projetoApp.adicionarProgramador(p1);
        projetoApp.adicionarProgramador(p2);
        projetoApp.adicionarProgramador(p3);
        projetoApp.listarProgramadores();

        // Fernanda também pode estar em outro projeto (agregação!)
        Projeto projetoWeb = new Projeto(2, "Portal Web Corporativo");
        projetoWeb.adicionarProgramador(p1); // mesma Fernanda!
        projetoWeb.listarProgramadores();
    }
}

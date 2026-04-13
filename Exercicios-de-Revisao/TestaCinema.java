class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int duracao; // em minutos

    public Filme(int id, String titulo, String genero, int duracao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracao() { return duracao; }

    @Override
    public String toString() {
        return "\"" + titulo + "\" | " + genero + " | " + duracao + " min";
    }
}


class Ingresso {
    private int id;
    private String assento;
    private String tipo;   // "Inteira" ou "Meia"
    private float preco;

    public Ingresso(int id, String assento, String tipo, float preco) {
        this.id = id;
        this.assento = assento;
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("  [%s] Assento %-4s | %-8s | R$ %.2f",
                "#" + id, assento, tipo, preco);
    }
}


class Sessao {
    private int id;
    private LocalDateTime horario;
    private int sala;

    private Filme filme;                     // AGREGAÇÃO
    private ArrayList<Ingresso> ingressos;  // COMPOSIÇÃO
    private int proximoIngressoId = 1;

    public Sessao(int id, LocalDateTime horario, int sala) {
        this.id = id;
        this.horario = horario;
        this.sala = sala;
        this.ingressos = new ArrayList<>();
        // Filme não é criado aqui — vem de fora (Agregação)
    }

    // AGREGAÇÃO: recebe um objeto Filme já existente
    public void vincularFilme(Filme f) {
        this.filme = f;
        System.out.println("Filme \"" + f.getTitulo() + "\" vinculado à sessão #" + id);
    }

    // COMPOSIÇÃO: cria o Ingresso internamente com dados primitivos
    public void venderIngresso(int id, String assento, String tipo, float preco) {
        Ingresso ingresso = new Ingresso(id, assento, tipo, preco);
        ingressos.add(ingresso);
        System.out.println("Ingresso vendido — Assento " + assento + " (" + tipo + ")");
    }

  
}


public class TestaCinema {
    public static void main(String[] args) {

        // 1. Instancia 2 filmes (existem no catálogo independente)
        Filme batman = new Filme(1, "Batman", "Ação", 176);
        Filme duna   = new Filme(2, "Duna",   "Ficção Científica", 155);

        System.out.println("Filmes disponíveis no catálogo:");
        System.out.println("  " + batman);
        System.out.println("  " + duna);
        System.out.println();

        // 2. Instancia uma Sessão
        LocalDateTime horario = LocalDateTime.of(2026, 7, 20, 20, 0);
        Sessao sessao = new Sessao(1, horario, 1);

        // 3. AGREGAÇÃO: vincula o Batman a esta sessão
        sessao.vincularFilme(batman);

        // 4. COMPOSIÇÃO: vende 3 ingressos (criados dentro da Sessão)
        sessao.venderIngresso(1, "A1", "Inteira", 30.00f);
        sessao.venderIngresso(2, "A2", "Meia",    15.00f);
        sessao.venderIngresso(3, "A3", "Inteira", 30.00f);

        // 5. Imprime os dados da Sessão
        System.out.println();
        System.out.println(sessao);

        // Prova: mesmo depois, o Duna ainda existe no catálogo (agregação)
        System.out.println("\nO filme Duna ainda existe no catálogo: " + duna);
    }
}

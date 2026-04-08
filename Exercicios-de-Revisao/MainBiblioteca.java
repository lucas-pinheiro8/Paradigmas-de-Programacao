import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ─────────────────────────────────────────────
//  Classe Leitor
// ─────────────────────────────────────────────
class Leitor {
    private int id;
    private String nome;

    public Leitor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
}

// ─────────────────────────────────────────────
//  Classe Livro
// ─────────────────────────────────────────────
class Livro {
    private int id;
    private String titulo;
    private String autor;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
}

// ─────────────────────────────────────────────
//  Classe de Associação: Emprestimo
// ─────────────────────────────────────────────
class Emprestimo {

    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;

    // Referências para os objetos que já existem fora desta classe
    private Leitor leitor;
    private Livro livro;

    public Emprestimo(LocalDateTime dataEmprestimo, LocalDateTime dataDevolucaoPrevista,
                      Leitor leitor, Livro livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.leitor = leitor;
        this.livro = livro;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "========== EMPRÉSTIMO ==========\n"
             + "Leitor          : " + leitor.getNome() + "\n"
             + "Livro           : " + livro.getTitulo() + " (" + livro.getAutor() + ")\n"
             + "Data Empréstimo : " + dataEmprestimo.format(fmt) + "\n"
             + "Devolução Prev. : " + dataDevolucaoPrevista.format(fmt) + "\n"
             + "================================";
    }
}

// ─────────────────────────────────────────────
//  Main
// ─────────────────────────────────────────────
public class MainBiblioteca {
    public static void main(String[] args) {
        Leitor leitor = new Leitor(1, "Mariana Lima");
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");

        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime devolucao = hoje.plusDays(14); // 2 semanas para devolver

        Emprestimo emp = new Emprestimo(hoje, devolucao, leitor, livro);
        System.out.println(emp);
    }
}

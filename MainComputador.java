// ─────────────────────────────────────────────
//  Classe Processador
//
//  Objeto "parte" — não faz sentido existir
//  sozinho fora de um Computador neste sistema.
// ─────────────────────────────────────────────
class Processador {
    private String marca;
    private String modelo;
    private double frequencia; // em GHz

    public Processador(String marca, String modelo, double frequencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " @ " + frequencia + " GHz";
    }
}

// ─────────────────────────────────────────────
//  Classe Computador
//
//  COMPOSIÇÃO: O Computador CRIA o Processador
//  dentro do seu próprio construtor.
//
//  Isso significa:
//  • O processador NÃO pode existir antes do computador
//  • O processador NÃO existe depois que o computador é destruído
//  • Não existe referência externa ao processador
//
//  Analogia: o processador é SOLDADO na placa-mãe.
//  Se o computador for destruído, o processador vai junto.
// ─────────────────────────────────────────────
class Computador {
    private int id;
    private String marca;

    // O processador é criado AQUI DENTRO — ninguém de fora acessa
    private Processador processador;

    public Computador(int id, String marca, String marcaProc, String modeloProc, double freq) {
        this.id = id;
        this.marca = marca;

        // COMPOSIÇÃO: o processador nasce junto com o computador
        this.processador = new Processador(marcaProc, modeloProc, freq);
    }

    @Override
    public String toString() {
        return "Computador #" + id + " | Marca: " + marca + "\n"
             + "  └─ Processador: " + processador;
    }
}

// ─────────────────────────────────────────────
//  Main
// ─────────────────────────────────────────────
public class MainComputador {
    public static void main(String[] args) {

        Computador pc = new Computador(1, "Dell", "Intel", "Core i7-13700", 3.4);
        System.out.println(pc);

        // Note: não temos como acessar o processador diretamente de fora.
        // Ele existe APENAS dentro do computador.

        // Se o computador for anulado, o processador some junto:
        System.out.println("\nAnulando o computador...");
        pc = null;
        System.out.println("O processador não pode ser acessado — ele dependia do computador!");
    }
}

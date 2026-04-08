import java.util.ArrayList;

// ─────────────────────────────────────────────
//  Classe Apartamento
//
//  Objeto "parte" — um apartamento sem edifício
//  não tem sentido de existir neste sistema.
// ─────────────────────────────────────────────
class Apartamento {
    private int numero;
    private int andar;

    public Apartamento(int numero, int andar) {
        this.numero = numero;
        this.andar = andar;
    }

    @Override
    public String toString() {
        return "Apto " + numero + " | " + andar + "º Andar";
    }
}

// ─────────────────────────────────────────────
//  Classe Edificio
//
//  COMPOSIÇÃO: O Edifício é o "todo".
//  Ele cria os apartamentos internamente.
//  Quem chama o método só passa números primitivos.
//
//  Se o Edifício for demolido, os apartamentos
//  deixam de existir com ele.
// ─────────────────────────────────────────────
class Edificio {
    private String nome;
    private String endereco;

    private ArrayList<Apartamento> apartamentos;

    public Edificio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.apartamentos = new ArrayList<>();
    }

    /**
     * COMPOSIÇÃO:
     * O objeto Apartamento é criado DENTRO deste método.
     * O usuário externo não precisa criar o Apartamento — só passa os dados.
     */
    public void construirApartamento(int num, int andar) {
        Apartamento apto = new Apartamento(num, andar); // criado internamente!
        apartamentos.add(apto);
        System.out.println("Apartamento " + num + " construído no " + andar + "º andar.");
    }

    public void listarApartamentos() {
        System.out.println("\n=== " + nome + " | " + endereco + " ===");
        System.out.println("Total de apartamentos: " + apartamentos.size());
        for (Apartamento a : apartamentos) {
            System.out.println("  • " + a);
        }
    }
}

// ─────────────────────────────────────────────
//  Main
// ─────────────────────────────────────────────
public class MainEdificio {
    public static void main(String[] args) {

        Edificio edificio = new Edificio("Residencial Aurora", "Av. Brasil, 1500 - Franca/SP");

        // Passamos apenas tipos primitivos — o objeto é criado DENTRO do Edifício
        edificio.construirApartamento(101, 1);
        edificio.construirApartamento(102, 1);
        edificio.construirApartamento(201, 2);
        edificio.construirApartamento(202, 2);
        edificio.construirApartamento(301, 3);

        edificio.listarApartamentos();
    }
}

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


class Edificio {
    private String nome;
    private String endereco;

    private ArrayList<Apartamento> apartamentos;

    public Edificio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.apartamentos = new ArrayList<>();
    }


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

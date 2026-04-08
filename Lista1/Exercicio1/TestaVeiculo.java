public class TestaVeiculo {

    public static void main(String[] args) {
        Veiculo veiculo;

        veiculo = new Aviao("Boeing", "747", 900, 12000);
        veiculo.mover();
        veiculo.abastecer();

        veiculo = new CarroEletrico("Tesla", "Model 3", 250, 500);
        veiculo.mover();
        veiculo.abastecer();
    }
}

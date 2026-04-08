public class TestaVetorPolimorfico {

    public static void main(String[] args) {
        Desenvolvedor[] equipe = new Desenvolvedor[4];

        equipe[0] = new Junior("Fulano", "Java", 5000, "Beltrano");
        equipe[1] = new Pleno("Beltrano", "Java", 10000, 7);
        equipe[2] = new Senior("Ciclano", "Java", 12000, 3000);
        equipe[3] = new Desenvolvedor("Generico", "Python", 7000);

        for (Desenvolvedor dev : equipe) {
            dev.codar();
            System.out.println("Bônus: " + dev.calcularBonus());
            System.out.println(dev.toString());
            System.out.println("---");
        }
    }
}

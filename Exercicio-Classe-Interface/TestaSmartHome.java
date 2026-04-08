public class TestaSmartHome {

    public static void main(String[] args) {

        System.out.println("=== Testando FechaduraEletronica ===");
        FechaduraEletronica fechadura = new FechaduraEletronica("1234");
        fechadura.validarAcesso("0000"); // senha errada
        fechadura.validarAcesso("1234"); // senha correta -> destravar
        fechadura.desligar();            // travar novamente
        System.out.println(fechadura);

        System.out.println();

        System.out.println("=== Testando TermostatoSmart ===");
        TermostatoSmart termostato = new TermostatoSmart(23.5);
        termostato.lerTemperatura(); // desligado, não deve ler
        termostato.ligar();
        termostato.lerTemperatura(); // ligado, deve ler
        termostato.setTemperatura(26.0);
        termostato.lerTemperatura();
        termostato.desligar();
        System.out.println(termostato);
    }
}

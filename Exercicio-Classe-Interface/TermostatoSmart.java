public class TermostatoSmart implements DispositivoLigavel, SensorTemperatura {
    private boolean ligado;
    private double temperatura;

    public TermostatoSmart(double temperatura) {
        this.ligado = false;
        this.temperatura = temperatura;
    }

    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("TermostatoSmart: Termostato ligado.");
    }

    @Override
    public void desligar() {
        this.ligado = false;
        System.out.println("TermostatoSmart: Termostato desligado.");
    }

    @Override
    public double lerTemperatura() {
        if (this.ligado) {
            System.out.println("TermostatoSmart: Temperatura atual = " + this.temperatura + "°C");
            return this.temperatura;
        } else {
            System.out.println("TermostatoSmart: Dispositivo desligado, não é possível ler a temperatura.");
            return -1;
        }
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "TermostatoSmart{" +
                "ligado=" + ligado +
                ", temperatura=" + temperatura +
                '}';
    }
}

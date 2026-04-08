public class Questao {
    private String numero, enunciado;
    private float valor;

    public Questao(){
    }

    public Questao(float valor, String enunciado, String numero) {
        this.valor = valor;
        this.enunciado = enunciado;
        this.numero = numero;
    }

    public Questao(int num, String texto, float peso) {
        this.numero = String.valueOf(num);
        this.enunciado = texto;
        this.valor = peso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nQuestao\n{" +
                "numero = '" + numero + '\'' +
                ", enunciado = '" + enunciado + '\'' +
                ", valor = " + valor +
                '}';
    }
}
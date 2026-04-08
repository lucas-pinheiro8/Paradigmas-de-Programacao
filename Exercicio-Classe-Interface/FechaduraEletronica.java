public class FechaduraEletronica implements Autenticavel, DispositivoLigavel {
    private String senhaCorreta;
    private boolean destravada;

    public FechaduraEletronica(String senhaCorreta) {
        this.senhaCorreta = senhaCorreta;
        this.destravada = false;
    }

    @Override
    public void validarAcesso(String senha) {
        if (senha.equals(this.senhaCorreta)) {
            System.out.println("FechaduraEletronica: Senha correta! Acesso permitido.");
            ligar();
        } else {
            System.out.println("FechaduraEletronica: Senha incorreta! Acesso negado.");
        }
    }

    @Override
    public void ligar() {
        this.destravada = true;
        System.out.println("FechaduraEletronica: Fechadura destravada.");
    }

    @Override
    public void desligar() {
        this.destravada = false;
        System.out.println("FechaduraEletronica: Fechadura travada.");
    }

    public boolean isDestravada() {
        return destravada;
    }

    @Override
    public String toString() {
        return "FechaduraEletronica{" +
                "destravada=" + destravada +
                '}';
    }
}

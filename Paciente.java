public class Paciente {
    private int id;
    private String nome;
    private String cpf;

    public Paciente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return "Paciente: " + nome + " | CPF: " + cpf;
    }
}

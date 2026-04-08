public class Medico {
    private int id;
    private String nome;
    private String especialidade;

    public Medico(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }

    @Override
    public String toString() {
        return "Dr(a). " + nome + " | Especialidade: " + especialidade;
    }
}

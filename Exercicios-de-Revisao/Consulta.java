public class Consulta {

    private LocalDateTime data;
    private float valorDaConsulta;

    /
    private Medico medico;
    private Paciente paciente;

    public Consulta(LocalDateTime data, double valorDaConsulta, Medico medico, Paciente paciente) {
        this.data = data;
        this.valorDaConsulta = valorDaConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }

    public LocalDateTime getData() { return data; }
    public double getValorDaConsulta() { return valorDaConsulta; }
    public Medico getMedico() { return medico; }
    public Paciente getPaciente() { return paciente; }

    @Override
    public String toString() {
    return " = CONSULTA = \n"
             + "Data/Hora : " + data + "\n"
             + "Médico    : " + medico.getNome() + " (" + medico.getEspecialidade() + ")\n"
             + "Paciente  : " + paciente.getNome() + "\n"
             + "Valor     : R$ " + String.format("%.2f", valorDaConsulta) + "\n"
             + ";
    }
}

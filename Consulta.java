import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * CLASSE DE ASSOCIAÇÃO
 * -------------------------------------------------------------------
 * Uma Classe de Associação é usada quando o RELACIONAMENTO em si
 * precisa ter dados próprios. Aqui, a consulta é o "elo" entre
 * Médico e Paciente, mas ela mesma tem atributos (data, valor).
 *
 * Pense assim: um médico atende muitos pacientes, e um paciente
 * pode ser atendido por muitos médicos. O QUE REGISTRA esse momento
 * específico é a Consulta — ela guarda "quem atendeu quem, quando e por quanto".
 * -------------------------------------------------------------------
 */
public class Consulta {

    private LocalDateTime data;
    private double valorDaConsulta;

    // A Consulta REFERENCIA os objetos Médico e Paciente que já existem
    // Isso é uma ASSOCIAÇÃO: ela conhece os dois, mas não os cria nem os destrói
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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        return "========== CONSULTA ==========\n"
             + "Data/Hora : " + data.format(fmt) + "\n"
             + "Médico    : " + medico.getNome() + " (" + medico.getEspecialidade() + ")\n"
             + "Paciente  : " + paciente.getNome() + "\n"
             + "Valor     : R$ " + String.format("%.2f", valorDaConsulta) + "\n"
             + "==============================";
    }
}

import java.time.LocalDateTime;

public class MainClinica {
    public static void main(String[] args) {

        // 1. Cria os objetos independentes
        Medico medico = new Medico(1, "Ana Souza", "Cardiologia");
        Paciente paciente = new Paciente(1, "Carlos Oliveira", "123.456.789-00");

        // 2. Cria a Consulta (classe de associação) passando os dois objetos
        //    LocalDateTime.of(ano, mês, dia, hora, minuto)
        LocalDateTime dataConsulta = LocalDateTime.of(2026, 5, 20, 14, 30);
        Consulta consulta = new Consulta(dataConsulta, 350.00, medico, paciente);

        // 3. Exibe o resultado
        System.out.println(consulta);

        // Perceba: mesmo depois de criar a consulta, médico e paciente
        // continuam existindo de forma independente!
        System.out.println("\nMédico ainda existe: " + medico);
        System.out.println("Paciente ainda existe: " + paciente);
    }
}

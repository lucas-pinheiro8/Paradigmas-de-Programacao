public class MainClinica {
    public static void main(String[] args) {

       
        Medico medico = new Medico(1, "Ana Souza", "Cardiologia");
        Paciente paciente = new Paciente(1, "Carlos Oliveira", "123.456.789-00");

       
        LocalDateTime dataConsulta = LocalDateTime.of(2026, 5, 20, 14, 30);
        Consulta consulta = new Consulta(dataConsulta, 350.00, medico, paciente);

       
        System.out.println(consulta);

       
        System.out.println("\nMédico ainda existe: " + medico);
        System.out.println("Paciente ainda existe: " + paciente);
    }
}

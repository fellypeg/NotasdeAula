package NotadeAula3.Questão1;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Carlos", "15/05/1985", 10000.00, "Sistema de Vendas");
        Programador programador = new Programador("Fellype", "12/02/2007", 6000.00, "Java");

        gerente.informarSalario();
        gerente.informarProjeto();

        programador.informarSalario();
        programador.informarLinguagem();

        int anoAtual = 2024;
        System.out.printf("Idade de %s: %.0f anos%n", gerente.nome, gerente.calcularIdade(anoAtual));
        System.out.printf("Idade de %s: %.0f anos%n", programador.nome, programador.calcularIdade(anoAtual));
    }
}

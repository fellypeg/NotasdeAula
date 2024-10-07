package NotaAula1.Questão1;
import java.util.Scanner;

public class SituacaoAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        aluno aluno = new aluno(nome, nota1, nota2, nota3);

        double media = aluno.calcularMedia();
        String situacao = aluno.resultado();

        System.out.println("\nMédia do aluno " + aluno.getNome() +":"+ media);
        System.out.println("Situação: " + situacao);

        scanner.close();
    }
}

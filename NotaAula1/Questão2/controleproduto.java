package NotaAula1.Questão2;
import java.util.Scanner;

public class controleproduto{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro do Produto ===");
        System.out.print("Código do Produto: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Tamanho/Peso do Produto: ");
        String tamanhoPeso = scanner.nextLine();

        System.out.print("Cor do Produto: ");
        String cor = scanner.nextLine();

        System.out.print("Valor do Produto: ");
        double valor = scanner.nextDouble();

        System.out.print("Quantidade no Estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);

        System.out.println("\nProduto cadastrado com sucesso!");
        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Valor: " + produto.getValor());
        System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEstoque());


        System.out.println("\n=== Venda de Produto ===");
        System.out.print("Quantidade a ser vendida: ");
        int quantidadeVenda = scanner.nextInt();

        if (produto.venderProduto(quantidadeVenda)) {
            System.out.println("Escolha o método de pagamento:");
            System.out.println("1. Pix");
            System.out.println("2. Espécie");
            System.out.println("3. Transferência");
            System.out.println("4. Débito");
            System.out.println("5. Crédito (parcelado em até 3x sem juros)");
            int metodoPagamento = scanner.nextInt();

            double valorFinal = produto.getValor() * quantidadeVenda;
            double desconto = 0;

            switch (metodoPagamento) {
                case 1: // Pix
                case 3: // Transferência
                case 4: // Débito
                    desconto = valorFinal * 0.05; 
                    valorFinal -= desconto;
                    break;

                case 2: // Espécie
                    desconto = valorFinal * 0.05; 
                    valorFinal -= desconto;
                    System.out.print("Digite o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    if (valorPago > valorFinal) {
                        double troco = valorPago - valorFinal;
                        System.out.println("Troco: R$ " + troco);
                    } else if (valorPago < valorFinal) {
                        System.out.println("Valor insuficiente para a compra.");
                        return;
                    }
                    break;

                case 5: // Crédito
                    System.out.println("Parcelar em até 3x sem juros.");
                    System.out.print("Digite o número de parcelas (1 a 3): ");
                    int parcelas = scanner.nextInt();
                    double valorParcela = valorFinal / parcelas;
                    System.out.printf("Compra parcelada em %d vezes de R$ %.2f sem juros.\n", parcelas, valorParcela);
                    break;
                default:
                    System.out.println("Método de pagamento inválido.");
                    return;
            }
            System.out.println("\nResumo da venda:");
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Quantidade vendida: " + quantidadeVenda);
            System.out.println("Valor total: R$ " + valorFinal);
            if (desconto > 0) {
                System.out.println("Desconto aplicado: R$ " + desconto);
            }
            System.out.println("Quantidade restante no estoque: " + produto.getQuantidadeEstoque());
        }

        scanner.close();
    }
}


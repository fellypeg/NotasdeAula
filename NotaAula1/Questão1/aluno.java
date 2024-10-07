package NotaAula1.Questão1;
public class aluno {
        private String nome;
        private double nota1;
        private double nota2;
        private double nota3;
    
        public aluno(String nome, double nota1, double nota2, double nota3) {
            this.nome = nome;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
        }

        public double calcularMedia() {
            return (nota1 + nota2 + nota3) / 3;
        }
    
        public String resultado() {
            double media = calcularMedia();
            if (media >= 70) {
                return "Aprovado";
            } else if (media < 40) {
                return "Reprovado";
            } else {
                return "Final";
            }
        }
        public String getNome() {
            return nome;
        }
    }
    

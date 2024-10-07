package NotadeAula3.Questão1;

class Funcionario {
    protected String nome;
    protected String nasc; 
    protected double salario;

    public Funcionario(String nome, String nasc, double salario) {
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
    }

    public void informarSalario() {
        System.out.printf("Salário de %s: R$ %.2f%n", nome, salario);
    }

    public double calcularIdade(int anoAtual) {
        String[] partesData = nasc.split("/");
        int anoNascimento = Integer.parseInt(partesData[2]); 
        return anoAtual - anoNascimento;
    }
}

class Gerente extends Funcionario {
    private String projeto;

    public Gerente(String nome, String nasc, double salario, String projeto) {
        super(nome, nasc, salario);
        this.projeto = projeto;
    }

    public void informarProjeto() {
        System.out.printf("Gerente %s está gerenciando o projeto: %s%n", nome, projeto);
    }
}

class Programador extends Funcionario {
    private String linguagem;

    public Programador(String nome, String nasc, double salario, String linguagem) {
        super(nome, nasc, salario);
        this.linguagem = linguagem;
    }

    public void informarLinguagem() {
        System.out.printf("Programador %s trabalha com a linguagem: %s%n", nome, linguagem);
    }
}
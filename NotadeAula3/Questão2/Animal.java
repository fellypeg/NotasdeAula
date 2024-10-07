package NotadeAula3.Questão2;

class Animal {
    protected String nome; 
    protected String raca; 

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void emitirSom() {
        System.out.printf("%s está emitindo som.%n", nome);
    }
}

class Cachorro extends Animal {
    
    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    @Override
    public void emitirSom() {
        System.out.printf("%s, o cachorro da raça %s, faz: Au Au!%n", nome, raca);
    }

    public void mia() {
        System.out.printf("%s não pode miar!%n", nome);
    }
}

class Gato extends Animal {
    
    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    @Override
    public void emitirSom() {
        System.out.printf("%s, o gato da raça %s, faz: Miau!%n", nome, raca);
    }

    public void mia() {
        System.out.printf("%s, o gato da raça %s, mia!%n", nome, raca);
    }
}

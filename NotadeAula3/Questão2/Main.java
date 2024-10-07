package NotadeAula3.Questão2;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("nick", "Yorkshire");
        Gato gato = new Gato("zara", "Siamês");

        cachorro.emitirSom();
        gato.emitirSom();

        gato.mia();
        
        cachorro.mia(); 
    }
}
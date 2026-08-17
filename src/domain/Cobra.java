package domain;

public class Cobra extends Animal {
    public Cobra(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    @Override
    public void emitirSom() {
        System.out.println("SSSSSSSSSSS");
    }

    @Override
    public void animalComer() {
        System.out.println("A cobra" + this.nome + " foi alimentada com "+Alimentos.PEQUENOS_ANIMAIS);
    }
}

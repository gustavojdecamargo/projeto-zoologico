package domain;

public class Elefante extends Animal {
    public Elefante(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de elefante!");
    }

    @Override
    public void animalComer() {
        System.out.println("O elefante" + this.nome + " foi alimentado com "+Alimentos.FRUTAS);
    }
}

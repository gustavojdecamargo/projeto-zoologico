package domain;

public class Arara extends Animal {
    public Arara(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    @Override
    public void emitirSom() {
        System.out.println("IAAAARRR");
    }

    @Override
    public void animalComer() {
        System.out.println("A domain.Arara" + this.nome + "foi alimentada com "+Alimentos.FRUTAS);
    }
}

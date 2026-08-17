package domain;

public class Macaco extends Animal {
    public Macaco(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    @Override
    public void emitirSom() {
        System.out.println("AAA AAA AAA");
    }

    @Override
    public void animalComer() {
        System.out.println("O domain.Macaco" + this.nome + " foi alimentado com "+Alimentos.FRUTAS );
    }
}

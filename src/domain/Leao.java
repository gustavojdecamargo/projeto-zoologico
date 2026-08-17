package domain;

public class Leao extends Animal {
    public Leao(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    @Override
    public void emitirSom() {
        System.out.println("ROOOAR");
    }

    @Override
    public void animalComer() {
        System.out.println("O Leão" + this.nome + " foi alimentado com "+Alimentos.CARNE);
    }
}

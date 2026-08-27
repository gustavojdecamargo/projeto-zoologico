package domain.animals;

import domain.enums.Alimentos;
import domain.enums.Especies;
import domain.Recinto;
import domain.enums.Sexo;

public class Macaco extends Animal {
    public Macaco(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    public Macaco(Especies especie) {
        super(especie);
    }

        @Override
    public void emitirSom() {
        System.out.println("AAA AAA AAA");
    }

    @Override
    public void animalComer() {
        System.out.println("O Macaco " + this.nome + " foi alimentado com "+ Alimentos.FRUTAS );
    }
}

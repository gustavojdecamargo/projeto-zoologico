package domain.animals;

import domain.enums.Alimentos;
import domain.enums.Especies;
import domain.Recinto;
import domain.enums.Sexo;

public class Elefante extends Animal {
    public Elefante(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    public Elefante(Especies especie) {
        super(especie);
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de elefante!");
    }

    @Override
    public void animalComer() {
        System.out.println("O elefante " + this.nome + " foi alimentado com "+ Alimentos.FRUTAS);
    }
}

package domain.animals;

import domain.enums.Alimentos;
import domain.enums.Especies;
import domain.Recinto;
import domain.enums.Sexo;

public class Arara extends Animal {
    public Arara(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    public Arara(Especies especie) {
        super(especie);
    }

        @Override
    public void emitirSom() {
        System.out.println("IAAAARRR");
    }

    @Override
    public void animalComer() {
        System.out.println("A Arara " + this.nome + " foi alimentada com "+ Alimentos.FRUTAS);
    }
}

package domain.animals;

import domain.enums.Alimentos;
import domain.enums.Especies;
import domain.Recinto;
import domain.enums.Sexo;

public class Leao extends Animal {
    public Leao(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        super(nome, idade, peso, especie, sexo, recinto);
    }

    public Leao(Especies especie){
        super(especie);
    }

    @Override
    public void emitirSom() {
        System.out.println("ROOOAR");
    }

    @Override
    public void animalComer() {
        System.out.println("O Leão " + this.nome + " foi alimentado com "+ Alimentos.CARNE);
    }
}

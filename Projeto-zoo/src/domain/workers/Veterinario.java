package domain.workers;

import domain.animals.Animal;
import domain.enums.Cargo;

public class Veterinario extends Funcionario {
    public Veterinario(String nome, int idade, double salario, Cargo cargo) {
        super(nome, idade, salario, cargo);
    }

    public void examinarAnimal(Animal animal){
        System.out.println("O veterinário "+this.getNome()+"examinou o/a "+ animal.getEspecie() +" "+animal.getNome());
    }
}
package domain;

public class Veterinario extends Funcionario{
    public Veterinario(String nome, int idade, double salario, String cargo) {
        super(nome, idade, salario, cargo);
    }

    public void examinarAnimal(Animal animal){
        System.out.println("O veterinário "+this.getNome()+"examinou o/a "+animal.especie+" "+animal.nome);
    }
}
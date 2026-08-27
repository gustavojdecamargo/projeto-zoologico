package domain.workers;

import domain.enums.Cargo;

public class Funcionario {
    private String nome;
    private int idade;
    private double salario;
    private Cargo cargo;

    public Funcionario(String nome, int idade, double salario, Cargo cargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return "Nome: " + nome +
                "\nIdade: " + idade +
                "\nSalário: " + salario +
                "\nCargo: " + cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
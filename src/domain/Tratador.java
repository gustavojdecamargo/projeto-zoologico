package domain;

public class Tratador extends Funcionario{
    public Tratador(String nome, int idade, double salario, String cargo) {
        super(nome, idade, salario, cargo);
    }

    public void alimentarAnimal(Animal animal){
        System.out.println("O tratador "+this.getNome()+"alimentou o/a "+animal.getEspecie()+" "+animal.getNome());
    }

    public void limparRecinto(Recinto recinto){
        System.out.println("O tratador "+this.getNome()+"limpou o recinto número "+recinto.getNumero());
    }
}

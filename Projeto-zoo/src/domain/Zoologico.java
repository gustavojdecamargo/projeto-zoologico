package domain;

import domain.animals.Animal;
import domain.workers.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private String nome;
    public List<Recinto> recintos = new ArrayList<>();
    public List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarRecinto(Recinto recinto){
        recintos.add(recinto);
        System.out.println("Recinto adicionado.");
    }

    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado");
    }

    public List<Recinto> listarRecintos(){
        return recintos;
    }

    public void listarFuncionarios(){
        for (Funcionario funcionario : getFuncionarios()){
            System.out.println(funcionario.toString());
            System.out.println();;
        }
    }

    public boolean verificadorDeAnimais(){
        for (Recinto recinto : listarRecintos()){
            if (recinto.getAnimais().size() != 0){
                return true;
            }
        }
        return false;
    }

    public boolean verificadorDeRecintos(){
        if (listarRecintos().size() != 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean verificadorDeFuncionarios(){
        if (getFuncionarios().size() != 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean verificadorSeRecintoExiste(String nome){
        for (Recinto recinto : listarRecintos()){
            if (recinto.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public boolean verificadorSeRecintoExiste(int id){
        for (Recinto recinto : listarRecintos()){
            if (recinto.getNumero() == id){
                return true;
            }
        }

        return false;
    }

    public String buscarAnimal(String nome){
        for (Recinto recinto : recintos){
            for (Animal animal : recinto.getAnimais()){
                if (animal.getNome().equals(nome)){
                    return "Animal encontrado no recinto " + recinto.getNome() + ".";
                }
            }
        }

        return "Esse animal não existe no zoológico!";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(List<Recinto> recintos) {
        this.recintos = recintos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
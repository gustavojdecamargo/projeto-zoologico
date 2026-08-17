package domain;

import java.util.List;

public class Zoologico {
    private String nome;
    public List<Recinto> recintos;
    public List<Funcionario> funcionarios;

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

    public List<Funcionario> listarFuncionarios(){
        return funcionarios;
    }

    public void buscarAnimal(String nome){
        for (int i = 0; i < recintos.size(); i++) {
            if(recintos.get(i).animais.contains(nome)){
                System.out.println("Animal encontrado no recinto"+recintos.get(i).getNumero());
            }
        }
    }
}
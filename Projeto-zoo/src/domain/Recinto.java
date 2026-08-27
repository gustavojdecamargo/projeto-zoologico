package domain;

import domain.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Recinto {
    private int numero;
    private String nome;
    private int capacidade;
    public List<Animal> animais = new ArrayList<>();

    public Recinto(String nome, int capacidade, int numero) {
        this.numero = numero;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public Recinto() {

    }

    public void adicionarAnimal(Animal animal){
        if(animais.size() < capacidade){
            animais.add(animal);
            System.out.println("Animal adicionado ao recinto.");
        } else {
            System.out.println("O recinto está lotado, o animal não pode ser adicionado!");
        }
    }

    public void removerAnimal(Animal animal){
        if(animais.contains(animal)){
            animais.remove(animal);
            System.out.println("Animal removido.");
        } else {
            System.out.println("O animal não está nesse recinto!");
        }
    }

    public boolean estaLotado(){
        if(animais.size() == capacidade){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "Id: " + numero +
                "\nNome:" + nome +
                "\nCapacidade: " + capacidade +
                "\nAnimais: " + animais.toString();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
}
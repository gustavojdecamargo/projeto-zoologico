package domain;

import java.util.List;

public class Recinto {
    private int numero = 0;
    private String nome;
    private int capacidade;
    public List<Animal> animais;

    public Recinto(int numero, String nome, int capacidade, List<Animal> animais) {
        /* Teste de Id automático */
        this.numero += 1;
        this.nome = nome;
        this.capacidade = capacidade;
        this.animais = animais;
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

    public List<Animal> listarAnimais(){
        return animais;
    }

    public boolean estaLotado(){
        if(animais.size() == capacidade){
            return true;
        } else {
            return false;
        }
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
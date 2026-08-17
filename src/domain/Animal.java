package domain;

public abstract class Animal {
    protected String nome;
    protected int idade;
    protected double peso;
    protected Especies especie;
    protected Sexo sexo;
    protected Recinto recinto;

    public Animal(String nome, int idade, double peso, Especies especie, Sexo sexo, Recinto recinto) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.especie = especie;
        this.sexo = sexo;
        this.recinto = recinto;
    }

    public void exibirDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Peso: " + this.peso);
        System.out.println("Espécie: " + this.especie);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Recinto: " + recinto);
    }

    public abstract void emitirSom();

    public abstract void animalComer();

    public void animalDormir(){
        System.out.println(this.nome + "Dormiu");
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Especies getEspecie() {
        return especie;
    }

    public void setEspecie(Especies especie) {
        this.especie = especie;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }
}

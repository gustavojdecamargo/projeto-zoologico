package service;

import domain.*;

import java.util.List;
import java.util.Scanner;

public class ZoologicoServices {
    Zoologico zoologico = new Zoologico();
    Scanner scanner = new Scanner(System.in);

    public ZoologicoServices(Zoologico zoologico){
        this.zoologico = zoologico;
    }

    public void cadastrarAnimal(){
        if (zoologico.recintos != null){
            int cont = 0;
            List<Recinto> recintosVazios = List.of();
            for (Recinto recinto : zoologico.recintos){
                if (recinto.estaLotado() == false) {
                    cont += 1;
                    recintosVazios.add(recinto);
                }
            }

            if (cont != 0){
                System.out.println("Recintos disponíveis.");
                for (int i = 0; i < cont; i++) {
                    System.out.println(cont + " - " + recintosVazios.get(i) + " | " + recintosVazios.get(i).animais.size() + "/" + recintosVazios.get(i).getCapacidade());
                }
                System.out.println();
                System.out.print("Selecione o recinto que deseja cadastrar o animal: ");
                int opcaoDeRecintoParaCadastroAnimal = scanner.nextInt();
                for (int i = 0; i < cont; i++) {
                        System.out.print("Digite o nome do animal: ");
                        String nome = scanner.next();

                        System.out.print("Digite a idade desse animal: ");
                        int idade = scanner.nextInt();

                        System.out.print("Digite o peso do animal: ");
                        double peso = scanner.nextDouble();

                        System.out.println("O animal é macho ou fêmea?");
                        System.out.println("1 - Macho");
                        System.out.println("2 - Fêmea");
                        Sexo sexo = null;
                        int opcaoSexoAnimal = scanner.nextInt();
                        switch (opcaoSexoAnimal){
                            case 1: sexo = Sexo.MACHO;
                            case 2: sexo = Sexo.FEMEA;
                        }

                    if ((opcaoDeRecintoParaCadastroAnimal -1) == i){
                        System.out.println("Qual é a espécie desse animal?");
                        System.out.println("1 - Arara");
                        System.out.println("2 - Cobra");
                        System.out.println("3 - Elefante");
                        System.out.println("4 - Leão");
                        System.out.println("5 - Macaco");
                        int opcaoEspecieAnimal = scanner.nextInt();
                        Animal animal = null;
                        if (opcaoEspecieAnimal == 1){
                            Arara arara = new Arara(nome, idade, peso, Especies.ARARA, sexo, recintosVazios.get(i));
                            recintosVazios.get(i).adicionarAnimal(arara);
                        } else if(opcaoEspecieAnimal == 2){
                            Cobra cobra = new Cobra(nome, idade, peso, Especies.COBRA, sexo, recintosVazios.get(i));
                            recintosVazios.get(i).adicionarAnimal(cobra);
                        } else if (opcaoEspecieAnimal ==  3) {
                            Elefante elefante = new Elefante(nome, idade, peso, Especies.ELEFANTE, sexo, recintosVazios.get(i));
                            recintosVazios.get(i).adicionarAnimal(elefante);
                        } else if(opcaoEspecieAnimal == 4){
                            Leao leao = new Leao(nome, idade, peso, Especies.LEAO, sexo, recintosVazios.get(i));
                            recintosVazios.get(i).adicionarAnimal(leao);
                        } else if (opcaoEspecieAnimal == 5) {
                            Macaco macaco = new Macaco(nome, idade, peso, Especies.MACACO, sexo, recintosVazios.get(i));
                            recintosVazios.get(i).adicionarAnimal(macaco);
                        } else {
                            System.out.println("Opção Inválida!");
                        }

                        System.out.println("Animal cadastrado!");
                    }
                }
            } else {
                System.out.println("Não há recintos disponíveis para novos animais!");
            }
        } else {
            System.out.println("O zool[ogico não possui nenhum recinto.");
        }
    }

    public void cadastrarRecinto(){
        System.out.println("Qual o nome do recinto?");
        String nome = scanner.next();

        System.out.println("Qual a acapacidade máxima de animais desse recinto?");
        int capacidade = scanner.nextInt();

        Recinto recinto = new Recinto(nome, capacidade);
        zoologico.recintos.add(recinto);
    }

    public void cadastrarFuncionario(){
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.next();

        System.out.println("Digite a idade do funcionário: ");
        int idade = scanner.nextInt();

        System.out.println("Digite o salário do funcinário: ");
        double salario = scanner.nextDouble();

        System.out.println("Qual o cargo do funcionário?");
        System.out.println("1 - Veterinário");
        System.out.println("2 - Tratador");
        int opcaoCargoFuncionario = scanner.nextInt();
        if(opcaoCargoFuncionario == 1){
            Veterinario veterinario = new Veterinario(nome, idade, salario, Cargo.VETERINARIO);
            zoologico.funcionarios.add(veterinario);
        } else if (opcaoCargoFuncionario == 2) {
            Tratador tratador = new Tratador(nome, idade, salario, Cargo.TRATADOR);
            zoologico.funcionarios.add(tratador);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void removerAnimalDoRecinto(){
        System.out.println("Digite o nome do recinto que deseja remover o animal: ");
        String nomeDoRecintoParaRemocao = scanner.next();

        for(Recinto recinto : zoologico.recintos){
            if(nomeDoRecintoParaRemocao == recinto.getNome()) {
                System.out.println("Animais do recinto " + recinto.getNome() + ":");
                System.out.println("Qual o nome do animal que deseja remover do recinto?");
                String nome = scanner.next();
                for (Animal animal : recinto.getAnimais()) {
                    if (animal.getNome() == nome) {
                        recinto.animais.remove(animal);
                        animal.setRecinto(null);
                        System.out.println(animal.getNome() + " removido de " + recinto.getNome() + ".");
                    }
                }
            } else {
                System.out.println("Esse recinto não existe, verifique se digitou o nome corretamente.");
            }
        }
    }

    public void transferirAnimalDeRecinto(){
        if (zoologico.recintos.size() >= 2){
            System.out.println("Qual o nome do animal que deseja transferir de recinto?");
            String nome = scanner.next();

            for (Recinto recinto : zoologico.recintos){
                for (Animal animal : recinto.getAnimais()){
                    if (nome == animal.getNome()){
                        System.out.println("O animal se encontra no recinto " + recinto.getNome());
                        System.out.println("Para qual recinto deseja trasnferi-lo?");
                        String nomeDoRecintoParaTrasnferir = scanner.next();
                        for (int i = 0; i < zoologico.recintos.size(); i++) {
                            if (nomeDoRecintoParaTrasnferir == zoologico.recintos.get(i).getNome()){
                                animal.setRecinto(zoologico.recintos.get(i));
                                zoologico.recintos.get(i).removerAnimal(animal);
                                System.out.println("Animal trasnferido com sucesso!");
                            } else {
                                System.out.println("Esse recinto não existe, verifique se o nome do recinto foi digitado corretamente.");
                            }
                        }
                    } else {
                        System.out.println("Esse animal não existe em nosso zoológico, verifique se o nome foi digitado corretamente.");
                    }
                }
            }
        } else {
            System.out.println("Você não possui mais de um recinto para trasnferir animais.");
        }
    }

    public void alimentarAnimal(){
        if (zoologico.funcionarios.size() >= 1){
            System.out.println("Qual o nome do animal que deseja alimentar?");
            String nome = scanner.next();
            for (Recinto recinto : zoologico.recintos){
                for (Animal animal : recinto.getAnimais()){
                    if (animal.getNome() == nome){
                        System.out.println("Qual tratador irá alimentar o animal? ");
                        String nomeDoTratador = scanner.next();
                        for (Funcionario funcionario : zoologico.funcionarios){
                            if(nomeDoTratador == funcionario.getNome()){
                                Tratador tratador = (Tratador) funcionario;
                                tratador.alimentarAnimal(animal);
                                animal.animalComer();
                            } else {
                                System.out.println("Não há tratadores com esse nome no zoológico, verifique se o nome foi digitado corretamente");
                            }
                        }
                    } else {
                        System.out.println("Esse animal não existe em nosso zoológico, verifique se o nome foi digitado corretamente");
                    }
                }
            }
        } else {
            System.out.println("Não há tratadores para alimentar animais no zoológico!");
        }

    }

    public void examinarAnimal(){
        System.out.println("Qual o nome do animal que deseja examinar? ");
        String nome = scanner.next();

        for(Recinto recinto : zoologico.recintos){
            for (Animal animal : recinto.getAnimais()){
                if(nome == animal.getNome()){
                    System.out.println(animal);
                } else {
                    System.out.println("Não existem animais com esse nome no zoológico, verifique se o nome foi digitado corretamente.");
                }
            }
        }
    }

    public void listarAnimais(){
        for (Recinto recinto : zoologico.recintos){
            for (Animal animal : recinto.getAnimais()){
                System.out.println(animal);
            }
        }
    }

    public void listarRecintos(){
        for (Recinto recinto : zoologico.recintos){
            System.out.println(recinto);
        }
    }
}

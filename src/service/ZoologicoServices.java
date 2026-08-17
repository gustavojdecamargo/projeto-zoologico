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


        System.out.println("Qual o nome do recinto");
    }
}

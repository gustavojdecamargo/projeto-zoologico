package service;

import domain.*;
import domain.animals.*;
import domain.enums.Cargo;
import domain.enums.Especies;
import domain.enums.Sexo;
import domain.workers.Funcionario;
import domain.workers.Tratador;
import domain.workers.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZoologicoServices {
    Zoologico zoologico = new Zoologico();
    Scanner scanner = new Scanner(System.in);

    private int idRecinto;

    public ZoologicoServices(Zoologico zoologico) {
        this.zoologico = zoologico;
    }


    public void cadastrarAnimal() {
        if (zoologico.verificadorDeRecintos() == true) {
            int cont = 0;
            List<Recinto> recintosVazios = new ArrayList<>();
            for (Recinto recinto : zoologico.recintos) {
                if (recinto.estaLotado() == false) {
                    cont += 1;
                    recintosVazios.add(recinto);
                }
            }

            if (cont != 0) {
                System.out.println("Recintos disponíveis.");
                for (int i = 0; i < cont; i++) {
                    System.out.println((i + 1) + " - " + recintosVazios.get(i) + " | " + recintosVazios.get(i).animais.size() + "/" + recintosVazios.get(i).getCapacidade());
                    System.out.println();
                }

                System.out.println();
                System.out.print("Selecione o recinto que deseja cadastrar o animal(Digite o id): ");
                int opcaoDeRecintoParaCadastroAnimal = scanner.nextInt();

                boolean verficadorDeRecinto = false;
                for (Recinto recinto : zoologico.recintos) {
                    if (opcaoDeRecintoParaCadastroAnimal == recinto.getNumero()) {
                        if (recinto.estaLotado() == false){
                            verficadorDeRecinto = true;
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
                            switch (opcaoSexoAnimal) {
                                case 1:
                                    sexo = Sexo.MACHO;
                                    break;
                                case 2:
                                    sexo = Sexo.FEMEA;
                                    break;
                            }

                            for (int i = 0; i < cont; i++) {
                                if ((opcaoDeRecintoParaCadastroAnimal - 1) == i) {
                                    System.out.println("Qual é a espécie desse animal?");
                                    System.out.println("1 - Arara");
                                    System.out.println("2 - Cobra");
                                    System.out.println("3 - Elefante");
                                    System.out.println("4 - Leão");
                                    System.out.println("5 - Macaco");
                                    int opcaoEspecieAnimal = scanner.nextInt();
                                    Animal animal = null;
                                    if (opcaoEspecieAnimal == 1) {
                                        Arara arara = new Arara(nome, idade, peso, Especies.ARARA, sexo, recintosVazios.get(i));
                                        recintosVazios.get(i).adicionarAnimal(arara);
                                    } else if (opcaoEspecieAnimal == 2) {
                                        Cobra cobra = new Cobra(nome, idade, peso, Especies.COBRA, sexo, recintosVazios.get(i));
                                        recintosVazios.get(i).adicionarAnimal(cobra);
                                    } else if (opcaoEspecieAnimal == 3) {
                                        Elefante elefante = new Elefante(nome, idade, peso, Especies.ELEFANTE, sexo, recintosVazios.get(i));
                                        recintosVazios.get(i).adicionarAnimal(elefante);
                                    } else if (opcaoEspecieAnimal == 4) {
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
                        }
                    }
                }

                if (verficadorDeRecinto == false) {
                    System.out.println("Id de recinto inválido, verifique se digitou o id corretamente.");
                }

            } else {
                System.out.println("Não há recintos disponíveis para novos animais!");
            }
        } else {
            System.out.println("O zoológico não possui nenhum recinto.");
        }
    }

    public void cadastrarRecinto() {
    System.out.println("Qual o nome do recinto?");
    String nome = scanner.next();

    System.out.println("Qual a acapacidade máxima de animais desse recinto?");
    int capacidade = scanner.nextInt();

    idRecinto += 1;
    Recinto recinto = new Recinto(nome, capacidade, idRecinto);
    zoologico.adicionarRecinto(recinto);
}

    public void cadastrarFuncionario() {
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
    if (opcaoCargoFuncionario == 1) {
        Veterinario veterinario = new Veterinario(nome, idade, salario, Cargo.VETERINARIO);
        zoologico.funcionarios.add(veterinario);
    } else if (opcaoCargoFuncionario == 2) {
        Tratador tratador = new Tratador(nome, idade, salario, Cargo.TRATADOR);
        zoologico.funcionarios.add(tratador);
    } else {
        System.out.println("Opção inválida.");
    }
}

    public void removerAnimalDoRecinto() {
    if (zoologico.recintos.size() != 0) {
        if (zoologico.verificadorDeAnimais() == true) {
            System.out.println("Digite o nome do recinto que deseja remover o animal: ");
            String nomeDoRecintoParaRemocao = scanner.next();

            for (Recinto recinto : zoologico.recintos) {
                if (nomeDoRecintoParaRemocao.equals(recinto.getNome())) {
                    if (recinto.getAnimais().size() != 0){
                        System.out.println("Animais do recinto " + recinto.getNome() + ":");
                        for (Animal animal : recinto.getAnimais()){
                            animal.exibirDados();
                        }

                        boolean verificadorDeAnimal = false;
                        System.out.println("Qual o nome do animal que deseja remover do recinto?");
                        String nome = scanner.next();
                        for (Animal animal : recinto.getAnimais()){
                            if (animal.getNome().equals(nome)){
                                verificadorDeAnimal = true;
                            }
                        }
                        recinto.getAnimais().removeIf(animal -> animal.getNome().equals(nome));
                        if(verificadorDeAnimal == false){
                            System.out.println("Não há um animal com esse nome no recinto " + recinto.getNome() + ".");
                        } else {
                            System.out.println(nome + " removido de " + recinto.getNome() + ".");
                        }
                    } else {
                        System.out.println("O recinto digitado não possui animais para serem removidos!");
                    }
                } else {
                    System.out.println("Esse recinto não existe, verifique se digitou o nome corretamente.");
                }
            }

        } else {
            System.out.println("Não há animais no zoológico");
        }
    } else {
        System.out.println("Não há recintos e nem animais no zoológico ");
    }
}

    public void transferirAnimalDeRecinto() {
    Animal animalParaTransferencia = null;
    String recintoTransferencia = "";
    int indexParaTransferencia = 0;
    if (zoologico.recintos.size() != 0) {
        /* Criar Metodo para varrer animais e implementar aqui:*/
        boolean haAnimais = false;
        if (zoologico.recintos.size() >= 2) {
            for (Recinto recinto : zoologico.recintos) {
                if (recinto.getAnimais().size() != 0) {
                    haAnimais = true;
                }
            }

            if (haAnimais == true) {
                System.out.println("Qual o nome do animal que deseja transferir de recinto?");
                String nome = scanner.next();
                boolean animalExiste = false;

                for (Recinto recinto : zoologico.recintos) {
                    for (Animal animal : recinto.getAnimais()) {
                        if (nome.equals(animal.getNome())) {
                            animalExiste = true;
                            System.out.println("O animal se encontra no recinto " + recinto.getNome());
                            System.out.println("Para qual recinto deseja trasnferi-lo?");
                            String nomeDoRecintoParaTrasnferir = scanner.next();
                            for (int i = 0; i < zoologico.recintos.size(); i++) {
                                if (nomeDoRecintoParaTrasnferir.equals(zoologico.recintos.get(i).getNome())) {
                                    if (zoologico.recintos.get(i).estaLotado() == false){
                                        animal.setRecinto(zoologico.recintos.get(i));
                                        System.out.println("Animal trasnferido com sucesso!");
                                        animalParaTransferencia = animal;
                                        recintoTransferencia = nomeDoRecintoParaTrasnferir;
                                    } else {
                                        System.out.println("O recinto selecionado está lotado, o animal não pôde ser transerido");
                                    }
                                }
                            }
                        }
                    }
                }

                if (animalExiste == false){
                    System.out.println("Esse animal não existe em nosso zoológico, verifique se o nome foi digitado corretamente.");
                }

                for (Recinto recinto : zoologico.recintos){
                    if (recinto.getAnimais().contains(animalParaTransferencia)){
                        recinto.getAnimais().remove(animalParaTransferencia);
                    }
                }


                for (Recinto recinto : zoologico.recintos){
                    if (recinto.getNome().equals(recintoTransferencia)){
                        recinto.adicionarAnimal(animalParaTransferencia);
                    }
                }



            } else {
                System.out.println("O zoológico não possui animais");
            }
        } else {
            System.out.println("Você não possui 2 ou mais recinto para trasnferir animais.");
        }
    } else {
        System.out.println("Não há recintos no zoológico");
    }
}

    public void alimentarAnimal() {
    if (zoologico.recintos.size() != 0) {
        /* Criar um metodo para percorrer animais e colocar aqui: */
        boolean haAnimais = false;
        for (Recinto recinto : zoologico.recintos) {
            if (recinto.getAnimais() != null) {
                haAnimais = true;
            }
        }

        if (haAnimais = true) {
            if (zoologico.funcionarios.size() != 0) {
                boolean haTratadores = false;
                for (Funcionario funcionario : zoologico.funcionarios){
                    if (funcionario.getCargo() == Cargo.TRATADOR){
                        haTratadores = true;
                    }
                }

                if (haTratadores == true){
                    boolean haTratadoresComEsseNome = false;
                    System.out.println("Qual o nome do animal que deseja alimentar?");
                    String nome = scanner.next();
                    for (Recinto recinto : zoologico.recintos) {
                        for (Animal animal : recinto.getAnimais()) {
                            if (animal.getNome().equals(nome)) {
                                System.out.println("Qual tratador irá alimentar o animal? ");
                                String nomeDoTratador = scanner.next();
                                for (Funcionario funcionario : zoologico.funcionarios) {
                                    if (nomeDoTratador.equals(funcionario.getNome()) && funcionario.getCargo() == Cargo.TRATADOR) {
                                        Tratador tratador = (Tratador) funcionario;
                                        tratador.alimentarAnimal(animal);
                                        animal.animalComer();
                                        haTratadoresComEsseNome = true;
                                    }
                                }
                            } else {
                                System.out.println("Esse animal não existe em nosso zoológico, verifique se o nome foi digitado corretamente");
                            }
                        }
                    }

                    if (haTratadoresComEsseNome == false){
                        System.out.println("Não Há tradores com esse nome no zoológico!");
                    }
                } else {
                    System.out.println("Não há tratadores para alimentar animais no zoológico!");
                }
            } else {
                System.out.println("Não há tratadores para alimentar animais no zoológico!");
            }
        } else {
            System.out.println("Não há animais para alimentar!");
        }
    } else {
        System.out.println("Não há recintos nem animais no zoológico");
    }
}

    public void examinarAnimal() {
    if (zoologico.recintos.size() != 0) {
        /*Criar metodo para varrer aniamis e colocar aqui: */
        boolean haAnimais = false;
        for (Recinto recinto : zoologico.recintos) {
            if (recinto.getAnimais().size() != 0) {
                haAnimais = true;
            }
        }

        if (haAnimais = true) {
            System.out.println("Qual o nome do animal que deseja examinar? ");
            String nome = scanner.next();

            for (Recinto recinto : zoologico.recintos) {
                for (Animal animal : recinto.getAnimais()) {
                    if (nome.equals(animal.getNome())) {
                        animal.exibirDados();
                    } else {
                        System.out.println("Não existem animais com esse nome no zoológico, verifique se o nome foi digitado corretamente.");
                    }
                }
            }
        } else {
            System.out.println("Não há animais no zoológico!");
        }
    } else {
        System.out.println("Não há recinto, nem animais no zoológico!");
    }
}

    public void listarAnimais() {
    boolean haAnimais = false;
    if (zoologico.recintos.size() != 0) {
        for (Recinto recinto : zoologico.recintos) {
            if (recinto.getAnimais().size() != 0) {
                haAnimais = true;
            }
        }
        if (haAnimais == true) {
            for (Recinto recinto : zoologico.recintos) {
                for (Animal animal : recinto.getAnimais()) {
                    animal.exibirDados();
                }
            }
        } else {
            System.out.println("Não há animais no zoológico!");
        }
    } else {
        System.out.println("Não há recintos e nem animais no recinto!");
    }
}

    public void listarRecintos() {
    if (zoologico.recintos.size() != 0) {
        for (Recinto recinto : zoologico.recintos) {
            System.out.println(recinto.toString());
            System.out.println();
        }
    } else {
        System.out.println("Não há recintos no zoológico");
    }
}

    public void listarFuncionarios(){
        if (zoologico.verificadorDeFuncionarios()){
            zoologico.listarFuncionarios();
        } else {
            System.out.println("Não há funcionários cadastrados no zoológico");
        }
    }
}

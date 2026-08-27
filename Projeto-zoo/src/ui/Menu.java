package ui;

import domain.Zoologico;
import service.ZoologicoServices;

import java.util.Scanner;

public class Menu {
    private ZoologicoServices zoologicoServices;

    Scanner scanner = new Scanner(System.in);

    public Menu(ZoologicoServices zoologicoServices) {
        this.zoologicoServices = zoologicoServices;
    }

    public void menu(){
        while(true){
            System.out.println();
            System.out.println("===== Zoológico MagicZoo =====");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Cadastrar Recinto");
            System.out.println("3 - Cadastrar Funcionário");
            System.out.println("4 - Remover Animal do Recinto");
            System.out.println("5 - Transferir Animal");
            System.out.println("6 - Alimentar Animal");
            System.out.println("7 - Examinar Animal");
            System.out.println("8 - Listar Animais");
            System.out.println("9 - Listar Recintos");
            System.out.println("10 - Listar Funcionários");
            System.out.println("0 - Sair");

            System.out.print("Digite a opção que deseja realizar: ");
            int opcao = scanner.nextInt();

            if (opcao == 0){
                System.out.println("Programa encerrado");
                break;
            }

            switch (opcao){
                case 1: zoologicoServices.cadastrarAnimal();
                    break;
                case 2: zoologicoServices.cadastrarRecinto();
                    break;
                case 3: zoologicoServices.cadastrarFuncionario();
                    break;
                case 4: zoologicoServices.removerAnimalDoRecinto();
                    break;
                case 5: zoologicoServices.transferirAnimalDeRecinto();
                    break;
                case 6: zoologicoServices.alimentarAnimal();
                    break;
                case 7: zoologicoServices.examinarAnimal();
                    break;
                case 8: zoologicoServices.listarAnimais();
                    break;
                case 9: zoologicoServices.listarRecintos();
                    break;
                case 10: zoologicoServices.listarFuncionarios();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}

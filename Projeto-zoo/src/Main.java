import domain.Zoologico;
import domain.animals.*;
import domain.enums.Especies;
import domain.enums.Sexo;
import service.ZoologicoServices;
import ui.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        ZoologicoServices zoologicoServices = new ZoologicoServices(zoologico);
        Menu menu = new Menu(zoologicoServices);

        menu.menu();
    }
}

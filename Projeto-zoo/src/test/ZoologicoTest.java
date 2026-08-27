package test;

import domain.Recinto;
import domain.Zoologico;
import domain.animals.Leao;
import domain.enums.Especies;
import domain.enums.Sexo;

import java.util.ArrayList;

public class ZoologicoTest {
    static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        Recinto recinto = new Recinto("Savana", 2, 1);
        Leao leao = new Leao("Scar", 15, 150, Especies.LEAO, Sexo.MACHO, recinto);
        ArrayList<Recinto> recintos = new ArrayList<>();
        recintos.add(recinto);
        recinto.adicionarAnimal(leao);
        zoologico.setRecintos(recintos);

        System.out.println(zoologico.buscarAnimal("Scar"));
    }
}

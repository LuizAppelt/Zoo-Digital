package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class DragaoDeKomodo extends Reptil implements Corrida, Predacao {

    public DragaoDeKomodo(String nome, int idade) {
        super(nome, idade, "Dragão de Komodo");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " bufa e sibila alto.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " devora pedaços de carne com dentes serrilhados.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre de forma pesada e rápida atrás do alvo.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " rastreia presas usando a língua bifurcada.");
    }
}
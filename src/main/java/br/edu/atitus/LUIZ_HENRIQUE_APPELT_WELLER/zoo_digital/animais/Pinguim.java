package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Ave;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Pinguim extends Ave implements Corrida, Nado, Predacao {

    public Pinguim(String nome, int idade) {
        super(nome, idade, "Pinguim");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite um guincho estridente para comunicar-se com o bando.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come peixes frescos e pequenos crustáceos.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre dando pequenos saltos desajeitados sobre o gelo.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada com extrema velocidade e agilidade no oceano gelado.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " caça cardumes de peixes realizando mergulhos profundos.");
    }
}
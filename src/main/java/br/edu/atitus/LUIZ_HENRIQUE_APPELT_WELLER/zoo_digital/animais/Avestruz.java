package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Ave;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;

public class Avestruz extends Ave implements Corrida {

    public Avestruz(String nome, int idade) {
        super(nome, idade, "Avestruz");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite um som cavernoso, similar a um rugido baixo.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come sementes, folhas, frutos e pequenos artrópodes.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre em altíssima velocidade com suas pernas longas.");
    }
}
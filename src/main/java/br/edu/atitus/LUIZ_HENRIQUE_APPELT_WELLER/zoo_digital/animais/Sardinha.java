package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Peixe;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;

public class Sardinha extends Peixe implements Nado {

    public Sardinha(String nome, int idade) {
        super(nome, idade, "Sardinha");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " produz pequenos sons de bolhas de ar.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " filtra plâncton da água do mar.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada em cardumes sincronizados e velozes.");
    }
}
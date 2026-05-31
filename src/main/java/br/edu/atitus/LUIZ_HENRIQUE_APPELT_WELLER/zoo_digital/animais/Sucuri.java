package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Sucuri extends Reptil implements Nado, Predacao {

    public Sucuri(String nome, int idade) {
        super(nome, idade, "Sucuri");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite um silvo alto e intimidador.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " digere lentamente grandes refeições.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " ondula o corpo gigante para nadar velozmente em rios.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " usa sua força muscular para constringir presas dentro da água.");
    }
}
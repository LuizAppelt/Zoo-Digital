package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;

public class Cobra extends Reptil implements Predacao, Nado {

    public Cobra(String nome, int idade) {
        super(nome, idade, "Cobra");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " sibila de forma ameaçadora.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " engole o alimento inteiro devido à mandíbula flexível.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " rasteja silenciosamente para dar o bote.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " ondula o corpo para nadar velozmente em rios.");
    }

}
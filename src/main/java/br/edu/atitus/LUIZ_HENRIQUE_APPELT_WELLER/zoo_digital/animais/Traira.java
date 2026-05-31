package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Peixe;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Traira extends Peixe implements Nado, Predacao {

    public Traira(String nome, int idade) {
        super(nome, idade, "Traíra");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " produz ruídos de fricção interna quando capturada.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " alimenta-se de outros peixes e rãs.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada de forma furtiva por entre a vegetação aquática.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " embosca suas presas em águas calmas e escuras.");
    }
}
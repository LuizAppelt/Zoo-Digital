package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Mamifero;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Golfinho extends Mamifero implements Nado, Predacao {

    public Golfinho(String nome, int idade) {
        super(nome, idade, "Golfinho");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite estalidos e silvos característicos.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " alimenta-se de lulas e peixes variados.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada em alta velocidade e realiza saltos acrobáticos na água.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " caça em grupo cercando cardumes de peixes.");
    }
}
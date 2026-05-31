package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Peixe;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Tubarao extends Peixe implements Nado, Predacao {

    public Tubarao(String nome, int idade) {
        super(nome, idade, "Tubarão");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " não emite sons por não possuir cordas vocais.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " devora grandes porções de peixes e mamíferos marinhos.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada constantemente para garantir a oxigenação pelas brânquias.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " detecta vibrações e sangue na água para localizar alvos.");
    }
}
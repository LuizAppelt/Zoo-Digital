package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Peixe;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class PeixeMorcego extends Peixe implements Nado, Predacao {

    public PeixeMorcego(String nome, int idade) {
        super(nome, idade, "Peixe-morcego");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite estalidos de baixa frequência debaixo d'água.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " consome pequenos crustáceos e vermes marinhos.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " usa as nadadeiras para se deslocar lentamente perto do fundo do mar.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " esconde-se na areia para surpreender pequenos organismos.");
    }
}
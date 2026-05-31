package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Lagartixa extends Reptil implements Corrida, Predacao {

    public Lagartixa(String nome, int idade) {
        super(nome, idade, "Lagartixa");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " faz estalidos agudos na parede.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " engole pequenas moscas e mosquitos.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre rapidamente pelas paredes e tetos.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " aguarda pacientemente por insetos perto de lâmpadas.");
    }
}
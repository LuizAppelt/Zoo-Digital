package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Jacare extends Reptil implements Nado, Predacao {

    public Jacare(String nome, int idade) {
        super(nome, idade, "Jacaré");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " ronca e brama alto na beira da lagoa.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " abocanha peixes e pequenas presas.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada silenciosamente deixando apenas os olhos fora da água.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " espreita presas na margem do rio.");
    }
}
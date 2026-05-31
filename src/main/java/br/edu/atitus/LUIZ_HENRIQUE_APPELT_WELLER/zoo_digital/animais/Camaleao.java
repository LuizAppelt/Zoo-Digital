package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Camaleao extends Reptil implements Predacao {

    public Camaleao(String nome, int idade) {
        super(nome, idade, "Camaleão");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " faz um leve estalido quase imperceptível.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " mastiga insetos.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " muda de cor para se camuflar e dispara a língua longa.");
    }
}
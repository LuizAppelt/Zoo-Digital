package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;

public class Tartaruga extends Reptil implements Nado {

    public Tartaruga(String nome, int idade) {
        super(nome, idade, "Tartaruga Marinha");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite um sopro sibilante baixo.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " mastiga algas marinhas.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " bate as nadadeiras e plana nas águas.");
    }
}
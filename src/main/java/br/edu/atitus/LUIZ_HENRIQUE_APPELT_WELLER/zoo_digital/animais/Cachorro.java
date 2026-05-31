package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Mamifero;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Cachorro extends Mamifero implements Corrida, Predacao {

    public Cachorro(String nome, int idade) {
        super(nome, idade, "Cachorro");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " late alto.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come ração e petiscos carnívoros.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre de forma alegre balançando a cauda.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " persegue pequenos animais ou brinquedos por instinto.");
    }
}
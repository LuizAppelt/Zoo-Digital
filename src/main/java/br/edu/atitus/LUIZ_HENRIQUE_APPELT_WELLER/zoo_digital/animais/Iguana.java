package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Reptil;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;

public class Iguana extends Reptil implements Corrida {

    public Iguana(String nome, int idade) {
        super(nome, idade, "Iguana");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " solta um sopro de ar rápido pelas narinas.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come folhas verdes e pedaços de frutas.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre para subir rapidamente em troncos de árvores.");
    }
}
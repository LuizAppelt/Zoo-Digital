package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Mamifero;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Gato extends Mamifero implements Corrida, Predacao {

    public Gato(String nome, int idade) {
        super(nome, idade, "Gato");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " mia e ronrona.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come ração seca e sachês de carne.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre com agilidade e salta muros altos.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " espreita silenciosamente e caça roedores ou insetos.");
    }
}
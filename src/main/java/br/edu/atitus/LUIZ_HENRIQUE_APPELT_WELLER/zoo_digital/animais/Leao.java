package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Mamifero;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Leao extends Mamifero implements Corrida, Predacao {

    public Leao(String nome, int idade) {
        super(nome, idade, "Leão");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " ruge poderosamente.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " devora grandes porções de carne fresca.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre em arrancadas velozes.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " organiza emboscadas estratégicas para capturar grandes presas.");
    }
}
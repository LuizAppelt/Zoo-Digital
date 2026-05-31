package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Ave;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Nado;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Voo;

public class Pato extends Ave implements Corrida, Nado, Voo {

    public Pato(String nome, int idade) {
        super(nome, idade, "Pato");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " grasna quack quack na lagoa.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " come grãos, plantas aquáticas e pequenos insetos.");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " corre de forma desajeitada pelo gramado.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nada calmamente sobre a superfície da água.");
    }

    @Override
    public void voar() {
        System.out.println(getNome() + " plana e voa distâncias curtas em baixa altitude.");
    }
}
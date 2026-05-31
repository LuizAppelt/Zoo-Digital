package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Ave;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Voo;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Aguia extends Ave implements Voo, Predacao {

    public Aguia(String nome, int idade) {
        super(nome, idade, "Águia");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " grita de forma aguda, imponente e ecoante.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " alimenta-se da carne de suas presas.");
    }

    @Override
    public void voar() {
        System.out.println(getNome() + " voa em altitudes elevadas, planando suavemente com as correntes de ar.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " caça pequenos mamíferos e peixes usando sua visão privilegiada e garras afiadas.");
    }
}
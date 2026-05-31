package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Mamifero;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Voo;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.Predacao;

public class Morcego extends Mamifero implements Voo, Predacao {

    public Morcego(String nome, int idade) {
        super(nome, idade, "Morcego");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " emite guinchos ultrassônicos imperceptíveis aos humanos.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " consome frutos ou pequenos insetos voadores.");
    }

    @Override
    public void voar() {
        System.out.println(getNome() + " voa de forma ágil e cheia de manobras rápidas na escuridão.");
    }

    @Override
    public void cacar() {
        System.out.println(getNome() + " localiza e captura mariposas no ar utilizando a ecolocalização.");
    }
}
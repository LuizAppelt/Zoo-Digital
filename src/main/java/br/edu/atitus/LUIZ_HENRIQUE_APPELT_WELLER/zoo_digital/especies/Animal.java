package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies;

public abstract class Animal {

    // contar o total de animais instanciados
    private static int contador = 0;

    // Atributos básicos e privados
    private String nome;
    private int idade;
    private String especie;

    public Animal(String nome, int idade, String especie) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        contador++; // Toda vez que um Animal for instanciado, o contador sobe 1
    }

    // Método abstrato que todas as filhas deverão implementar
    public abstract void emitirSom();

    // Método abstrato que os animais deverão sobrescrever
    public abstract void comer();

    // Sobrecarga do método comer() final
    // nenhuma classe filha poderá alterar esse metodo
    public final void comer(String alimento) {
        System.out.println(this.nome + " se alimenta de " + alimento + ".");
    }

    // get e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Método static para acessar o contador de fora da classe
    public static int getContador() {
        return contador;
    }
}
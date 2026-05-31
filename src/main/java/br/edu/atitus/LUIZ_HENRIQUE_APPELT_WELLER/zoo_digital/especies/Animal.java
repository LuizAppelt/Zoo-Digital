package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies;

import java.io.Serializable;

// 1. Adicionamos a implementação de Serializable
public abstract class Animal implements Serializable {

    // Identificador de versão para a serialização
    private static final long serialVersionUID = 1L;

    // O contador static não é salvo automaticamente, trataremos ele na inicialização
    private static int contador = 0;

    private String nome;
    private int idade;
    private String especie;

    public Animal(String nome, int idade, String especie) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        contador++; // Aumenta ao criar
    }

    public abstract void emitirSom();
    public abstract void comer();

    public final void comer(String alimento) {
        System.out.println(this.nome + " está se alimentando de " + alimento + ".");
    }

    // --- Getters e Setters ---
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public static int getContador() {
        return contador;
    }

    // Usado para restaurar o contador ao abrir o aplicativo
    public static void setContador(int valor) {
        contador = valor;
    }

    // Usado para diminuir o total de animais na opção de Remover
    public static void decrementarContador() {
        if (contador > 0) {
            contador--;
        }
    }
}
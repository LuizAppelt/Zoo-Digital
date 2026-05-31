package br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.app;

import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.especies.Animal;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.comportamentos.*;
import br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.animais.*;

import org.apache.commons.lang3.StringUtils;

// Importações necessárias para a manipulação de arquivos
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooDigitalApp {

    // ─── ANSI ──────────────────────────────────────────────────
    private static final String RESET    = "\u001B[0m";
    private static final String BOLD     = "\u001B[1m";
    private static final String DIM      = "\u001B[2m";
    private static final String CYAN     = "\u001B[36m";
    private static final String WHITE    = "\u001B[37m";
    private static final String B_RED    = "\u001B[91m";
    private static final String B_GREEN  = "\u001B[92m";
    private static final String B_YELLOW = "\u001B[93m";
    private static final String B_BLUE   = "\u001B[94m";
    private static final String B_CYAN   = "\u001B[96m";
    private static final String B_WHITE  = "\u001B[97m";

    private static final String ARQUIVO_DADOS = "zoo_memoria.dat";

    // Lista genérica de Animais
    private static final List<Animal> repositorioAnimais = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Carrega o banco de dados assim que o sistema inicia
        carregarDados();

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            IO.print(BOLD + B_WHITE + "\n  Escolha uma opção: " + RESET);
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> cadastrarAnimal();
                    case 2 -> listarTodos();
                    case 3 -> listarCorredores();
                    case 4 -> listarNadadores();
                    case 5 -> listarVoadores();
                    case 6 -> listarPredadores();
                    case 7 -> editarAnimal();
                    case 8 -> removerAnimal();
                    case 0 -> {
                        // Salva tudo no arquivo antes de encerrar
                        salvarDados();
                        IO.println(BOLD + B_CYAN + "\n  Memória salva. Encerrando o Zoo Digital!\n" + RESET);
                    }
                    default -> msgErro("Opção inválida! Digite um número de 0 a 8.");
                }
            } catch (NumberFormatException e) {
                msgErro("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }

    // ─── Lógica de Persistência (Salvar/Carregar) ─────────────────────────────
    @SuppressWarnings("unchecked")
    private static void carregarDados() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                List<Animal> carregados = (List<Animal>) ois.readObject();
                repositorioAnimais.addAll(carregados);
                Animal.setContador(repositorioAnimais.size()); // Restaura o contador
            } catch (Exception e) {
                msgErro("Erro ao carregar a memória: " + e.getMessage());
            }
        }
    }

    private static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            oos.writeObject(repositorioAnimais);
        } catch (Exception e) {
            msgErro("Erro ao salvar a memória: " + e.getMessage());
        }
    }

    // ─── Menu Principal ───────────────────────────────────────────────────────
    private static void exibirMenu() {
        IO.println();
        IO.println(BOLD + B_CYAN + "  ╔════════════════════════════════════════════╗" + RESET);
        IO.println(BOLD + B_CYAN + "  ║" + RESET + BOLD + B_WHITE
                + "            ZOO DIGITAL · ATITUS            "
                + BOLD + B_CYAN + "║" + RESET);
        IO.println(BOLD + B_CYAN + "  ╠════════════════════════════════════════════╣" + RESET);
        IO.println(BOLD + B_CYAN + "  ║" + RESET + DIM + WHITE
                + String.format(" Animais no sistema: %-23d", Animal.getContador())
                + BOLD + B_CYAN + "║" + RESET);
        IO.println(BOLD + B_CYAN + "  ╠════════════════════════════════════════════╣" + RESET);
        menuItem(B_GREEN,  "1", "Cadastrar Animal");
        menuItem(B_WHITE,  "2", "Listar Todos os Animais");
        menuItem(B_YELLOW, "3", "Listar Animais Corredores");
        menuItem(B_YELLOW, "4", "Listar Animais Nadadores");
        menuItem(B_YELLOW, "5", "Listar Animais Voadores");
        menuItem(B_YELLOW, "6", "Listar Animais Predadores");
        menuItem(B_BLUE,   "7", "Editar Animal");
        menuItem(B_RED,    "8", "Remover Animal");
        menuItem(B_RED,    "0", "Sair do Sistema");
        IO.println(BOLD + B_CYAN + "  ╚════════════════════════════════════════════╝" + RESET);
    }

    private static void menuItem(String numColor, String num, String texto) {
        String padding = " ".repeat(Math.max(0, 44 - 4 - num.length() - texto.length()));
        IO.println(
                BOLD + B_CYAN + "  ║" + RESET
                        + WHITE + " [" + BOLD + numColor + num + RESET + WHITE + "] " + texto + padding
                        + BOLD + B_CYAN + "║" + RESET);
    }

    // Helpers de saída
    private static void msgErro(String msg) {
        IO.println(BOLD + B_RED + "\n  ✖  " + msg + RESET);
    }

    private static void msgSucesso(String msg) {
        IO.println(BOLD + B_GREEN + "\n  ✔  " + msg + RESET);
    }

    private static void cabecalho(String titulo, String cor) {
        IO.println();
        IO.println(BOLD + cor + "  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
        IO.println(BOLD + cor + "  " + titulo + RESET);
        IO.println(BOLD + cor + "  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
    }

    private static void semResultado(String msg) {
        IO.println(DIM + B_YELLOW + "\n  " + msg + RESET);
    }

    private static void animalEntry(Animal animal, String cor) {
        IO.println(
                "  " + BOLD + cor + "▸ " + RESET
                        + BOLD + B_WHITE + animal.getNome() + RESET
                        + DIM + WHITE + "  (" + animal.getEspecie() + ")" + RESET);
    }

    private static String ni(String num) {
        return DIM + WHITE + "[" + RESET + BOLD + B_YELLOW + num + RESET + DIM + WHITE + "] " + RESET + WHITE;
    }

    // ─── 1. Cadastrar Animal ──────────────────────────────────────────────────
    private static void cadastrarAnimal() {
        cabecalho("CADASTRO DE NOVO ANIMAL", B_CYAN);

        IO.println(BOLD + B_WHITE + "\n  ┌─ MAMÍFEROS ──────────────────────────────" + RESET);
        IO.println("  " + DIM + WHITE + "│  " + RESET + WHITE
                + ni("1") + "Cachorro    " + ni("2") + "Gato        " + ni("3") + "Golfinho    "
                + ni("4") + "Leão    " + ni("5") + "Morcego");
        IO.println(BOLD + B_WHITE + "  ├─ AVES ────────────────────────────────────" + RESET);
        IO.println("  " + DIM + WHITE + "│  " + RESET + WHITE
                + ni("6") + "Pato        " + ni("7") + "Pinguim     " + ni("8") + "Águia       " + ni("9") + "Avestruz");
        IO.println(BOLD + B_WHITE + "  ├─ PEIXES ──────────────────────────────────" + RESET);
        IO.println("  " + DIM + WHITE + "│  " + RESET + WHITE
                + ni("10") + "P. Morcego  " + ni("11") + "Traíra     " + ni("12") + "Tubarão    " + ni("13") + "Sardinha");
        IO.println(BOLD + B_WHITE + "  └─ RÉPTEIS ─────────────────────────────────" + RESET);
        IO.println("     " + WHITE
                + ni("14") + "Jacaré      " + ni("15") + "Tartaruga  " + ni("16") + "Cobra      " + ni("17") + "Camaleão");
        IO.println("     " + WHITE
                + ni("18") + "D. Komodo   " + ni("19") + "Lagartixa  " + ni("20") + "Iguana     " + ni("21") + "Sucuri");

        IO.print(BOLD + B_WHITE + "\n  Espécie # : " + RESET);
        int escolhaEspecie;
        try {
            escolhaEspecie = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            msgErro("Seleção inválida.");
            return;
        }

        IO.print(BOLD + B_WHITE + "  Nome      : " + RESET);
        String nome = StringUtils.capitalize(scanner.nextLine());

        IO.print(BOLD + B_WHITE + "  Idade     : " + RESET);
        int idade;
        try {
            idade = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            msgErro("Idade inválida. Insira um número inteiro.");
            return;
        }

        // ---------------------------------------------

        Animal novoAnimal = null;
        switch (escolhaEspecie) {
            case 1  -> novoAnimal = new Cachorro(nome, idade);
            case 2  -> novoAnimal = new Gato(nome, idade);
            case 3  -> novoAnimal = new Golfinho(nome, idade);
            case 4  -> novoAnimal = new Leao(nome, idade);
            case 5  -> novoAnimal = new Morcego(nome, idade);
            case 6  -> novoAnimal = new Pato(nome, idade);
            case 7  -> novoAnimal = new Pinguim(nome, idade);
            case 8  -> novoAnimal = new Aguia(nome, idade);
            case 9  -> novoAnimal = new Avestruz(nome, idade);
            case 10 -> novoAnimal = new PeixeMorcego(nome, idade);
            case 11 -> novoAnimal = new Traira(nome, idade);
            case 12 -> novoAnimal = new Tubarao(nome, idade);
            case 13 -> novoAnimal = new Sardinha(nome, idade);
            case 14 -> novoAnimal = new Jacare(nome, idade);
            case 15 -> novoAnimal = new Tartaruga(nome, idade);
            case 16 -> novoAnimal = new Cobra(nome, idade);
            case 17 -> novoAnimal = new Camaleao(nome, idade);
            case 18 -> novoAnimal = new DragaoDeKomodo(nome, idade);
            case 19 -> novoAnimal = new Lagartixa(nome, idade);
            case 20 -> novoAnimal = new Iguana(nome, idade);
            case 21 -> novoAnimal = new Sucuri(nome, idade);
            default -> msgErro("Espécie não identificada.");
        }

        if (novoAnimal != null) {
            // --- NOVA VERIFICAÇÃO DE DUPLICIDADE (SEPARADA POR ESPÉCIE) ---
            Animal animalExistente = null;
            String motivo = "";

            for (Animal animal : repositorioAnimais) {
                // 1. PRIMEIRO checa se são da MESMA ESPÉCIE (Tipo de Animal)
                if (animal.getEspecie().equalsIgnoreCase(novoAnimal.getEspecie())) {

                    // 2. Se for da mesma espécie, checa se tem o MESMO NOME e a MESMA IDADE
                    if (animal.getNome().equalsIgnoreCase(novoAnimal.getNome()) && animal.getIdade() == novoAnimal.getIdade()) {
                        animalExistente = animal;
                        motivo = "possui exatamente o mesmo nome e a mesma idade";
                        break;
                    }
                    // 3. Ou checa se possui apenas o MESMO NOME
                    else if (animal.getNome().equalsIgnoreCase(novoAnimal.getNome())) {
                        animalExistente = animal;
                        motivo = "possui o mesmo nome";
                        break;
                    }
                }
            }

            // Se encontrou alguma duplicidade dentro da MESMA ESPÉCIE
            if (animalExistente != null) {
                IO.println(BOLD + B_YELLOW + "\n  Aviso: Já existe um(a) " + animalExistente.getEspecie() + " chamado(a) '" + nome + "' que " + motivo + " no zoológico!" + RESET);
                IO.print(BOLD + B_WHITE + "  Tem certeza que deseja cadastrar outro animal com estes dados? (S/N)\n" +
                        "  [Caso seja o mesmo animal, digite 'N' para cancelar e use a opção 7 para Editar]: " + RESET);

                String confirmacao = scanner.nextLine().trim();

                // Se o usuário não digitar "S", o cadastro é cancelado
                if (!confirmacao.equalsIgnoreCase("S")) {
                    Animal.decrementarContador(); // Desfaz a contagem gerada no construtor
                    msgErro("Cadastro cancelado pelo usuário.");
                    return; // Sai do método sem adicionar na lista
                }
            }
            // ---------------------------------------------

            // Se não tinha duplicidade, ou se o usuário confirmou que queria duplicar:
            repositorioAnimais.add(novoAnimal);
            msgSucesso(novoAnimal.getEspecie() + " '" + nome + "' cadastrado com sucesso!");
        }
    }

    // ─── 2. Listar Todos ──────────────────────────────────────────────────────
    private static void listarTodos() {
        if (repositorioAnimais.isEmpty()) {
            semResultado("Nenhum animal cadastrado no zoológico ainda.");
            return;
        }
        cabecalho("LISTA GERAL DE ANIMAIS  (" + repositorioAnimais.size() + ")", B_GREEN);

        for (Animal animal : repositorioAnimais) {
            IO.println(DIM + WHITE + "  ─────────────────────────────────────────────" + RESET);
            IO.println(
                    "  " + BOLD + B_WHITE + animal.getNome() + RESET
                            + DIM + WHITE + "  ·  " + RESET
                            + WHITE + animal.getIdade() + " anos"
                            + DIM + WHITE + "  ·  " + RESET
                            + CYAN + animal.getEspecie() + RESET);
            animal.emitirSom();
            animal.comer();
        }
        IO.println(DIM + WHITE + "  ─────────────────────────────────────────────" + RESET);
    }

    // ─── 3, 4, 5, 6. Filtros ──────────────────────────────────────────────────
    private static void listarCorredores() {
        cabecalho("ANIMAIS CORREDORES", B_YELLOW);
        boolean encontrou = false;
        for (Animal animal : repositorioAnimais) {
            if (animal instanceof Corrida animalCorredor) {
                animalEntry(animal, B_YELLOW);
                animalCorredor.correr();
                encontrou = true;
            }
        }
        if (!encontrou) semResultado("Nenhum animal corredor cadastrado.");
    }

    private static void listarNadadores() {
        cabecalho("ANIMAIS NADADORES", B_BLUE);
        boolean encontrou = false;
        for (Animal animal : repositorioAnimais) {
            if (animal instanceof Nado animalNadador) {
                animalEntry(animal, B_BLUE);
                animalNadador.nadar();
                encontrou = true;
            }
        }
        if (!encontrou) semResultado("Nenhum animal nadador cadastrado.");
    }

    private static void listarVoadores() {
        cabecalho("ANIMAIS VOADORES", B_CYAN);
        boolean encontrou = false;
        for (Animal animal : repositorioAnimais) {
            if (animal instanceof Voo animalVoador) {
                animalEntry(animal, B_CYAN);
                animalVoador.voar();
                encontrou = true;
            }
        }
        if (!encontrou) semResultado("Nenhum animal voador cadastrado.");
    }

    private static void listarPredadores() {
        cabecalho("ANIMAIS PREDADORES", B_RED);
        boolean encontrou = false;
        for (Animal animal : repositorioAnimais) {
            if (animal instanceof Predacao animalPredador) {
                animalEntry(animal, B_RED);
                animalPredador.cacar();
                encontrou = true;
            }
        }
        if (!encontrou) semResultado("Nenhum animal predador cadastrado.");
    }

    // ─── 7. Editar Animal ─────────────────────────────────────────────────────
    private static void editarAnimal() {
        if (repositorioAnimais.isEmpty()) {
            semResultado("Nenhum animal cadastrado para editar.");
            return;
        }
        cabecalho("EDITAR ANIMAL", B_BLUE);

        for (int i = 0; i < repositorioAnimais.size(); i++) {
            Animal a = repositorioAnimais.get(i);
            IO.println("  " + ni(String.valueOf(i + 1)) + a.getNome() + " (" + a.getEspecie() + ")");
        }

        IO.print(BOLD + B_WHITE + "\n  Digite o ID do animal para editar (ou 0 p/ cancelar): " + RESET);
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index == -1) return;

            if (index >= 0 && index < repositorioAnimais.size()) {
                Animal animal = repositorioAnimais.get(index);

                IO.print(BOLD + B_WHITE + "  Novo nome (deixe em branco para manter '" + animal.getNome() + "'): " + RESET);
                String novoNome = scanner.nextLine().trim();
                if (!novoNome.isEmpty()) {
                    animal.setNome(StringUtils.capitalize(novoNome));
                }

                IO.print(BOLD + B_WHITE + "  Nova idade (deixe em branco para manter " + animal.getIdade() + "): " + RESET);
                String novaIdadeStr = scanner.nextLine().trim();
                if (!novaIdadeStr.isEmpty()) {
                    animal.setIdade(Integer.parseInt(novaIdadeStr));
                }

                msgSucesso("Dados de " + animal.getNome() + " atualizados com sucesso!");
            } else {
                msgErro("Número de ID não encontrado.");
            }
        } catch (NumberFormatException e) {
            msgErro("Entrada inválida.");
        }
    }

    // ─── 8. Remover Animal ────────────────────────────────────────────────────
    private static void removerAnimal() {
        if (repositorioAnimais.isEmpty()) {
            semResultado("Nenhum animal cadastrado para remover.");
            return;
        }
        cabecalho("REMOVER ANIMAL", B_RED);

        for (int i = 0; i < repositorioAnimais.size(); i++) {
            Animal a = repositorioAnimais.get(i);
            IO.println("  " + ni(String.valueOf(i + 1)) + a.getNome() + " (" + a.getEspecie() + ")");
        }

        IO.print(BOLD + B_WHITE + "\n  Digite o ID do animal para remover (ou 0 p/ cancelar): " + RESET);
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index == -1) return;

            if (index >= 0 && index < repositorioAnimais.size()) {
                Animal removido = repositorioAnimais.remove(index);
                Animal.decrementarContador(); // Reajusta o total de animais!
                msgSucesso(removido.getNome() + " (" + removido.getEspecie() + ") foi removido do zoo.");
            } else {
                msgErro("Número de ID não encontrado.");
            }
        } catch (NumberFormatException e) {
            msgErro("Entrada inválida.");
        }
    }
}
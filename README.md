
# Zoo Digital · Atitus

O **Zoo Digital** é uma aplicação de console desenvolvida em Java 26 utilizando o gerenciador de dependências Maven. O sistema simula o gerenciamento de um zoológico, permitindo o cadastro, edição, remoção, listagem e filtragem de animais divididos em quatro grandes grupos (Mamíferos, Aves, Peixes e Répteis). 

O projeto foi construído como um modelo prático para consolidar conceitos avançados de **Programação Orientada a Objetos (POO)** e persistência de dados em arquivos binários.

---

## 🛠️ Tecnologias e Requisitos

* **Linguagem:** Java 26
* **Gerenciador de Dependências:** Maven
* **Dependências Externas:** Apache Commons Lang3 (v3.18.0)
* **Persistência:** Serialização Nativa do Java (`ObjectOutputStream` / `ObjectInputStream`)

---

## 📁 Organização do Projeto e Pacotes

O projeto segue a estrutura padrão do **Apache Maven** (`src/main/java`) e distribui suas responsabilidades de forma coesa através de uma arquitetura de pacotes bem definida:

```text
br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital
│
├── app
│   └── ZooDigitalApp.java         # Ponto de entrada (Main) e gerenciamento da CLI
│
├── especies
│   └── Animal.java                # Classe base abstrata/genérica para todos os animais
│
├── comportamentos
│   ├── Corrida.java               # Interface para animais que correm
│   ├── Nado.java                  # Interface para animais que nadam
│   ├── Voo.java                   # Interface para animais que voam
│   └── Predacao.java              # Interface para animais predadores (caçadores)
│
└── animais
    ├── Cachorro.java, Gato.java, Leao.java, Morcego... (Demais subclasses concretas)
```

### 🧬 Princípios de Orientação a Objetos Aplicados
** 1. Estrutura e Coerência da Modelagem
A modelagem separa características essenciais biológicas dos animais de seus comportamentos dinâmicos. Cada animal é categorizado em seu respectivo grupo taxonômico por meio da árvore de herança e estendido por contratos de comportamento (interfaces).

** 2. Uso Correto de Herança
A classe abstrata Animal (no pacote .especies) centraliza os atributos comuns de todas as criaturas, como nome, idade e especie, além dos métodos abstratos emitirSom() e comer().
As 21 espécies disponíveis no sistema (como Leao, Aguia, Tubarão e Jacare) estendem Animal, herdando sua estrutura básica e fornecendo implementações específicas para suas naturezas individuais.

** 3. Uso Correto de Interfaces
Os comportamentos dos animais não são limitados por suas classes de origem (o que evitaria problemas como a herança múltipla). Em vez disso, foram isolados em interfaces no pacote .comportamentos:

Corrida (método correr())

Nado (método nadar())

Voo (método voar())

Predacao (método cacar())

Isso permite que um Morcego (Mamífero) e uma Aguia (Ave) compartilhem a interface Voo, enquanto um Pinguim (Ave) e um Golfinho (Mamífero) compartilhem a interface Nado.

** 4. Aplicação de Polimorfismo
O polimorfismo é amplamente explorado na listagem geral do sistema. O repositório armazena apenas referências genéricas do tipo List<Animal>. Ao iterar sobre a lista, o sistema invoca os métodos animal.emitirSom() e animal.comer(). O Java descobre em tempo de execução qual é a subclasse real do objeto e executa o comportamento correto de maneira dinâmica.

** 5. Uso Adequado de Casting e Pattern Matching
Para a filtragem e listagem de comportamentos específicos, o sistema utiliza a validação de tipos. Aproveitando os recursos modernos do Java, foi aplicado o Pattern Matching para instanceof, eliminando a necessidade de castings manuais e verbosos:

Java
if (animal instanceof Corrida animalCorredor) {
    animalEntry(animal, B_YELLOW);
    animalCorredor.correr(); // Executa o método da interface sem necessidade de cast explícito posterior
}
💾 Memória e Persistência de Dados
O ecossistema conta com persistência de dados em arquivo local, eliminando a volatilidade da memória RAM.

Arquivo de Saída: zoo_memoria.dat

Mecanismo: Sempre que a aplicação é iniciada, o método carregarDados() faz a leitura do arquivo binário e restaura a lista de animais, reajustando também o contador estático global de instâncias.

Salvamento Automático: Ao selecionar a opção 0 - Sair do Sistema, o método salvarDados() intercepta o encerramento e serializa a coleção atualizada de volta para o armazenamento físico.

### 🖥️ Funcionamento da CLI e Regras de Negócio
A Interface de Linha de Comando (CLI) foi projetada com foco na usabilidade, validação de dados e estética visual (utilizando cores via códigos ANSI):

Robustez contra falhas: Captura de exceções como NumberFormatException para evitar que entradas de texto quebrem o menu numérico.

Tratamento de Duplicidade Inteligente: Ao cadastrar um animal, o sistema realiza uma varredura fina dividida por espécie. Se for detectado um animal da mesma espécie com o mesmo nome (ou mesmo nome e idade), a CLI emite um alerta em amarelo e exige uma confirmação explícita (S/N) do operador para prosseguir ou abortar.

Gerenciamento de Estado: As rotinas de Edição (Opção 7) e Remoção (Opção 8) reajustam dinamicamente as propriedades dos objetos e a contagem global do zoológico.

### 📋 Qualidade e Legibilidade do Código
Padrão Clean Code: Métodos pequenos, modulares e com responsabilidade única (SRP).

Formatação Avançada: Alinhamento estético de menus de cadastro e uso do StringUtils.capitalize() para padronizar os nomes de entrada dos usuários.

Feedback Visual claro: Uso de ícones de sucesso (✔) e erro (✖) coloridos para guiar a experiência do usuário.

 
### 🚀 Como Executar o Projeto
Pré-requisitos
Java JDK 26 instalado.

Apache Maven configurado nas variáveis de ambiente.

Passos para Execução
Clone este repositório em sua máquina local.

Navegue até a pasta raiz do projeto (onde se encontra o arquivo pom.xml).

Compile o projeto utilizando o Maven:
```
Bash
mvn clean package
```
Execute o arquivo compilado gerado na pasta target ou utilize o comando de execução principal da sua IDE apontando para a classe:
```
Plaintext
br.edu.atitus.LUIZ_HENRIQUE_APPELT_WELLER.zoo_digital.app.ZooDigitalApp
```


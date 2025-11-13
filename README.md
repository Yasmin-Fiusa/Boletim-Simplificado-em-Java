<h1>Boletim Simplificado em Java (POO)</h1>

Este projeto implementa um sistema de boletim escolar simplificado, desenvolvido como prática dos conceitos fundamentais de Programação Orientada a Objetos (POO).


<h2>Descrição do Programa</h2>

O programa permite ao usuário interagir via console para gerenciar as notas e o estado de um aluno por vez. Ele oferece um menu simples que permite:

1. Definir o nome do aluno (limpando o estado do aluno anterior, se houver).

2. Adicionar notas (com validação para garantir que estejam entre 0.0 e 10.0 e respeitem o limite de 10 notas).

3. Exibir um relatório completo contendo o nome, lista de notas, média, maior nota, menor nota e situação (Aprovado ≥ 6.0 / Reprovado < 6.0).

<h2>Conceitos de POO e Arquitetura Utilizados</h2>

O projeto foi estruturado para demonstrar a aplicação prática dos seguintes conceitos:

<h3>1. Classe e Atributos</h3>

<b>Classe:</b> Cada entidade (como Boletim, BoletimController, BoletimDAO, BoletimView) é definida como uma classe, servindo de molde para a criação de objetos.

<b>Atributos:</b> Na classe Boletim, temos atributos como nomeAluno, notas e quantidade que definem o estado (as características) do objeto Boletim.

<h3>2. Encapsulamento</h3>

<b>Aplicação:</b> A classe Boletim (Model) mantém seus atributos (nomeAluno, notas, quantidade) como privados (private).

<b>Benefício:</b> O acesso e a manipulação dos dados são feitos exclusivamente através de métodos públicos (getters e setters como getNomeAluno, adicionarNota, calcularMedia), protegendo o estado interno do objeto de alterações diretas e inválidas.

<h3>3. Organização em Pacotes</h3>

<b>Conceito:</b> Pacotes (model, dao, controller, view) são utilizados para agrupar classes relacionadas, organizando o código em módulos lógicos e evitando conflitos de nomes (name collisions).

<b>Benefício:</b> Implementa o Padrão MVC Expandido, promovendo coesão (classes semelhantes ficam juntas) e baixo acoplamento (a comunicação entre pacotes é controlada).

<h2>Instruções de Execução</h2>

Para executar este projeto, você precisará de um ambiente Java (JDK) configurado e uma IDE (como IntelliJ IDEA, Eclipse ou VS Code com extensões Java).
<h3>Passos para Rodar</h3>

<b>Opção 1: Usando uma IDE (Recomendado)</b>

1. <b>Importar Projeto:</b> Abra sua IDE (IntelliJ, Eclipse, etc.) e importe o diretório principal do projeto (a pasta que contém a pasta src).

2. <b>Configurar Módulos:</b> A IDE deve reconhecer automaticamente os pacotes (model, controller, dao, view) dentro de src.

3. <b>Executar:</b> Navegue até o arquivo src/view/Main.java. Clique com o botão direito do mouse sobre ele e selecione a opção "Run 'Main.main()'" ou equivalente.

4. O menu do programa será exibido no console da sua IDE.

<b>Opção 2: Via Linha de Comando (Avançado)</b>

1. <b>Compilação:</b> Abra o terminal no diretório src e compile os arquivos:
<pre>bash javac controller/*.java dao/*.java model/*.java view/*.java</pre>
2. <b>Execução:</b> Execute a classe principal, especificando o pacote:
<pre>java view.Main</pre>

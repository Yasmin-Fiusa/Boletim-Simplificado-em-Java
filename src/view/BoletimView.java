package view;

import controller.BoletimController;
import model.Boletim;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class BoletimView {

    private final BoletimController controller;
    private final Scanner scanner;

    public BoletimView() {
        this.controller = new BoletimController();
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public void iniciar() {
        int opcao = 0;
        System.out.println("=== Boletim ===");
        while (opcao != 6) {
            exibirMenu();
            try {
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        definirNomeAluno();
                        break;
                    case 2:
                        adicionarNota();
                        break;
                    case 3:
                        exibirRelatorio();
                        break;
                    case 4: // Bônus
                        System.out.println("Encerrando o programa!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número para a opção.");
                scanner.nextLine();
                opcao = 0;
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1) Definir nome do aluno");
        System.out.println("2) Adicionar nota");
        System.out.println("3) Mostrar relatório");

        System.out.println("4) Sair");
    }

    private void definirNomeAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        controller.definirNomeAluno(nome);
        System.out.println("Nome do aluno: " + nome);
    }

    private void adicionarNota() {
        try {
            System.out.print("Nota (0.0 a 10.0): ");
            double nota = scanner.nextDouble();
            scanner.nextLine();

            if (controller.adicionarNota(nota)) {
                System.out.println("Nota adicionada!");
            } else {
                System.out.println("Falha ao adicionar nota. Verifique se a nota está entre 0.0 e 10.0 ou se já atingiu o limite de 10 notas.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: O formato da nota está incorreto. Use números (ex: 7.5).");
            scanner.nextLine();
        }
    }

    private void exibirRelatorio() {
        Boletim boletim = controller.obterRelatorio();

        System.out.println("\n--- RELATÓRIO FINAL ---");
        System.out.println("Aluno: " + boletim.getNomeAluno());

        double[] notas = boletim.getNotas();
        StringBuilder notasStr = new StringBuilder();
        if (notas.length > 0) {
            for (int i = 0; i < notas.length; i++) {
                notasStr.append(String.format("%.1f", notas[i]));
                if (i < notas.length - 1) {
                    notasStr.append(", ");
                }
            }
        } else {
            notasStr.append("Nenhuma nota registrada.");
        }
        System.out.println("Notas: " + notasStr.toString());

        System.out.printf("Média: %.2f\n", boletim.calcularMedia());
        System.out.printf("Maior: %.1f | Menor: %.1f\n", boletim.obterMaior(), boletim.obterMenor());
        System.out.println("Situação: " + boletim.obterSituacao());
        System.out.println("------------------------");
    }
}
package model;

import java.util.Arrays;

public class Boletim {

    private static final int MAX_NOTAS = 10; // Constante para o limite
    private String nomeAluno;
    private final double[] notas; // Array de tamanho fixo 10
    private int quantidade; // Controla quantas notas foram realmente inseridas

    public Boletim() {
        this.notas = new double[MAX_NOTAS];
        this.quantidade = 0;
        this.nomeAluno = "N/A";
    }

    public void setNomeAluno(String nome) {
        this.nomeAluno = nome;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public boolean adicionarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            return false;
        }

        if (quantidade < MAX_NOTAS) {
            notas[quantidade] = nota;
            quantidade++;
            return true;
        }
        return false;
    }

    public double calcularMedia() {
        if (quantidade == 0) {
            return 0.0;
        }

        double soma = 0.0;
        for (int i = 0; i < quantidade; i++) {
            soma += notas[i];
        }

        return soma / quantidade;
    }

    public double obterMaior() {
        if (quantidade == 0) {
            return 0.0;
        }

        double maior = notas[0];
        for (int i = 1; i < quantidade; i++) {
            if (notas[i] > maior) {
                maior = notas[i];
            }
        }
        return maior;
    }

    public double obterMenor() {
        if (quantidade == 0) {
            return 0.0;
        }

        double menor = notas[0];
        for (int i = 1; i < quantidade; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    public String obterSituacao() {
        return calcularMedia() >= 6.0 ? "Aprovado" : "Reprovado";
    }

    public double[] getNotas() {
        return Arrays.copyOf(notas, quantidade);
    }

    public void limparNotas() {
        this.quantidade = 0;
    }

    public boolean removerUltimaNota() {
        if (quantidade > 0) {
            quantidade--;
            return true;
        }
        return false;
    }
}
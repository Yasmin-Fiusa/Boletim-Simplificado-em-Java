package controller;

import dao.BoletimDao;
import model.Boletim;

public class BoletimController {

    private final BoletimDao boletimDAO;

    public BoletimController() {
        this.boletimDAO = new BoletimDao();
    }

    public void definirNomeAluno(String nome) {
        Boletim boletim = boletimDAO.obterBoletim();

        boletim.limparNotas();

        boletim.setNomeAluno(nome);
    }

    public boolean adicionarNota(double nota) {
        Boletim boletim = boletimDAO.obterBoletim();
        return boletim.adicionarNota(nota);
    }

    public boolean removerUltimaNota() {
        Boletim boletim = boletimDAO.obterBoletim();
        return boletim.removerUltimaNota();
    }

    public void limparTodasNotas() {
        Boletim boletim = boletimDAO.obterBoletim();
        boletim.limparNotas();
    }

    public Boletim obterRelatorio() {
        return boletimDAO.obterBoletim();
    }
}
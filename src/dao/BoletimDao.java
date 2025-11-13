package dao;

import model.Boletim;

public class BoletimDao {

    private Boletim boletimInstance;

    public BoletimDao() {
        this.boletimInstance = new Boletim();
    }

    public Boletim obterBoletim() {
        return boletimInstance;
    }
}
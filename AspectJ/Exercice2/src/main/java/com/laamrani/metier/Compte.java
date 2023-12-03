package com.laamrani.metier;

public class Compte {
    private long code;
    private double solde;
    public Compte(Long id, double solde) {
        this.code = id;
        this.solde = solde;

    }
    public Compte() {
    }
    public long getCode() {
        return code;
    }
    public double getSolde() {
        return solde;
    }
    public void setCode(long id) {
        this.code = id;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
    }
}

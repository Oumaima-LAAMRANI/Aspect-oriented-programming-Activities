package com.laamrani.metier;

public interface IMetierBanque {
    public void addCompte(Compte c);
    public Compte consulterCompte(long code);
    public void verser(long code, double montant);
    public void retirer(long code, double montant);
}

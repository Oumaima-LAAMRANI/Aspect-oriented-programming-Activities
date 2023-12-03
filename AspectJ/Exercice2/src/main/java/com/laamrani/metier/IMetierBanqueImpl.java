package com.laamrani.metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierBanqueImpl implements IMetierBanque {
    private Map<Long, Compte> comptes = new HashMap<>();
    @Override
    public void addCompte(Compte c) {
        comptes.put(c.getCode(), c);
    }

    @Override
    public Compte consulterCompte(long code) {
        return comptes.get(code);
    }

    @Override
    public void verser(long code, double montant) {
        Compte c = comptes.get(code);
        c.setSolde(c.getSolde() + montant);
    }

    @Override
    public void retirer(long code, double montant) {
        Compte c = comptes.get(code);
        c.setSolde(c.getSolde() - montant);
    }
}

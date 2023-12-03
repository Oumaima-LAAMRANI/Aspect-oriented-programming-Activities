package com.laamrani;

import com.laamrani.metier.Compte;
import com.laamrani.metier.IMetierBanque;
import com.laamrani.metier.IMetierBanqueImpl;
import javafx.application.Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }
    public void start() {
        System.out.println("Démarage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code du compte : ");
        long code = scanner.nextLong();
        System.out.println("Donner le solde initiale du compte : ");
        double solde = scanner.nextDouble();
        IMetierBanque metier = new IMetierBanqueImpl();
        metier.addCompte(new Compte(code, solde));
        while (true) {
            try {
                System.out.println("Type d'opération : ");
                System.out.println("1- Verser\t2- Retirer\t3- Consulter\t4- Quitter");
                String type = scanner.next();
                if (type.equals("4")) {
                    break;
                }
                if (type.equals("1")) {
                    System.out.println("Donner le montant : ");
                    double montant = scanner.nextDouble();
                    metier.verser(code, montant);
                } else if (type.equals("2")) {
                    System.out.println("Donner le montant : ");
                    double montant = scanner.nextDouble();
                    metier.retirer(code, montant);
                }

                System.out.println("Etat du compte : " + metier.consulterCompte(code).toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

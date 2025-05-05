package taf.resume.solution.services;

import taf.resume.solution.models.*;
import taf.resume.solution.utils.IdGenerator;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class CompteService {
    private List<Compte> comptes;
    private int compteurCheque = 0;
    private int compteurEpargne = 0;
    private final String FILE_NAME = "comptes.txt";

    public CompteService() {
        comptes = new ArrayList<>();
        chargerComptes();
    }

    public Compte creerCompteCheque() {
        compteurCheque++;
        int id = IdGenerator.generateId();
        String numero = String.format("CHEQUE_%04d", compteurCheque);
        CompteCheque compte = new CompteCheque(id, numero);
        comptes.add(compte);
        sauvegarderComptes();
        return compte;
    }

    public Compte creerCompteEpargne(int dureeBlocage) {
        compteurEpargne++;
        int id = IdGenerator.generateId();
        String numero = String.format("EPARGNE_%04d", compteurEpargne);
        CompteEpargne compte = new CompteEpargne(id, numero, dureeBlocage);
        comptes.add(compte);
        sauvegarderComptes();
        return compte;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public Compte getCompteByNumero(String numero) {
        for (Compte c : comptes) {
            if (c.getNumero().equalsIgnoreCase(numero)) {
                return c;
            }
        }
        return null;
    }

    private void sauvegarderComptes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Compte c : comptes) {
                if (c instanceof CompteCheque) {
                    writer.println("CHEQUE;" + c.getId() + ";" + c.getNumero() + ";" + c.getDateCreation() + ";" + c.getSolde());
                } else if (c instanceof CompteEpargne) {
                    CompteEpargne ce = (CompteEpargne) c;
                    writer.println("EPARGNE;" + ce.getId() + ";" + ce.getNumero() + ";" + ce.getDateCreation() + ";" + ce.getSolde() + ";" + ce.getDureeBlocage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des comptes : " + e.getMessage());
        }
    }

    private void chargerComptes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                String numero = parts[2];
                double solde = Double.parseDouble(parts[4]);

                if (type.equals("CHEQUE")) {
                    CompteCheque c = new CompteCheque(id, numero);
                    c.setSolde(solde);
                    comptes.add(c);
                    compteurCheque++;
                } else if (type.equals("EPARGNE")) {
                    int duree = Integer.parseInt(parts[5]);
                    CompteEpargne c = new CompteEpargne(id, numero, duree);
                    c.setSolde(solde);
                    comptes.add(c);
                    compteurEpargne++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des comptes : " + e.getMessage());
        }
    }
}

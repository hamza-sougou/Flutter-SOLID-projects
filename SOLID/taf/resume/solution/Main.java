package taf.resume.solution;

import taf.resume.solution.models.Compte;
import taf.resume.solution.models.Transaction;
import taf.resume.solution.services.CompteService;
import taf.resume.solution.services.TransactionService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompteService compteService = new CompteService();
        TransactionService transactionService = new TransactionService();

        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU BANCAIRE =====");
            System.out.println("1 - Creer un compte");
            System.out.println("2 - Afficher les comptes");
            System.out.println("3 - Ajouter une transaction à un compte");
            System.out.println("4 - Lister les transactions d’un compte");
            System.out.println("5 - Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.println("1 - Compte Cheque");
                    System.out.println("2 - Compte epargne");
                    System.out.print("Choix du type : ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        Compte compte = compteService.creerCompteCheque();
                        System.out.println("Compte cheque cree : " + compte.getNumero());
                    } else if (type == 2) {
                        System.out.print("Duree de blocage (en mois) : ");
                        int duree = scanner.nextInt();
                        scanner.nextLine();
                        Compte compte = compteService.creerCompteEpargne(duree);
                        System.out.println("Compte epargne cree : " + compte.getNumero());
                    } else {
                        System.out.println("Type invalide.");
                    }
                }

                case 2 -> {
                    List<Compte> comptes = compteService.getComptes();
                    if (comptes.isEmpty()) {
                        System.out.println("Aucun compte enregistre.");
                    } else {
                        comptes.forEach(System.out::println);
                    }
                }

                case 3 -> {
                    System.out.print("Numero du compte : ");
                    String numero = scanner.nextLine();
                    Compte compte = compteService.getCompteByNumero(numero);

                    if (compte == null) {
                        System.out.println("Compte introuvable.");
                    } else {
                        System.out.print("Type de transaction (Depot / Retrait) : ");
                        String type = scanner.nextLine();
                        System.out.print("Montant : ");
                        double montant = scanner.nextDouble();
                        scanner.nextLine();

                        boolean success = transactionService.ajouterTransaction(compte, type, montant);
                        if (success) {
                            System.out.println("Transaction effectuee avec succes.");
                        } else {
                            System.out.println("Echec de la transaction.");
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Numero du compte : ");
                    String numero = scanner.nextLine();
                    Compte compte = compteService.getCompteByNumero(numero);

                    if (compte == null) {
                        System.out.println("Compte introuvable.");
                    } else {
                        List<Transaction> transactions = compte.getTransactions();
                        if (transactions.isEmpty()) {
                            System.out.println("Aucune transaction enregistree.");
                        } else {
                            System.out.println("=== Transactions de " + compte.getNumero() + " ===");
                            for (Transaction t : transactions) {
                                System.out.printf("[%s] %s : %.2f%n", t.getDate(), t.getType(), t.getMontant());
                            }
                            System.out.printf("Solde actuel : %.2f%n", compte.getSolde());
                        }
                    }
                }


                case 5 -> {
                    running = false;
                    System.out.println("Merci d'avoir utilise notre systeme bancaire.");
                }

                default -> System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}

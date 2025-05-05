import 'dart:io';
import '../controllers/etudiant_controller.dart';
import '../models/note_models.dart';

class EtudiantView {
  final EtudiantController controller;

  EtudiantView({required this.controller});

  void afficherMenu() {
    while (true) {
      print('\n=== Menu Gestion Étudiants ===');
      print('1. Ajouter un étudiant');
      print('2. Afficher les étudiants');
      print('3. Ajouter une note à un étudiant');
      print('4. Afficher les notes d’un étudiant avec appréciations');
      print('5. Supprimer un étudiant');
      print('6. Afficher le meilleur étudiant');
      print('7. Afficher la moyenne de la classe');
      print('8. Quitter');
      stdout.write('Choix : ');
      String? choix = stdin.readLineSync();

      switch (choix) {
        case '1':
          ajouterEtudiant();
          break;
        case '2':
          afficherEtudiants();
          break;
        case '3':
          ajouterNote();
          break;
        case '4':
          afficherNotesEtudiant();
          break;
        case '5':
          supprimerEtudiant();
          break;
        case '6':
          afficherMeilleurEtudiant();
          break;
        case '7':
          afficherMoyenneClasse();
          break;
        case '8':
          print('Au revoir !');
          return;
        default:
          print('Choix invalide.');
      }
    }
  }

  void ajouterEtudiant() {
    stdout.write('ID : ');
    String id = stdin.readLineSync()!;
    stdout.write('Nom : ');
    String name = stdin.readLineSync()!;
    stdout.write('Âge : ');
    int age = int.parse(stdin.readLineSync()!);

    controller.addEtudiant(id: id, name: name, age: age);
    print('Étudiant ajouté.');
  }

  void afficherEtudiants() {
    final etudiants = controller.getEtudiants();
    if (etudiants.isEmpty) {
      print('Aucun étudiant enregistré.');
    } else {
      for (var e in etudiants) {
        print(e);
      }
    }
  }

  void ajouterNote() {
    stdout.write('ID de l’étudiant : ');
    String id = stdin.readLineSync()!;
    stdout.write('Matière : ');
    String matiere = stdin.readLineSync()!;
    stdout.write('Valeur : ');
    num valeur = num.parse(stdin.readLineSync()!);

    controller.addNoteToEtudiant(id, Note(matiere: matiere, value: valeur));
    print('Note ajoutée.');
  }

  void afficherNotesEtudiant() {
    stdout.write('ID de l’étudiant : ');
    String id = stdin.readLineSync()!;
    final lignes = controller.getNotesAvecAppreciations(id);

    if (lignes.isEmpty) {
      print('Aucune note trouvée ou étudiant inexistant.');
    } else {
      lignes.forEach(print);
    }
  }

  void supprimerEtudiant() {
    stdout.write('ID de l’étudiant à supprimer : ');
    String id = stdin.readLineSync()!;
    controller.supprimerEtudiant(id);
    print('Étudiant supprimé.');
  }

  void afficherMeilleurEtudiant() {
    final meilleur = controller.getMeilleurEtudiant();
    if (meilleur == null) {
      print('Aucun étudiant.');
    } else {
      print('Meilleur étudiant : ${meilleur.name} (Moyenne : ${controller.moyenne(meilleur.notes).toStringAsFixed(2)})');
    }
  }

  void afficherMoyenneClasse() {
    final moyenne = controller.getMoyenneClasse();
    print('Moyenne de la classe : ${moyenne.toStringAsFixed(2)}');
  }
}

import 'dart:io';

import '../controllers/compte_controller.dart';
import '../enums/type_transaction.dart';

class CompteView {
  final CompteController _controller = CompteController();

  void afficherMenu() async {
    int choix = -1;

    while (choix != 0) {
      print('\n==== Menu Principal ====');
      print('1. Créer un compte');
      print('2. Afficher les comptes');
      print('3. Ajouter une transaction à un compte');
      print('4. Lister les transactions d’un compte');
      print('0. Quitter');
      stdout.write('Votre choix : ');
      choix = int.tryParse(stdin.readLineSync()!) ?? -1;

      switch (choix) {
        case 1:
          await creerCompte();
          break;
        case 2:
          await afficherComptes();
          break;
        case 3:
          await ajouterTransaction();
          break;
        case 4:
          await listerTransactions();
          break;
        case 0:
          print('À bientôt !');
          break;
        default:
          print('Choix invalide. Veuillez réessayer.');
      }
    }
  }

  Future<void> creerCompte() async {
    stdout.write('ID du compte : ');
    final id = stdin.readLineSync()!;
    stdout.write('Numéro du compte : ');
    final numero = stdin.readLineSync()!;
    stdout.write('Montant initial : ');
    final montant = double.tryParse(stdin.readLineSync()!) ?? 0.0;

    print('Type de compte (1 = Normal, 2 = Épargne, 3 = Chèque) : ');
    final typeChoix = int.tryParse(stdin.readLineSync()!) ?? 1;

    String type = 'normal';
    int? dureeBlocage;

    if (typeChoix == 2) {
      type = 'epargne';
      stdout.write('Durée de blocage (en jours) : ');
      dureeBlocage = int.tryParse(stdin.readLineSync()!) ?? 0;
    } else if (typeChoix == 3) {
      type = 'cheque';
    }

    await _controller.creerCompte(
      id: id,
      numero: numero,
      montantInitial: montant,
      type: type,
      dureeBlocage: dureeBlocage,
    );
    print('✅ Compte créé avec succès.');
  }

  Future<void> afficherComptes() async {
    final comptes = await _controller.getComptes();
    if (comptes.isEmpty) {
      print('Aucun compte trouvé.');
    } else {
      for (var compte in comptes) {
        print(
          '➡️ ${compte.numero} | Solde : ${compte.montant} | Créé le : ${compte.dateCreation.toIso8601String()}',
        );
      }
    }
  }

  Future<void> ajouterTransaction() async {
    final comptes = await _controller.getComptes();
    if (comptes.isEmpty) {
      print('Aucun compte disponible.');
      return;
    }

    print('Comptes disponibles :');
    for (var i = 0; i < comptes.length; i++) {
      print('${i + 1}. ${comptes[i].numero}');
    }

    stdout.write('Sélectionnez un compte : ');
    final index = int.tryParse(stdin.readLineSync()!) ?? -1;
    if (index < 1 || index > comptes.length) {
      print('Index invalide.');
      return;
    }
    final compte = comptes[index - 1];

    stdout.write('ID de la transaction : ');
    final transId = stdin.readLineSync()!;
    stdout.write('Type (Depot ou Retrait) : ');
    final typeStr = stdin.readLineSync()!;
    final type =
        typeStr.toLowerCase() == 'depot'
            ? TypeTransaction.Depot
            : TypeTransaction.Retrait;

    stdout.write('Montant : ');
    final montant = double.tryParse(stdin.readLineSync()!) ?? 0.0;

    await _controller.ajouterTransaction(
      compteId: compte.id,
      transactionId: transId,
      type: type,
      montant: montant,
    );
    print('✅ Transaction ajoutée avec succès.');
  }

  Future<void> listerTransactions() async {
    final comptes = await _controller.getComptes();
    if (comptes.isEmpty) {
      print('Aucun compte disponible.');
      return;
    }

    print('Comptes disponibles :');
    for (var i = 0; i < comptes.length; i++) {
      print('${i + 1}. ${comptes[i].numero}');
    }

    stdout.write('Sélectionnez un compte : ');
    final index = int.tryParse(stdin.readLineSync()!) ?? -1;
    if (index < 1 || index > comptes.length) {
      print('Index invalide.');
      return;
    }
    final compte = comptes[index - 1];

    final transactions = await _controller.getTransactions(compte.id);

    if (transactions.isEmpty) {
      print('Aucune transaction pour ce compte.');
    } else {
      for (var t in transactions) {
        print(
          '➡️ ${t.id} | ${t.type.name} | ${t.montant} | ${t.date.toIso8601String()}',
        );
      }
    }
  }
}

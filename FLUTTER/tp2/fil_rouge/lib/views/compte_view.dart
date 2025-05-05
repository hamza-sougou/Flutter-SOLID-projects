import 'dart:io';
import '../controllers/compte_controller.dart';
import '../enums/type_transaction.dart';
import '../models/compte.dart';

class CompteView {
  final CompteController _controller = CompteController();

  Future<void> afficherMenu() async {
    while (true) {
      print('\n==== Menu Principal ====');
      print('1. Créer un compte');
      print('2. Afficher les comptes');
      print('3. Ajouter une transaction à un compte');
      print('4. Lister les transactions d’un compte');
      print('0. Quitter');

      stdout.write('Votre choix : ');
      final choix = stdin.readLineSync();

      switch (choix) {
        case '1':
          await creerCompte();
          break;
        case '2':
          await afficherComptes();
          break;
        case '3':
          await ajouterTransaction();
          break;
        case '4':
          await listerTransactions();
          break;
        case '0':
          exit(0);
        default:
          print('Choix invalide.');
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

    await _controller.creerCompte(
      id: id,
      numero: numero,
      montantInitial: montant,
    );

    print('Compte créé avec succès.');
  }

  Future<void> afficherComptes() async {
    final comptes = await _controller.getComptes();
    if (comptes.isEmpty) {
      print('📭 Aucun compte trouvé.');
    } else {
      for (final compte in comptes) {
        print(
          '${compte.numero} | Solde : ${compte.montant} | Créé le : ${compte.dateCreation}',
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
    final choixIndex = int.tryParse(stdin.readLineSync()!) ?? 0;

    if (choixIndex < 1 || choixIndex > comptes.length) {
      print('Choix invalide.');
      return;
    }

    final compte = comptes[choixIndex - 1];

    stdout.write('ID de la transaction : ');
    final transactionId = stdin.readLineSync()!;

    stdout.write('Type (Depot ou Retrait) : ');
    final typeInput = stdin.readLineSync()!;
    final type =
        typeInput.toLowerCase() == 'depot'
            ? TypeTransaction.Depot
            : TypeTransaction.Retrait;

    stdout.write('Montant : ');
    final montant = double.tryParse(stdin.readLineSync()!) ?? 0.0;

    await _controller.ajouterTransaction(
      compteId: compte.id,
      transactionId: transactionId,
      type: type,
      montant: montant,
    );

    print('Transaction ajoutée avec succès.');
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
    final choixIndex = int.tryParse(stdin.readLineSync()!) ?? 0;

    if (choixIndex < 1 || choixIndex > comptes.length) {
      print('Choix invalide.');
      return;
    }

    final compte = comptes[choixIndex - 1];

    final transactions = await _controller.getTransactions(compte.id);
    if (transactions.isEmpty) {
      print('📭 Aucune transaction trouvée.');
    } else {
      print('Transactions du compte ${compte.numero} :');
      for (final t in transactions) {
        print(' ${t.type.name} | ${t.montant} | ${t.date}');
      }
    }
  }
}

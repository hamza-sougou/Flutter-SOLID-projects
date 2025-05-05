import '../models/compte.dart';
import '../models/compte_cheque.dart';
import '../models/compte_epargne.dart';
import '../models/transaction.dart';
import '../services/api_service.dart';
import '../enums/type_transaction.dart';

class CompteController {
  final ApiService _apiService = ApiService();

  Future<List<Compte>> getComptes() async {
    return await _apiService.fetchComptes();
  }

  Future<void> creerCompte({
    required String id,
    required String numero,
    required double montantInitial,
    String? type,
    int? dureeBlocage,
  }) async {
    Compte compte;

    switch (type) {
      case 'cheque':
        compte = CompteCheque(
          id: id,
          numero: numero,
          dateCreation: DateTime.now(),
          montant: montantInitial,
          transactions: [],
        );
        break;
      case 'epargne':
        compte = CompteEpargne(
          id: id,
          numero: numero,
          dateCreation: DateTime.now(),
          montant: montantInitial,
          dureeBlocage: dureeBlocage ?? 0,
          transactions: [],
        );
        break;
      default:
        compte = Compte(
          id: id,
          numero: numero,
          dateCreation: DateTime.now(),
          montant: montantInitial,
          transactions: [],
        );
    }

    await _apiService.createCompte(compte);
  }

  Future<void> ajouterTransaction({
    required String compteId,
    required String transactionId,
    required TypeTransaction type,
    required double montant,
  }) async {
    List<Compte> comptes = await _apiService.fetchComptes();
    Compte? compte = comptes.firstWhere(
      (c) => c.id == compteId,
      orElse: () => throw Exception('Compte introuvable'),
    );

    if (type == TypeTransaction.Retrait) {
      if (compte is CompteEpargne && compte.estBloque()) {
        throw Exception('Retrait refusé : compte épargne encore bloqué.');
      }

      if (compte is CompteCheque) {
        final frais = montant * 0.008;
        compte.montant -= (montant + frais);
      } else {
        compte.montant -= montant;
      }
    } else {
      compte.montant += montant;
    }

    final transaction = Transaction(
      id: transactionId,
      type: type,
      montant: montant,
      date: DateTime.now(),
    );

    await _apiService.ajouterTransaction(compteId, transaction);

    await _apiService.updateCompte(compte);
  }

  Future<List<Transaction>> getTransactions(String compteId) async {
    return await _apiService.getTransactions(compteId);
  }
}

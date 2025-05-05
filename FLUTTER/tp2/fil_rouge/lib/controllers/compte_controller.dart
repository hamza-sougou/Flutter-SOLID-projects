import '../models/compte.dart';
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
  }) async {
    final compte = Compte(
      id: id,
      numero: numero,
      dateCreation: DateTime.now(),
      montant: montantInitial,
      transactions: [],
    );

    await _apiService.createCompte(compte);
  }

  Future<void> ajouterTransaction({
    required String compteId,
    required String transactionId,
    required TypeTransaction type,
    required double montant,
  }) async {
    final comptes = await _apiService.fetchComptes();
    final compte = comptes.firstWhere((c) => c.id == compteId);

    if (type == TypeTransaction.Depot) {
      compte.montant += montant;
    } else {
      if (compte.montant < montant) {
        throw Exception('Solde insuffisant pour effectuer le retrait.');
      }
      compte.montant -= montant;
    }

    await _apiService.updateCompte(compte);

    final transaction = Transaction(
      id: transactionId,
      type: type,
      montant: montant,
      date: DateTime.now(),
    );

    await _apiService.ajouterTransaction(compteId, transaction);
  }

  Future<List<Transaction>> getTransactions(String compteId) async {
    return await _apiService.getTransactions(compteId);
  }
}

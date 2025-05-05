import 'compte.dart';
import 'transaction.dart';
import '../enums/type_transaction.dart';

class CompteEpargne extends Compte {
  final int dureeBlocage;

  CompteEpargne({
    required super.id,
    required super.numero,
    required super.dateCreation,
    required super.montant,
    required super.transactions,
    required this.dureeBlocage,
  });

  bool estBloque() {
    final dureeDepuisCreation = DateTime.now().difference(dateCreation).inDays;
    return dureeDepuisCreation < dureeBlocage;
  }

  void ajouterTransaction(Transaction transaction) {
    if (transaction.type == TypeTransaction.Retrait && estBloque()) {
      throw Exception('Compte bloqué. Retrait impossible.');
    }

    if (transaction.type == TypeTransaction.Depot) {
      montant += transaction.montant;
    } else {
      if (montant >= transaction.montant) {
        montant -= transaction.montant;
      } else {
        throw Exception('Fonds insuffisants pour le retrait.');
      }
    }

    transactions.add(transaction);
  }

  factory CompteEpargne.fromMap(Map<String, dynamic> map) {
    return CompteEpargne(
      id: map['id'],
      numero: map['numero'],
      dateCreation: DateTime.parse(map['dateCreation']),
      montant: (map['montant'] as num).toDouble(),
      dureeBlocage: map['dureeBlocage'] ?? 0,
      transactions:
          (map['transactions'] as List<dynamic>?)
              ?.map((e) => Transaction.fromMap(e as Map<String, dynamic>))
              .toList() ??
          [],
    );
  }

  @override
  Map<String, dynamic> toMap() {
    final map = super.toMap();
    map['type'] = 'epargne';
    map['dureeBlocage'] = dureeBlocage;
    return map;
  }
}

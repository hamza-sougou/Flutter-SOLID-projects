import 'compte.dart';
import 'transaction.dart';
import '../enums/type_transaction.dart';

class CompteCheque extends Compte {
  static const double frais = 0.8;

  CompteCheque({
    required super.id,
    required super.numero,
    required super.dateCreation,
    required super.montant,
    required super.transactions,
  });

  void ajouterTransaction(Transaction transaction) {
    double fraisTransaction = transaction.montant * frais;

    if (transaction.type == TypeTransaction.Depot) {
      montant += transaction.montant - fraisTransaction;
    } else if (transaction.type == TypeTransaction.Retrait) {
      double total = transaction.montant + fraisTransaction;
      if (montant >= total) {
        montant -= total;
      } else {
        throw Exception('Fonds insuffisants pour le retrait avec frais.');
      }
    }

    transactions.add(transaction);
  }

  factory CompteCheque.fromMap(Map<String, dynamic> map) {
    return CompteCheque(
      id: map['id'],
      numero: map['numero'],
      dateCreation: DateTime.parse(map['dateCreation']),
      montant: (map['montant'] as num).toDouble(),
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
    map['type'] = 'cheque';
    return map;
  }
}

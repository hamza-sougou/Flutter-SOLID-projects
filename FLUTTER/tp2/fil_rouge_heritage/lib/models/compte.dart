import 'transaction.dart';

class Compte {
  final String id;
  final String numero;
  final DateTime dateCreation;
  double montant;
  final List<Transaction> transactions;

  Compte({
    required this.id,
    required this.numero,
    required this.dateCreation,
    required this.montant,
    required this.transactions,
  });

  factory Compte.fromMap(Map<String, dynamic> map) {
    return Compte(
      id: map['id'] as String,
      numero: map['numero'] as String,
      dateCreation: DateTime.parse(map['dateCreation']),
      montant: (map['montant'] as num).toDouble(),
      transactions:
          (map['transactions'] as List<dynamic>?)
              ?.map((e) => Transaction.fromMap(e as Map<String, dynamic>))
              .toList() ??
          [],
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'numero': numero,
      'dateCreation': dateCreation.toIso8601String(),
      'montant': montant,
      'transactions': transactions.map((e) => e.toMap()).toList(),
    };
  }
}

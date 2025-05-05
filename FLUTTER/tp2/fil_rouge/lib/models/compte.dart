import 'transaction.dart';

class Compte {
  final String id;
  final String numero;
  final DateTime dateCreation;
  double montant;
  List<Transaction> transactions;

  Compte({
    required this.id,
    required this.numero,
    required this.dateCreation,
    required this.montant,
    required this.transactions,
  });

  factory Compte.fromMap(Map<String, dynamic> map) {
    return Compte(
      id: map['id'],
      numero: map['numero'],
      dateCreation: DateTime.parse(map['dateCreation']),
      montant: (map['montant'] as num).toDouble(),
      transactions:
          map['transactions'] != null
              ? List<Map<String, dynamic>>.from(
                map['transactions'],
              ).map((t) => Transaction.fromMap(t)).toList()
              : [],
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'numero': numero,
      'dateCreation': dateCreation.toIso8601String(),
      'montant': montant,
      'transactions': transactions.map((t) => t.toMap()).toList(),
    };
  }
}

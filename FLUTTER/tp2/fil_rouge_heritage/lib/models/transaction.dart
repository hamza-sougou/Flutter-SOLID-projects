import '../enums/type_transaction.dart';

class Transaction {
  final String id;
  final TypeTransaction type;
  final double montant;
  final DateTime date;

  Transaction({
    required this.id,
    required this.type,
    required this.montant,
    required this.date,
  });

  factory Transaction.fromMap(Map<String, dynamic> map) {
    return Transaction(
      id: map['id'] as String,
      type: TypeTransaction.values.firstWhere(
        (e) => e.name.toLowerCase() == map['type'].toString().toLowerCase(),
        orElse: () => TypeTransaction.Depot,
      ),
      montant: (map['montant'] as num).toDouble(),
      date: DateTime.parse(map['date'] as String),
    );
  }

  Map<String, dynamic> toMap() => {
    'id': id,
    'type': type.name,
    'montant': montant,
    'date': date.toIso8601String(),
  };
}

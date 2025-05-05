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
      id: map['id'],
      type: TypeTransaction.values.firstWhere(
        (e) => e.name.toLowerCase() == (map['type'] as String).toLowerCase(),
      ),
      montant: (map['montant'] as num).toDouble(),
      date: DateTime.parse(map['date']),
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'type': type.name,
      'montant': montant,
      'date': date.toIso8601String(),
    };
  }
}

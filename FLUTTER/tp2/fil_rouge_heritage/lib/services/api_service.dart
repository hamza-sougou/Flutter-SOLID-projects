import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/compte.dart';
import '../models/compte_cheque.dart';
import '../models/compte_epargne.dart';
import '../models/transaction.dart';

class ApiService {
  final String baseUrl = 'http://localhost:3000';

  Future<List<Compte>> fetchComptes() async {
    final response = await http.get(Uri.parse('$baseUrl/comptes'));

    if (response.statusCode == 200) {
      final List<dynamic> data = json.decode(response.body);
      return data.map<Compte>((compteJson) {
        final type = compteJson['type'];
        if (type == 'cheque') {
          return CompteCheque.fromMap(compteJson);
        } else if (type == 'epargne') {
          return CompteEpargne.fromMap(compteJson);
        } else {
          return Compte.fromMap(compteJson);
        }
      }).toList();
    } else {
      throw Exception('Erreur de chargement des comptes');
    }
  }

  Future<void> createCompte(Compte compte) async {
    final response = await http.post(
      Uri.parse('$baseUrl/comptes'),
      headers: {'Content-Type': 'application/json'},
      body: json.encode(compte.toMap()),
    );

    if (response.statusCode != 201) {
      throw Exception('Erreur lors de la création du compte');
    }
  }

  Future<void> ajouterTransaction(
    String compteId,
    Transaction transaction,
  ) async {
    final uri = Uri.parse('$baseUrl/transactions');
    final map = transaction.toMap();
    map['compteId'] = compteId;

    final response = await http.post(
      uri,
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(map),
    );

    if (response.statusCode >= 400) {
      throw Exception('Erreur POST /transactions : ${response.statusCode}');
    }
  }

  Future<void> updateCompte(Compte compte) async {
    final uri = Uri.parse('$baseUrl/comptes/${compte.id}');
    final response = await http.put(
      uri,
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(compte.toMap()),
    );

    if (response.statusCode >= 400) {
      throw Exception(
        'Erreur PUT /comptes/${compte.id} : ${response.statusCode}',
      );
    }
  }

  Future<List<Transaction>> getTransactions(String compteId) async {
    final uri = Uri.parse('$baseUrl/transactions?compteId=$compteId');
    final response = await http.get(uri);

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body);
      return data.map((e) => Transaction.fromMap(e)).toList();
    } else {
      throw Exception('Erreur GET /transactions : ${response.statusCode}');
    }
  }
}

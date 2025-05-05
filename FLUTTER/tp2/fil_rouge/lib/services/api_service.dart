import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/compte.dart';
import '../models/transaction.dart';

class ApiService {
  final String baseUrl = 'http://localhost:3000';

  Future<List<Compte>> fetchComptes() async {
    final response = await http.get(Uri.parse('$baseUrl/comptes'));
    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body);
      return data.map((c) => Compte.fromMap(c)).toList();
    } else {
      throw Exception('Erreur lors du chargement des comptes');
    }
  }

  Future<void> createCompte(Compte compte) async {
    final response = await http.post(
      Uri.parse('$baseUrl/comptes'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(compte.toMap()),
    );
    if (response.statusCode != 201) {
      throw Exception('Erreur lors de la création du compte');
    }
  }

  Future<void> updateCompte(Compte compte) async {
    final url = '$baseUrl/comptes/${compte.id}';
    final response = await http.put(
      Uri.parse(url),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(compte.toMap()),
    );

    if (response.statusCode != 200) {
      throw Exception('Erreur lors de la mise à jour du compte');
    }
  }

  Future<void> ajouterTransaction(
    String compteId,
    Transaction transaction,
  ) async {
    final response = await http.post(
      Uri.parse('$baseUrl/transactions'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode({...transaction.toMap(), 'compteId': compteId}),
    );

    if (response.statusCode != 201) {
      throw Exception('Erreur POST /transactions : ${response.statusCode}');
    }
  }

  Future<List<Transaction>> getTransactions(String compteId) async {
    final response = await http.get(
      Uri.parse('$baseUrl/transactions?compteId=$compteId'),
    );

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body);
      return data.map((t) => Transaction.fromMap(t)).toList();
    } else {
      throw Exception('Erreur lors du chargement des transactions');
    }
  }
}

import '../../../../models/etudiant_models.dart';
import '../../../../interfaces/etudiant_repository_interface.dart';

class EtudiantRepositoryImpl implements EtudiantRepository {
  final List<Etudiant> _etudiants = [];

  @override
  void add({required Etudiant etudiant}) {
    _etudiants.add(etudiant);
  }

  @override
  List<Etudiant> findAll({String? nom, int? age}) {
    return _etudiants.where((etudiant) {
      final matchNom =
          nom == null ||
          etudiant.name.toLowerCase().contains(nom.toLowerCase());
      final matchAge = age == null || etudiant.age == age;
      return matchNom && matchAge;
    }).toList();
  }

  @override
  void delete(String id) {
    _etudiants.removeWhere((etudiant) => etudiant.id == id);
  }

  @override
  Etudiant? findById(String id) {
    try {
      return _etudiants.firstWhere((e) => e.id == id);
    } catch (e) {
      return null;
    }
  }
}

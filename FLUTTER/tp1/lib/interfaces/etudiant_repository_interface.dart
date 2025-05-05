import '../../../../models/etudiant_models.dart';

abstract class EtudiantRepository {
  List<Etudiant> findAll({String? nom, int? age});
  void add({required Etudiant etudiant});
  void delete(String id);
  Etudiant? findById(String id);
}

import '../interfaces/etudiant_repository_interface.dart';
import '../models/etudiant_models.dart';
import '../models/note_models.dart';
import '../mixins/calculable.dart';

class EtudiantController with Calculable {
  final EtudiantRepository _repository;

  EtudiantController({required EtudiantRepository repository})
    : _repository = repository;

  void addEtudiant({
    required String id,
    required String name,
    required int age,
  }) {
    final etudiant = Etudiant(id: id, name: name, age: age);
    _repository.add(etudiant: etudiant);
  }

  List<Etudiant> getEtudiants() {
    return _repository.findAll();
  }

  void supprimerEtudiant(String id) {
    _repository.delete(id);
  }

  void addNoteToEtudiant(String etudiantId, Note note) {
    final etudiant = _repository.findById(etudiantId);
    if (etudiant != null) {
      if (note.value >= 0 && note.value <= 20) {
        etudiant.notes.add(note);
      } else {
        throw ArgumentError("La note doit être comprise entre 0 et 20.");
      }
    }
  }

  List<String> getNotesAvecAppreciations(String etudiantId) {
    final etudiant = _repository.findById(etudiantId);
    if (etudiant == null) return [];

    return etudiant.notes.map((note) {
      final app = appreciation(note.value);
      return '${note.toString()} - Appréciation: $app';
    }).toList();
  }

  Etudiant? getMeilleurEtudiant() {
    final etudiants = _repository.findAll();
    if (etudiants.isEmpty) return null;

    etudiants.sort((a, b) => moyenne(b.notes).compareTo(moyenne(a.notes)));
    return etudiants.first;
  }

  double getMoyenneClasse() {
    final etudiants = _repository.findAll();
    if (etudiants.isEmpty) return 0.0;

    final moyennes = etudiants.map((e) => moyenne(e.notes)).toList();
    return moyennes.reduce((a, b) => a + b) / moyennes.length;
  }
}

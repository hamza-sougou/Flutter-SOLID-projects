import 'personne_model.dart';
import 'note_models.dart';

class Etudiant extends Personne {
  List<Note> notes;

  Etudiant({
    required String id,
    required String name,
    required int age,
    List<Note>? notes,
  })  : notes = notes ?? [],
        super(id, name, age);

  @override
  Map<String, dynamic> toMap() {
    return {
      "id": id,
      "name": name,
      "age": age,
      "notes": notes.map((note) => note.toMap()).toList(),
    };
  }

  factory Etudiant.fromMap(Map<String, dynamic> map) {
    return Etudiant(
      id: map["id"],
      name: map["name"],
      age: map["age"],
      notes: (map["notes"] as List<dynamic>)
          .map((noteMap) => Note.fromMap(noteMap))
          .toList(),
    );
  }

  @override
  String toString() {
    return super.toString() + " - Nombre de notes: ${notes.length}";
  }
}

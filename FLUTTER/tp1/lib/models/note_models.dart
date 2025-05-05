class Note {
  String matiere;
  num value;

  Note({required this.matiere, required this.value});

  @override
  String toString() => "Matière: $matiere Valeur: $value";

  Map<String, dynamic> toMap() {
    return {
      "matiere": matiere,
      "value": value,
    };
  }

  factory Note.fromMap(Map<String, dynamic> map) {
    return Note(
      matiere: map["matiere"],
      value: map["value"],
    );
  }
}

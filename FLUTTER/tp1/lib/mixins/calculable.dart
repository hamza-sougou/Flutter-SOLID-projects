import '../models/note_models.dart';
import '../enums/appreciation.dart';

mixin Calculable {
  double moyenne(List<Note> notes) {
    if (notes.isEmpty) return 0.0;
    final total = notes.fold(0.0, (sum, note) => sum + note.value);
    return total / notes.length;
  }

  Appreciation appreciation(num note) {
    if (note < 10) return Appreciation.Insuffisant;
    if (note < 12) return Appreciation.Passable;
    if (note < 14) return Appreciation.AssezBien;
    if (note < 16) return Appreciation.Bien;
    return Appreciation.TresBien;
  }
}

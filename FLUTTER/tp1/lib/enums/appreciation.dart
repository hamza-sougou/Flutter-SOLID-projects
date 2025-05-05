enum Appreciation {
  Insuffisant,
  Passable,
  AssezBien,
  Bien,
  TresBien
}

extension AppreciationExtension on Appreciation {
  String get label {
    switch (this) {
      case Appreciation.Insuffisant:
        return "Insuffisant";
      case Appreciation.Passable:
        return "Passable";
      case Appreciation.AssezBien:
        return "Assez Bien";
      case Appreciation.Bien:
        return "Bien";
      case Appreciation.TresBien:
        return "Très Bien";
    }
  }
}

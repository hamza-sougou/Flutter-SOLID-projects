import 'package:tp1/repositories/etudiant_repository_impl.dart';
import 'package:tp1/controllers/etudiant_controller.dart';
import 'package:tp1/views/etudiant_view.dart';

void main() {
  final repository = EtudiantRepositoryImpl();
  final controller = EtudiantController(repository: repository);
  final view = EtudiantView(controller: controller);

  view.afficherMenu();
}

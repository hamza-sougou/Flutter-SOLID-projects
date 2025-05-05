abstract class Personne{
  String id;
  String name;
  int  age;
 Personne(this.id,this.name,this.age);
 @override
 String toString() => "ID: $id Nom :$name Age:$age  ";
 //Abstract
 Map<String, dynamic> toMap();

}
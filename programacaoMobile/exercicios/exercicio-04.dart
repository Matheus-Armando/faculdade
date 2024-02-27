/* 
  4.	Crie uma lista chamada frutas e atribua algumas frutas a ela. Em seguida, imprima a lista.
*/
void main() {
  List<String> frutas = ["Maçã", "Uva", "Manga"];
  print("Minhas frutas favoritas são: ${frutas}");

  frutas.forEach((fruta) {
    print("Fruta: ${fruta}");
  });
}

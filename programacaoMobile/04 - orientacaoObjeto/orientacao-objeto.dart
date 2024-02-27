class Pessoa {
  String? nome;
  int? idade;
  double? altura;

  void dormir() {
    print("$nome está dormindo!");
  }
}

void main(List<String> args) {
  print("-----------------");
  Pessoa pessoa1 = Pessoa();
  pessoa1.nome = "Maria";
  pessoa1.idade = 30;
  pessoa1.altura = 1.67;
  pessoa1.dormir();

  Pessoa pessoa2 = Pessoa();
  pessoa2.nome = "João";
  pessoa2.idade = 40;
  pessoa2.altura = 1.80;
  pessoa2.dormir();
  print("-----------------");
  print(pessoa1.nome);
  print(pessoa1.idade);
  print(pessoa1.altura);
  print("-----------------");
  print(pessoa2.nome);
  print(pessoa2.idade);
  print(pessoa2.altura);
  print("-----------------");
}

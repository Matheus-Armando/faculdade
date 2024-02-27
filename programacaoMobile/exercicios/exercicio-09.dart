/* 
  9.	Escreve um programa que leia a nota de 5 alunos, e imprima se cada aluno está 
    aprovado ou reprovado de acordo com a sua nota.  
*/
import 'dart:io';

void main() {
  double nota;
  int contador = 0;

  for (int i = 0; i < 5; i++) {
    print('----------------------------------------');
    print('Digite a nota do aluno ${i + 1}');
    String? notaEmString = stdin.readLineSync();

    if (notaEmString == null) {
      print('Erro: Não foi possível ler a nota do aluno ${i + 1}.');
      continue;
    }

    try {
      nota = double.parse(notaEmString);
    } catch (e) {
      print('Erro: A nota inserida não é válida!');
      continue;
    }

    if (nota >= 7) {
      print('Aluno ${i + 1} está aprovado!');
    } else {
      print('Aluno ${i + 1} está reprovado!');
      contador++;
    }
  }
  print('----------------------------------------');
  print('Foram reprovados ${contador} aluno(s).');
  print('----------------------------------------');
}

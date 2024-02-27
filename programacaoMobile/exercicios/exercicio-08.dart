/* 
  08 - Escreva um programa que pergunte a idade do usuário e imprima se ele tem idade suficiente 
    para votar (18 anos ou mais) ou não.
*/

import 'dart:io';

void main() {
  print('Informe a sua idade:');
  String? idadeEmString = stdin.readLineSync();
  if (idadeEmString == null) {
    print('Erro: campo inválido!');
    return;
  }

  if (int.tryParse(idadeEmString) == null) {
    print('Erro: Idade deve ser um número!');
    return;
  }

  int idade = int.parse(idadeEmString);

  if (idade >= 18) {
    print('Você tem idade para votar.');
  } else {
    print('Você não tem idade para votar.');
  }
}

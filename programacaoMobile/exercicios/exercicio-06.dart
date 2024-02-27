/* 
  6.	Crie uma variável chamada maior e atribua a ela um algoritmo que verifique o maior número 
    entre 10, 20, e 30. Em seguida, imprima a variável.
*/
main() {
  int maior = 10;

  if (20 > maior) {
    maior = 20;
  }

  if (30 > maior) {
    maior = 30;
  }

  print('O maior número entre 10, 20 e 30 é ${maior}');
}

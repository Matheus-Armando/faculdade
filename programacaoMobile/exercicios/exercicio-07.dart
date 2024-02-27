/* 
  7.	Crie uma variável chamada menor e atribua a ela um algoritmo que verifique o menor número 
    entre 10, 20, e 30. Em seguida, imprima a variável.
*/
main() {
  int menor = 30;

  if (20 < menor) {
    menor = 20;
  }

  if (10 < menor) {
    menor = 10;
  }

  print('O menor número entre 10, 20 e 30 é ${menor}');
}

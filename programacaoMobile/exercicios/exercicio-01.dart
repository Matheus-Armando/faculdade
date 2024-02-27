/* 
  01 - Implementar um algoritmo que verifique se um determinado número é par ou ímpar.
*/
main() {
  var numero = 19;
  var valor = numero % 2;

  if (valor == 0) {
    print('Valor é par!');
  } else {
    print('Valor é impar!');
  }

  print(valor);
}

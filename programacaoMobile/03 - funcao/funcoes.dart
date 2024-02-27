void main() {
  mostrarNome();
  calcularSoma(5.50, 10.75);
  double resultado = calcularMultiplicacao(3, 10);
  print(resultado);

  double resultado2 = calcularMultiplicaocao2(4, 10);
  print(resultado2);

  String resultado3 = retornarString("Vamos ", "com tudo!!");
  print(resultado3);

  String resultado4 = retornarString2("Hoje ", "é sexta-feira!!");
  print(resultado4);
}

/* Função do tipo 'void': Não retorna nada. Também não recebe parâmetros. */
void mostrarNome() {
  print("Nome: Lucas Correia");
}

/* Função do tipo 'void': Não retorna nada. Recebe dois parâmetros do tipo double. */
void calcularSoma(double valor1, double valor2) {
  double soma = valor1 + valor2;
  print(soma);
}

/* Função do tipo 'double': Retornar um valor de números com casas decimais. 
    Recebe dois parâmetros do tipo double. 
*/
double calcularMultiplicacao(double valor1, double valor2) {
  double resultado = valor1 * valor2;
  return resultado;
}

// Sinal '=>' se chama Arrow Function. Função simplificada.
double calcularMultiplicaocao2(double valor1, double valor2) => valor1 * valor2;

/* Função do tipo 'String': Retornar um valor de caracteres. 
    Recebe dois parâmetros do tipo String. 
*/
String retornarString(String a, String b) {
  String resultado = a + b;
  return resultado;
}

/* Função do tipo String, simplificada. */
String retornarString2(String a, String b) => a + b;

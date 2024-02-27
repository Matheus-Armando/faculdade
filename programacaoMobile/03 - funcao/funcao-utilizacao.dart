late double valorTotal; // Tipo "late" retarda a inicialização da variável.
main() {
  valorTotal = 1000.00;
  print('Início função main');

  // late double resultado = 1.0;
  late double resultado = getValorTotal();
  // Somente será realizada a chamada da função 'getValorTotal()'
  // caso a variável 'resultado' for utilizada abaixo.

  print(resultado);
}

double getValorTotal() {
  print('Chamando a função _getValorTotal');
  return 8.0;
}

/* Exemplo Método main no Java

public class Principal {
      public static void main(String args[]) {
          System.out.println("Olá mundo!!");
      }
}
*/
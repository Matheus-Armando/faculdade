late double valorTotal;
main() {
  valorTotal = 1000.00;
  print('Início função main');
  late double resultado = getValorTotal();
  print(resultado);
}

double getValorTotal() {
  print('Chamando a função _getValorTotal');
  return 8.0;
}

class Carro {
  final String? modelo;

  Carro({this.modelo});

  int valor = 100000;

  //getter simplificado

  int? get getValor => valor;

  /* SEM SIMPLIFICAR
  int? getValor(){
    return valor;
    }*/

  //setter

  void setValor(int valor) => this.valor = valor;

  /*SETTER SEM SIMPLIFICAR
    void setValor(int valor){
      valor = valor
    }*/
}

main(){
  Carro fiat = Carro(modelo: 'Fiat Toro');
  Carro volks = Carro(modelo: 'Gol');

  fiat.setValor(100);
  volks.setValor(110);

  print(fiat.getValor);
  print(volks.getValor);

}

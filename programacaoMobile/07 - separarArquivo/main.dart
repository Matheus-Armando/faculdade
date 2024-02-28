import 'carro.dart';

main(){
  var velocidade = Carro(velocidadeAtual: 0);

  while(!velocidade.maxima()){
    print('Acelerando... Nova velocidade é ${velocidade.acelerar()}');
  }
  print('Velocidade máxima atingida! ${velocidade.velocidadeAtual}');

  while(velocidade.velocidadeAtual > 0){
    print('Freiando... Nova velocidade é ${velocidade.freiar()}');
  }

  print('Velocidade minima: ${velocidade.freiar()}');
}
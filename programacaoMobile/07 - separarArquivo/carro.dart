class Carro {
  final int velocidadeMaxima;
  int velocidadeAtual;

  Carro({this.velocidadeMaxima = 200, this.velocidadeAtual = 0});
 
 int acelerar(){
  if(velocidadeAtual + 5 >= velocidadeMaxima){
    velocidadeAtual = velocidadeMaxima;
  } else {
    velocidadeAtual += 5;
  }
  return velocidadeAtual;
 }

 int freiar(){
  if(velocidadeAtual - 5 <= 0){
    velocidadeAtual = 0;
  } else {
    velocidadeAtual -= 5;
  }
  return velocidadeAtual;
 }

 bool maxima(){
  return velocidadeAtual == velocidadeMaxima;
 }
}
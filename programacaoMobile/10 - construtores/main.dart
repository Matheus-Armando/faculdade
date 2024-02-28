class Data {
 int? dia;
 int? mes;
 int? ano;

 Data() {
  this.dia = 27;
 this.mes = 02;
 this.ano = 2024;}
}

var dataAtual = Data();

main(){
  print(dataAtual.ano);
  print(dataAtual.mes);
  print(dataAtual.dia);
}
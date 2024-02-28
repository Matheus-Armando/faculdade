class Pai {
  String? falar(){
    return "Gírias";
  }
}

class Filho extends Pai {}

main(){
  Filho filho = Filho();
  print(filho.falar());
}
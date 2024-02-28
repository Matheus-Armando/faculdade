main() async{
  Future<String> cepFuture = buscarCepPeloNome("Rua Brasil");

  late String cep;

  cep = await cepFuture;
  print(cep);
}

//serviço externo

Future<String> buscarCepPeloNome(String nomeRua){
  if(nomeRua == 'Rua Brasil'){
    return Future.value("85520-000");
  }
  return Future.value("CEP não encontrado");
}
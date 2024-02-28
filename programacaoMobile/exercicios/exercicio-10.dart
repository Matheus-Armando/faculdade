/*10. IMplementar uma simulação de cadastro
a)Ler as informações de nome;idade; cidade e estado;
b)) Inserir em uma lista usando Map;
c) Inserir em um arquivo .txt chamado "lista-clientes"*/

import 'dart:io';

void main(List<String> args) {
  List<Map<String, dynamic>> clientes = [];
  bool condicao = true;

  while (condicao) {
    print("Digite um comando: Cadastrar ou Sair");
    String comando = stdin.readLineSync()!;

    if (comando == "Sair") {
      print("Programa finalizado");
      condicao = false;
    } else if (comando == "Cadastrar") {
      Map<String, dynamic> cliente = {};
      print("Digite o nome do cliente:");
      cliente["nome"] = stdin.readLineSync();
      print("Digite a idade do cliente:");
      cliente["idade"] = stdin.readLineSync();
      print("Digite a cidade do cliente:");
      cliente["cidade"] = stdin.readLineSync();
      print("Digite o estado do cliente:");
      cliente["estado"] = stdin.readLineSync();
      clientes.add(cliente);
    } else {
      print("Comando inválido");
    }
  }

  Directory dir = Directory.current;
  File file = new File(dir.path + "/lista-clientes.txt");
  RandomAccessFile raf = file.openSync(mode: FileMode.write);

  clientes.forEach((cliente) {
    raf.writeStringSync("Nome: ${cliente["nome"]}, Idade: ${cliente["idade"]}, Cidade: ${cliente["cidade"]}, Estado: ${cliente["estado"]}\r\n");
  });

  raf.flushSync();
  raf.closeSync();
  print("Arquivo salvo com sucesso");
}

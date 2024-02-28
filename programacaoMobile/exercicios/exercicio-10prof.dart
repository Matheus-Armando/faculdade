/*10. IMplementar uma simulação de cadastro
a)Ler as informações de nome;idade; cidade e estado;
b)) Inserir em uma lista usando Map;
c) Inserir em um arquivo .txt chamado "lista-clientes"*/

import 'dart:io';

List<Map<String, dynamic>> listaPessoas = [];
 bool continuarCadastro = true;

void main() {
  sistemaCadastro();
}

sistemaCadastro() {
 
  limparTela();
  while (continuarCadastro = true) {
    print('***************************');
    print('****CADASTRO DE PESSOAS****');
    print('***************************');
    print('Digite um comando desejado: | Cadastrar | Imprimir | Sair |');
    String? comandoDesejado = stdin.readLineSync();
    if (comandoDesejado == 'Cadastrar') {
      limparTela();
      cadastrar();
    } else if (comandoDesejado == 'Imprimir') {
      limparTela();
      imprimir(listaPessoas);
      gravarArquivo();
    } else if (comandoDesejado == 'Sair') {
      continuarCadastro = false;
      print('**** PROGRAMA FINALIZADO ****');
      limparTela();
    } else {
      print('Comando inválido');
    }
  }
}

limparTela() {
  print('\x1B[2J\x1B[0;0H');
}

imprimir(List<Map<String, dynamic>> listaPessoas) {
  print('**** LISTA DE CLIENTES ****');
  print(listaPessoas);
}

cadastrar() {
  Map<String, dynamic> cadastro = {};
  print('-------------------------');
  print('Digite o nome do cliente:');
  cadastro['nome'] = stdin.readLineSync();

  print('-------------------------');
  print('Digite sua idade:');
  cadastro['idade'] = stdin.readLineSync();

  print('-------------------------');
  print('Digite a sua cidade:');
  cadastro['cidade'] = stdin.readLineSync();

  print('-------------------------');
  print('Digite o seu estado:');
  cadastro['estado'] = stdin.readLineSync();

  listaPessoas.add(cadastro);
}

gravarArquivo() {
  String nomeArquivo = 'lista-clientes2.txt';
  File caminhoArquivo = File(nomeArquivo);
  caminhoArquivo.createSync(recursive: true);

  late String informacoes = '';

  listaPessoas.forEach((listaPessoas) {
    String nomePessoa = listaPessoas['nome'];
    String idadePessoa = listaPessoas['idade'];
    String cidadePessoa = listaPessoas['cidade'];
    String estadoPessoa = listaPessoas['estado'];
    int totalPessoas = listaPessoas.length;

    informacoes += '***************************\n'
        '**** LISTA DE CLIENTES ****\n'
        '***************************\n'
        'Nome: $nomePessoa\n'
        'Idade: $idadePessoa\n'
        'Cidade: $cidadePessoa\n'
        'Estado: $estadoPessoa\n'
        'Total de pessoas cadastradas: $totalPessoas\n'
        '***************************\n';

    caminhoArquivo.writeAsStringSync(informacoes);
  });
  print('Arquivo salvo com sucesso!');
}

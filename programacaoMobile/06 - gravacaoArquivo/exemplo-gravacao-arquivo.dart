import 'dart:io';

void main() {
  String caminhoArquivo = 'exemplo.txt';
  String escreverArquivo = 'Eu gosto de tomar café!';

  File meuArquivo = File(caminhoArquivo);

  /* Criação do arquivo. */
  meuArquivo.createSync(recursive: true);

  /* Escrita do arquivo. */
  meuArquivo.writeAsStringSync(escreverArquivo);

  print('Foi escrito no arquivo a informação: ${escreverArquivo}');
}

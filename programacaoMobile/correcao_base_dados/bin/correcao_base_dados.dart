import 'dart:async';
import 'package:mysql1/mysql1.dart';

/* Links para estudo.
  https://pub.dev/packages/mysql1/install
  https://dart.dev/tutorials/language/streams
*/

class ConfiguracaoConfiguracaoBD {
  Future<MySqlConnection> conectarNoBancoDeDados() async {
    final conexaoComBancoDados = await MySqlConnection.connect(
        ConnectionSettings(
            host: 'localhost',
            port: 3306,
            user: 'user',
            db: 'biblioteca',
            password: 'admin'));

    return conexaoComBancoDados;
  }

  Future<void> inicializarBancoDeDados() async {
    final conn = await conectarNoBancoDeDados();
    // Criar a tabela
    await conn.query(
        'CREATE TABLE users (id int NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255), email varchar(255), age int)');

    // Inserir algum registro
    var result = await conn.query(
        'insert into users (name, email, age) values (?, ?, ?)',
        ['Lucas', 'lucas@teste.com', 33]);
    print('Registro inserido id=${result.insertId}');

    // Query do banco de dados utilizando dados parametrizados
    var results = await conn.query(
        'select name, email, age from users where id = ?', [result.insertId]);
    for (var row in results) {
      print('Name: ${row[0]}, email: ${row[1]} age: ${row[2]}');
    }

    // Atualizando o registro
    await conn.query('update users set age=? where name=?', [40, 'Lucas']);

    // Selecionado o registro atualizado
    var results2 = await conn.query(
        'select name, email, age from users where id = ?', [result.insertId]);
    for (var row in results2) {
      print('Name: ${row[0]}, email: ${row[1]} age: ${row[2]}');
    }

    // Finalizando a conexão com o banco de dados.
    await conn.close();
  }
}

Future<void> main() async {
  final configuracaoBD = ConfiguracaoConfiguracaoBD();
  await configuracaoBD.inicializarBancoDeDados();
}

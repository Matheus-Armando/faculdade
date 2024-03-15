import 'package:t1/cliente.dart';
import 'package:t1/produto.dart';
import 'package:t1/movimentacao.dart';
import 'package:t1/venda.dart';
import 'package:t1/relatorio.dart';
import 'dart:io';
void main() {
  var cadastroCliente = CadastroClientes();
  var cadastroProduto = CadastroProdutos();
  var movimentacaoEstoque = Estoque(cadastroProduto);
  var movimentacaoVenda = RealizaVenda(cadastroProduto);
  var relatorio = Relatorio();
  bool continuar = true;

  cadastroCliente.inserir(Cliente(1, 'João', 'joao@gmail.com'));
  cadastroCliente.inserir(Cliente(2, 'Maria', 'maria@gmail.com'));
  cadastroCliente.inserir(Cliente(3, 'Carlos', 'carlos@gmail.com'));
  cadastroProduto.inserir(Produto(1, 'Pomada', 10, 5.0));
  cadastroProduto.inserir(Produto(2, 'Shampoo', 5, 7.0));
  cadastroProduto.inserir(Produto(3, 'Gel Fixador', 7, 4.0));

  while(continuar == true){
    print('------------------------------------------------------');
    print('Digite 1 para cadastrar cliente');
    print('Digite 2 para buscar cliente');
    print('Digite 3 para deletar cliente');
    print('Digite 4 para imprimir clientes');
    print('Digite 5 para cadastrar produto');
    print('Digite 6 para buscar produto');
    print('Digite 7 para deletar produto');
    print('Digite 8 para imprimir produtos');
    print('Digite 9 para alterar estoque');
    print('Digite 10 para realizar venda');
    print('Digite 11 para imprimir relatório de clientes');
    print('Digite 12 para imprimir relatório de vendas');
    print('Digite 13 para sair');
    print('------------------------------------------------------');
    int opcao = int.parse(stdin.readLineSync()!);

    switch(opcao){
      case 1:
        int id = cadastroCliente.clientes.length + 1;
        print('Digite o nome do cliente:');
        String nome = stdin.readLineSync()!;
        print('Digite o email do cliente:');
        String email = stdin.readLineSync()!;
        cadastroCliente.inserir(Cliente(id, nome, email));
        break;
      case 2:
        print('Digite o nome do cliente:');
        String nome = stdin.readLineSync()!;
        var cliente = cadastroCliente.buscar(nome);
        if (cliente != null) {
          print('Cliente encontrado: $cliente');
        } else {
          print('Cliente não encontrado');
        }
        break;
      case 3:
        print('Digite o código do cliente:');
        int id = int.parse(stdin.readLineSync()!);
        cadastroCliente.deletar(id);
        break;
      case 4:
        cadastroCliente.imprimirClientes();
        break;
      case 5:
        int id = cadastroProduto.produto.length + 1;
        print('Digite a descrição do produto:');
        String descricao = stdin.readLineSync()!;
        print('Digite a quantidade do produto:');
        double qtde = double.parse(stdin.readLineSync()!);
        print('Digite o preço do produto:');
        double preco = double.parse(stdin.readLineSync()!);
        cadastroProduto.inserir(Produto(id, descricao, qtde, preco));
        break;
      case 6:
        print('Digite a descrição do produto:');
        String descricao = stdin.readLineSync()!;
        var produto = cadastroProduto.buscar(descricao);
        if (produto != null) {
          print('Produto encontrado: $produto');
        } else {
          print('Produto não encontrado');
        }
        break;
      case 7:
        print('Digite o código do produto:');
        int id = int.parse(stdin.readLineSync()!);
        cadastroProduto.deletar(id);
        break;
      case 8:
        cadastroProduto.imprimir();
        break;
      case 9:
        print('Digite a descrição do produto:');
        String descricao = stdin.readLineSync()!;
        print('Digite a quantidade do produto:');
        double qtde = double.parse(stdin.readLineSync()!);
        movimentacaoEstoque.alteraEstoque(descricao, qtde);
        break;
      case 10:
        cadastroProduto.imprimir();
        movimentacaoVenda.realizaVenda();
        break;
      case 11:
        relatorio.relatorioCliente(cadastroCliente);
        break;
      case 12:
        relatorio.relatorioVenda(movimentacaoVenda);
        break;
      case 13:
        continuar = false;
        print('Saindo...');
        break;
    }
  }
}
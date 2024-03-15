import 'package:t1/cliente.dart';

import 'produto.dart';
import 'dart:io';

class Venda {
  int id;
  List<Produto> _produtosVendidos = [];
  double valorTotal;
  double desconto;
  String nomeCliente;

  Venda(this.id, this._produtosVendidos, this.valorTotal, this.desconto,
      this.nomeCliente);

  List<Produto> get produtosVendidos => _produtosVendidos;

  @override
  String toString() {
    return 'Código: $id, Produtos vendidos: $_produtosVendidos, Valor total: $valorTotal, Desconto: $desconto';
  }
}

class RealizaVenda {
  CadastroProdutos cadastroProduto;
  CadastroClientes cadastroCliente;
  RealizaVenda(this.cadastroProduto, this.cadastroCliente);

  final List<Venda> _vendas = [];

  List<Venda> get vendas => _vendas;

  validaQuantidade(String nomeProduto, double qtdeVendida) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      if (produto.qtde >= qtdeVendida) {
        produto.alterarQuantidade(produto.qtde - qtdeVendida);
        return true;
      } else {
        print('Quantidade insuficiente');
        return false;
      }
    } else {
      return false;
    }
  }

  void realizaVenda() {
    String continuar = 's';
    double valorFinal = 0;
    List<Produto> produtosVenda = [];
    var valida = true;
    var validaCliente = true;
    String? nomeCliente;

    while (validaCliente) {
      print('Deseja adicionar um cliente? (s - Sim, n - Não)');
      String adicionarCliente = stdin.readLineSync()!;
      if (adicionarCliente == 'n') {
        nomeCliente = 'Não informado';
        validaCliente = false;
        break;
      } else {
        cadastroCliente.imprimirClientes();
        print('Digite o nome do cliente:');
        nomeCliente = stdin.readLineSync();
        var cliente = cadastroCliente.buscar(nomeCliente!);
        if (cliente != null) {
          print('Cliente encontrado: $cliente');
          validaCliente = false;
          break;
        } else {
          print('Cliente não encontrado');
        }
      }
    }

    while (continuar == 's') {
      cadastroProduto.imprimir();
      print('Digite o nome do produto:');
      String? nomeProduto = stdin.readLineSync();
      var produto = cadastroProduto.buscar(nomeProduto!);
      if (produto != null) {
        print('Produto encontrado: $produto');
        print('Digite a quantidade vendida:');
        double? qtdeVendida = double.parse(stdin.readLineSync()!);
        valida = validaQuantidade(nomeProduto, qtdeVendida);
        if (valida) {
          produtosVenda.add(Produto(
              produto.id, produto.descricao, qtdeVendida, produto.preco));
        }
      } else {
        print('Produto não encontrado');
      }
      print('Deseja continuar? (s - Sim, n - Não)');
      String continuar = stdin.readLineSync()!;
      if (continuar == 'n') {
        break;
      }
    }
    if (valida) {
      print("Valor do desconto:");
      double? desconto = double.parse(stdin.readLineSync()!);
      for (var produto in produtosVenda) {
        valorFinal += produto.preco * produto.qtde;
      }
      valorFinal -= desconto;
      _vendas.add(Venda(_vendas.length + 1, List.from(produtosVenda),
          valorFinal, desconto, nomeCliente!));
    }
    produtosVenda.clear();
  }

  void imprimir() {
    for (var venda in _vendas) {
      print(venda);
    }
  }
}

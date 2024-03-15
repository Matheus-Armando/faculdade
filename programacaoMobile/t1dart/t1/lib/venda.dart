import 'produto.dart';
import 'dart:io';

class Venda {
  int id;
  List<Produto> _produtosVendidos = [];
  double valorTotal;
  double desconto;

  Venda(this.id,this._produtosVendidos, this.valorTotal, this.desconto);

  List<Produto> get produtosVendidos => _produtosVendidos;

  @override
  String toString() {
    return 'Código: $id, Produtos vendidos: $_produtosVendidos, Valor total: $valorTotal, Desconto: $desconto';
  }
}

class RealizaVenda {
  CadastroProdutos cadastroProduto;

  RealizaVenda(this.cadastroProduto);
  final List<Venda> _vendas = [];
  List<Produto> produtosVendidos = [];
  List<Venda> get vendas => _vendas;

  // void venderProduto(String nomeProduto, double qtdeVendida) {
  //   var produto = cadastroProduto.buscar(nomeProduto);
  //   if (produto != null) {
  //     print('Produto encontrado: $produto');
  //     if (produto.qtde >= qtdeVendida) {
  //       produto.alterarQuantidade(produto.qtde - qtdeVendida);
  //     } else {
  //       print('Quantidade insuficiente');
  //     }
  //   } else {
  //     print('Produto não encontrado');
  //   }
  // }

  validaQuantidade(String nomeProduto, double qtdeVendida) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      if (produto.qtde >= qtdeVendida) {
        return true;
      } else {
        print('Quantidade insuficiente');
      }
    } else {
      return false;
    }
  }

  void realizaVenda() {
    String continuar = 's';
    double valorFinal = 0;
    while (continuar == 's') {
      print('Digite o nome do produto:');
      String? nomeProduto = stdin.readLineSync();
      var produto = cadastroProduto.buscar(nomeProduto!);
      if (produto != null) {
        print('Produto encontrado: $produto');
        print('Digite a quantidade vendida:');
        double? qtdeVendida = double.parse(stdin.readLineSync()!);
        var valida = validaQuantidade(nomeProduto, qtdeVendida);
        if (valida) {
          produtosVendidos.add(Produto(produto.id, produto.descricao, qtdeVendida, produto.preco));
        }
        else {
          print('Quantidade insuficiente');
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
    print("Valor do desconto:");
    double? desconto = double.parse(stdin.readLineSync()!);
    for (var produto in produtosVendidos) {
      valorFinal += produto.preco * produto.qtde;
    }
    valorFinal -= desconto;
    _vendas.add(Venda(_vendas.length + 1,produtosVendidos, valorFinal, desconto));
  }

  void imprimir() {
    for (var venda in _vendas) {
      print(venda);
    }
  }
}

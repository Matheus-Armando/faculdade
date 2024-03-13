import 'produto.dart';

class Estoque {
  CadastroProdutos cadastroProduto;

  Estoque(this.cadastroProduto);

  void alteraEstoque(String nomeProduto, double novaQtde) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      print('Produto encontrado: $produto');
      produto.alterarQuantidade(novaQtde); // Altera a quantidade do produto
    } else {
      print('Produto não encontrado');
    }
  }
  void alteraPreco(String nomeProduto, double novoPreco) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      print('Produto encontrado: $produto');
      produto.alterarPreco(novoPreco); // Altera o preço do produto
    } else {
      print('Produto não encontrado');
    }
  }
}

class Venda{
  CadastroProdutos cadastroProduto;

  Venda(this.cadastroProduto);

  void venderProduto(String nomeProduto, double qtdeVendida) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      print('Produto encontrado: $produto');
      if (produto.qtde >= qtdeVendida) {
        produto.alterarQuantidade(produto.qtde - qtdeVendida);
      } else {
        print('Quantidade insuficiente');
      }
    } else {
      print('Produto não encontrado');
    }
  }
}
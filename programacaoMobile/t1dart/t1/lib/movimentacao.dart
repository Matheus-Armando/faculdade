import 'produto.dart';

class MovimentacaoEstoque{
  int id;
  String produto;
  double qtdeAntiga;
  double qtdeNova;

  MovimentacaoEstoque(this.id, this.produto, this.qtdeAntiga, this.qtdeNova);

   @override
  String toString() {
    return 'Código: $id, Produto: $produto, Qtde antiga: $qtdeAntiga, Qtde nova: $qtdeNova';
  }
}

class Estoque {
  CadastroProdutos cadastroProduto;

  Estoque(this.cadastroProduto);
  final List<MovimentacaoEstoque> _movimentacaoEstoque = [];

  void alteraEstoque(String nomeProduto, double novaQtde) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      print('Produto encontrado: $produto');
      if(produto.deleted == false){
        produto.alterarQuantidade(novaQtde); 
        _movimentacaoEstoque.add(MovimentacaoEstoque(_movimentacaoEstoque.length + 1, nomeProduto, produto.qtde, novaQtde));
      }
    } else {
      print('Produto não encontrado');
    }
  }
  void alteraPreco(String nomeProduto, double novoPreco) {
    var produto = cadastroProduto.buscar(nomeProduto);
    if (produto != null) {
      print('Produto encontrado: $produto');
      if(produto.deleted == false){
         produto.alterarPreco(novoPreco);
        //_movimentacaoEstoque.add(MovimentacaoEstoque(_movimentacaoEstoque.length + 1, nomeProduto, produto.preco, novoPreco));
      }
    } else {
      print('Produto não encontrado');
    }
  }

  void imprimirMovimentacaoEstoque() {
    for (var movimentacao in _movimentacaoEstoque) {
      print(movimentacao);
    }
  }
}

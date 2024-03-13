class Produto {
  int id;
  String descricao;
  double qtde;
  double preco;

  Produto(this.id, this.descricao, this.qtde, this.preco);

  void alterarQuantidade(double novaQtde) {
    qtde = novaQtde;
  }

   void alterarPreco(double novaPreco) {
    preco = novaPreco;
  }

  @override
  String toString() {
    return 'Código: $id, Descrição: $descricao, Quantidade: $qtde, Preço: $preco';
  }
}

class CadastroProdutos {
  final List<Produto> _produto = [];

  List<Produto> get produto => _produto;

  void inserir(Produto produto) {
    _produto.add(produto);
  }

  Produto? buscar(String descricao) {
    for (var produto in _produto) {
      if (produto.descricao == descricao) {
        return produto;
      }
    }
    return null;
  }

  void deletar(int id) {
    _produto.removeWhere((cliente) => cliente.id == id);
  }

  void imprimir() {
    for (var produto in _produto) {
      print(produto);
    }
  }
}


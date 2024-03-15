class Produto {
  int id;
  String descricao;
  double qtde;
  double preco;
  bool deleted = false;

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
        if (produto.deleted == true) {
          print('Produto deletado');
        } else {
          return produto;
        }
      }
    }
    return null;
  }

  void deletar(int id) {
    if (_produto.isEmpty) {
      print('Não há produtos cadastrados');
    }
    if (_produto.length < id) {
      print('Produto não encontrado');
    } else {
      var produto = _produto.firstWhere((p) => p.id == id);
        produto.deleted = true;
    }
    //_produto.removeWhere((cliente) => cliente.id == id);
  }

  void imprimir() {
    if (_produto.isEmpty) {
      print('Não há produtos cadastrados');
    } else {
      for (var produto in _produto) {
        if (produto.deleted == false) {
          print(produto);
        }
      }
    }
  }
}

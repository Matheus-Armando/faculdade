import 'package:t1/cliente.dart';
import 'package:t1/produto.dart';
import 'package:t1/movimentacao.dart';

void main() {
  var cadastroCliente = CadastroClientes();
  var cadastroProduto = CadastroProdutos();
  var movimentacaoEstoque = Estoque(cadastroProduto);
  var movimentacaoVenda = Venda(cadastroProduto);

  cadastroCliente.inserir(Cliente(1, 'João', 'joao@gmail.com'));
  cadastroCliente.inserir(Cliente(2, 'Maria', 'maria@gmail.com'));
  print('------------------------------------------------------');
  print('-----------------Cadastro de Clientes-----------------');
  print('------------------------------------------------------');
  cadastroCliente.imprimirClientes();

  var cliente = cadastroCliente.buscar('João');
  if (cliente != null) {
    print('Cliente encontrado: $cliente');
  } else {
    print('Cliente não encontrado');
  }

  cadastroCliente.deletar(2);

  print('Clientes após deletar:');
  cadastroCliente.imprimirClientes();

  print('------------------------------------------------------');
  print('-----------------Cadastro de Produtos-----------------');
  print('------------------------------------------------------');

  cadastroProduto.inserir(Produto(1, 'Arroz', 10, 5.0));
  cadastroProduto.inserir(Produto(2, 'Feijão', 5, 7.0));
  cadastroProduto.inserir(Produto(3, 'Macarrão', 7, 4.0));

  print('Produtos após inserção:');
  cadastroProduto.imprimir();

  var produto = cadastroProduto.buscar('Arroz');
  if (produto != null) {
    print('Produto encontrado: $produto');
  } else {
    print('Produto não encontrado');
  }
  cadastroProduto.deletar(1);
  print("Produtos após deletar:");
  cadastroProduto.imprimir();

  print('------------------------------------------------------');
  print('----------------Movimentação de Estoque---------------');
  print('------------------------------------------------------');
  movimentacaoEstoque.alteraEstoque('Arroz', 15);
  movimentacaoEstoque.alteraEstoque('Feijão', 10);
  movimentacaoEstoque.alteraPreco('Macarrão', 5.4);
  print('------------------------------------------------------');
  print('Produtos após movimentação:');
  cadastroProduto.imprimir();

  print('------------------------------------------------------');
  print('------------------------Vendas------------------------');
  print('------------------------------------------------------');
  movimentacaoVenda.venderProduto('Arroz', 5);
  movimentacaoVenda.venderProduto('Feijão', 3);
  print('Produtos após Venda');
  cadastroProduto.imprimir();
}
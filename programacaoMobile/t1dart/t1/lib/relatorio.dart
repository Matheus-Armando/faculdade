import 'package:t1/venda.dart';
import 'cliente.dart';
import 'package:intl/intl.dart';

class Relatorio{
  void relatorioCliente(CadastroClientes cadastroCliente){
    cadastroCliente.clientes.sort((a, b) => a.nome.compareTo(b.nome));
    print('------------------------------------------------------');
    print('----------------Relatório de Clientes-----------------');
    print('------------------------------------------------------');
    print('------------------Ordenado por nome-------------------');
    print('------------------------------------------------------');
    for (var cliente in cadastroCliente.clientes) {
      print('Código: ${cliente.id} - Nome: ${cliente.nome}');
      print('......................................................');
    }
    print('------------------------------------------------------');
    print('-------------------------Data atual: ${DateFormat('dd/MM/yyyy').format(DateTime.now())}}');
  }

  void relatorioVenda(RealizaVenda realizaVenda){
    print('------------------------------------------------------');
    print('----------------Relatório de Clientes-----------------');
    print('------------------------------------------------------');
    print('------------------Ordenado por nome-------------------');
    print('------------------------------------------------------');
    for (var venda in realizaVenda.vendas) {
      print('Código: ${venda.id} - Valor: ${venda.valorTotal} Desconto: ${venda.desconto}');
      print('......................................................');
      for (var produto in venda.produtosVendidos) {
        print('Produto: ${produto.descricao} - Quantidade: ${produto.qtde}');
        print('......................................................');
      }
    }
    print('------------------------------------------------------');
    print('-------------------------Data atual: ${DateFormat('dd/MM/yyyy').format(DateTime.now())}}');
  }
}
class Cliente {
  int id;
  String nome;
  String email;

  Cliente(this.id, this.nome, this.email);

  @override
  String toString() {
    return 'Código: $id, Nome: $nome, Email: $email';
  }
}

class CadastroClientes {
  final List<Cliente> _clientes = [];

  List<Cliente> get clientes => _clientes;

  void inserir(Cliente cliente) {
    _clientes.add(cliente);
  }

  Cliente? buscar(String nome) {
    for (var cliente in _clientes) {
      if (cliente.nome == nome) {
        return cliente;
      }
    }
    return null;
  }

  void deletar(int id) {
    _clientes.removeWhere((cliente) => cliente.id == id);
  }

  void imprimirClientes() {
    if (_clientes.isEmpty){
      print('Não há clientes cadastrados');
    }else{
      for (var cliente in _clientes) {
        print(cliente);
      }
    }
  }
}


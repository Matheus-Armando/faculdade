function excluirAutor(idAutor) {
    fetch(`http://localhost:8080/autor/${idAutor}`, { 
        method: 'DELETE',
    })
    .then(response => {
        if (response.status === 200){
            // Autor excluído com sucesso, atualizar a lista de autores
            fetchAutores();
        }
    })
    .catch(error => console.error(error));
}

function alterarAutor(idAutor){
    
    window.location = 'autor-alterar.html?idAutor='+idAutor;
}
function getParametros(){
    
    //
    let querySelect = window.location.search;
    let urlParam = new URLSearchParams(querySelect);
    let id = urlParam.get('idAutor');
    carregarAlterar(id);
}
function carregarAlterar(id){
    
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/autor/"+id;
    xmlhttp.open('GET', url);
    xmlhttp.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xmlhttp.send();
    xmlhttp.onloadend = () => {
        console.log(xmlhttp.response);
        let autor = JSON.parse(xmlhttp.response);
        let inputId = document.getElementById('idAutor');
        inputId.value = autor.idAutor;
		let inputBiografia = document.getElementById('biografia');
		inputBiografia.value = autor.biografia;
        let inputNome = document.getElementById('nome');
        inputNome.value = autor.nome;
    };
}
function alterarNoBanco(){
    debugger;
    const id = document.getElementById('idAutor').value;
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
    //definindo a url a ser enviada os dados
    var url = "http://localhost:8080/autor";
    //definindo o protocolo e url a ser enviado
    xmlhttp.open("POST", url);
    //definindo o formato dos dados a ser enviado ao servidor
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    
    //buscando o elemento no HTML sendo buscado pelo Id
    var inputNome = document.getElementById('nome');
	var inputBiografia = document.getElementById('biografia');
    //criando um objeto, para atribuir os dados e enviar para o servidor
    var values = new Object();
    //atribuindo o nome ao objeto
    values.nome = inputNome.value;
    values.idAutor = id;
	values.biografia = inputBiografia.value;
    //realizando o envio dos dados para o servidor
    xmlhttp.send(JSON.stringify(values));
    //realizando a navegação para a tela de listagem
    window.location = 'home.html';
}

function buscaPorCodigo(){
    debugger;
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
    var idPesquisado = document.getElementById('idPesquisado').value;
    var url = "http://localhost:8080/autor/"+idPesquisado; 
    xmlhttp.open("GET", url); 
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send();
    xmlhttp.onloadend = () => {
       console.log(xmlhttp.response);
       console.log(xmlhttp.response);
        if (xmlhttp.status === 200 && xmlhttp.response) {
            // Verifique se a resposta está OK (código 200) e não está vazia
            let autor = JSON.parse(xmlhttp.response);
            montarTableCodigo(autor);
        } else {
            // Caso contrário, exiba uma mensagem de erro na tabela
            montarTableCodigo(null);
        }
    };
}
function montarTableCodigo(lista){
    var table = document.getElementById("table");
    
    // Limpa o conteúdo da tabela (exceto a primeira linha de cabeçalho)
    while (table.rows.length > 1) {
        table.deleteRow(1);
    }
    
    if (lista) {
        // Cria uma nova linha na tabela
        var newRow = table.insertRow(1);

        // Cria células para ID, Nome e Biografia
        var idCell = newRow.insertCell(0);
        var nomeCell = newRow.insertCell(1);
        var biografiaCell = newRow.insertCell(2);

        // Preenche as células com os dados do autor
        idCell.innerHTML = lista.idAutor;
        nomeCell.innerHTML = lista.nome;
        biografiaCell.innerHTML = lista.biografia;
    } else {
        // Se nenhum autor foi encontrado, exibe uma mensagem na tabela
        var newRow = table.insertRow(1);
        var cell = newRow.insertCell(0);
        cell.colSpan = 3; // Mescla todas as colunas
        cell.innerHTML = "Nenhum autor encontrado com o ID informado.";
    }
        
}
function voltarInicio(){
    window.location = 'home.html';
}

function inserirAutor() {
    //instanciando o objeto que permite fazer a requisição
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
    //definindo a url a ser enviada os dados
    var url = "http://localhost:8080/autor";
    //definindo o protocolo e url a ser enviado
    xmlhttp.open("POST", url);
    //definindo o formato dos dados a ser enviado ao servidor
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    
    //buscando o elemento no HTML sendo buscado pelo Id
    var inputNome = document.getElementById('nome');
    var inputBiografia = document.getElementById('biografia');
    //criando um objeto, para atribuir os dados e enviar para o servidor
    var values = new Object();
    //atribuindo o nome ao objeto
    values.nome = inputNome.value;
    values.biografia = inputBiografia.value;

    // Configurar um listener de evento para aguardar a resposta
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200){
            // Autor criado com sucesso, atualizar a lista de autores
            fetchAutores();
            // Redirecionar para a tela de listagem
            window.location = 'home.html';
        }
    };
    
    //realizando o envio dos dados para o servidor
    xmlhttp.send(JSON.stringify(values));
}

function fetchAutores() {
    fetch('http://localhost:8080/autor')
    .then(response => response.json())
    .then(data => {
        const autoresTable = document.getElementById('autoresTable');
        autoresTable.innerHTML = ''; // Limpar a tabela
        data.forEach(autor => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${autor.idAutor}</td>
                <td>${autor.nome}</td>
                <td>${autor.biografia}</td>
                <td>
                    <button onclick="excluirAutor(${autor.idAutor})">Excluir</button>
                </td>
				<td>
                    <button onclick="alterarAutor(${autor.idAutor})">Alterar</button>
                </td>
				
            `;
            autoresTable.appendChild(row);
        });
    })
    .catch(error => console.error(error));
}

fetchAutores();
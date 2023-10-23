document.addEventListener('DOMContentLoaded', function () {
    const autorForm = document.getElementById('autorForm');
    autorForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const nome = document.getElementById('nome').value;
        const biografia = document.getElementById('biografia').value;

        fetch('http://localhost:1433/musicologia/autor', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ nome, biografia }),
        })
        .then(response => response.json())
        .then(data => {
            document.getElementById('nome').value = '';
            document.getElementById('biografia').value = '';
            fetchAutores();
        })
        .catch(error => console.error(error));
    });

    function fetchAutores() {
        fetch('http://localhost:1433/musicologia/autor')
        .then(response => response.json())
        .then(data => {
            const autoresTable = document.getElementById('autoresTable');
            autoresTable.innerHTML = ''; // Limpar a tabela
            data.forEach(autor => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${autor.id}</td>
                    <td>${autor.nome}</td>
                    <td>${autor.biografia}</td>
                    <td>
                        <button class="excluir-button" data-id="${autor.id}">Excluir</button>
                    </td>
                `;
                autoresTable.appendChild(row);
            });

            // Adicionar ouvintes de evento para os botões de exclusão
            const excluirButtons = document.querySelectorAll('.excluir-button');
            excluirButtons.forEach(button => {
                button.addEventListener('click', function () {
                    const id = button.getAttribute('data-id');
                    excluirAutor(id);
                });
            });
        })
        .catch(error => console.error(error));
    }

    function excluirAutor(id) {
        fetch(`http://localhost:1433/musicologia/autor/${id}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.status === 204) {
                // Autor excluído com sucesso, atualizar a lista de autores
                fetchAutores();
            }
        })
        .catch(error => console.error(error));
    }

    fetchAutores();
});

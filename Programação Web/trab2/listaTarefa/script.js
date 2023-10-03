document.addEventListener('DOMContentLoaded', function () {
    const tarefaInput = document.getElementById('tarefaInput');
    const adicionarBtn = document.getElementById('adicionarBtn');
    const listaTarefas = document.getElementById('listaTarefas');

    adicionarBtn.addEventListener('click', function () {
        const tarefaTexto = tarefaInput.value.trim();
        
        if (tarefaTexto !== '') {
            const li = document.createElement('li');
            li.innerHTML = `
                ${tarefaTexto}
                <button class="removerBtn">Remover</button>
            `;
            listaTarefas.appendChild(li);

            tarefaInput.value = '';
        }
    });

    listaTarefas.addEventListener('click', function (e) {
        if (e.target.classList.contains('removerBtn')) {
            e.target.parentElement.remove();
        }
    });

    tarefaInput.addEventListener('keypress', function (e) {
        if (e.key === 'Enter') {
            adicionarBtn.click();
        }
    });
});

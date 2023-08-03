import tkinter as tk
from tkinter import ttk

# Dicionário para armazenar as solicitações de alteração por CNPJ
solicitacoes_alteracao = {}

def adicionar_solicitacao():
    cnpj = entry_cnpj.get()
    nome_relatorio = entry_relatorio.get()
    observacoes = entry_observacoes.get("1.0", tk.END)
    plano = selected_plano.get()
    
    # Verifica se o CNPJ já possui solicitações de alteração
    if cnpj in solicitacoes_alteracao:
        solicitacoes_alteracao[cnpj].append((nome_relatorio, observacoes, plano))
    else:
        solicitacoes_alteracao[cnpj] = [(nome_relatorio, observacoes, plano)]
    
    # Limpa a lista de solicitações
    listbox_solicitacoes.delete(0, tk.END)
    
    # Atualiza a lista de solicitações com as novas inserções
    for cnpj, solicitacoes in solicitacoes_alteracao.items():
        for i, solicitacao in enumerate(solicitacoes):
            listbox_solicitacoes.insert(tk.END, f"CNPJ: {cnpj}")
            listbox_solicitacoes.insert(tk.END, f"Solicitação {i+1}:")
            listbox_solicitacoes.insert(tk.END, f"Nome do relatório: {solicitacao[0]}")
            listbox_solicitacoes.insert(tk.END, f"Observações: {solicitacao[1]}")
            listbox_solicitacoes.insert(tk.END, f"Plano: {solicitacao[2]}")
            listbox_solicitacoes.insert(tk.END, "")  # Linha em branco para separar as solicitações

# Criação da janela
window = tk.Tk()
window.title("Solicitação de Alteração")

# Label e campo de entrada para o CNPJ
label_cnpj = tk.Label(window, text="CNPJ:")
label_cnpj.pack()
entry_cnpj = tk.Entry(window, width=25)
entry_cnpj.pack()

# Frame para os Radiobuttons dos planos
frame_planos = tk.Frame(window)
frame_planos.pack()

# Variável para armazenar o plano selecionado
selected_plano = tk.StringVar()

# Função para imprimir o plano selecionado
def imprimir_plano():
    print(selected_plano.get())

# Opções de plano
label_plano = tk.Label(frame_planos, text="Escolha o plano:")
label_plano.pack(side=tk.TOP)
selected_plano = tk.IntVar()
radio_plano1 = tk.Radiobutton(frame_planos, text="Plano 1", variable=selected_plano, value=1)
radio_plano1.pack(side=tk.LEFT)
radio_plano2 = tk.Radiobutton(frame_planos, text="Plano 2", variable=selected_plano, value=2)
radio_plano2.pack(side=tk.LEFT)
radio_plano3 = tk.Radiobutton(frame_planos, text="Plano 3", variable=selected_plano, value=3)
radio_plano3.pack(side=tk.LEFT)
radio_plano4 = tk.Radiobutton(frame_planos, text="Plano 4", variable=selected_plano, value=4)
radio_plano4.pack(side=tk.LEFT)
radio_plano5 = tk.Radiobutton(frame_planos, text="Plano 5", variable=selected_plano, value=5)
radio_plano5.pack(side=tk.LEFT)
radio_plano6 = tk.Radiobutton(frame_planos, text="Plano 6", variable=selected_plano, value=6)
radio_plano6.pack(side=tk.LEFT)
radio_plano7 = tk.Radiobutton(frame_planos, text="Sem custo", variable=selected_plano, value=7)
radio_plano7.pack(side=tk.LEFT)

# Label e campo de entrada para o nome do relatório
label_relatorio = tk.Label(window, text="Nome do Relatório:")
label_relatorio.pack()
entry_relatorio = tk.Entry(window, width=50)
entry_relatorio.pack()

# Label e campo de entrada para as observações
label_observacoes = tk.Label(window, text="Observações:")
label_observacoes.pack()
entry_observacoes = tk.Text(window, height=10, width=200)
entry_observacoes.pack()

# Botão para adicionar a solicitação de alteração
button_adicionar = tk.Button(window, text="Adicionar Solicitação", command=adicionar_solicitacao)
button_adicionar.pack()

# Lista de solicitações
label_solicitacoes = tk.Label(window, text="Solicitações:")
label_solicitacoes.pack()
listbox_solicitacoes = tk.Listbox(window, width=50)
list

# Listbox para exibir as solicitações
listbox_solicitacoes = tk.Listbox(window, width=200, height = 20)
listbox_solicitacoes.pack()

window.mainloop()


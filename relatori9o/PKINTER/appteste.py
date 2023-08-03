from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('solicitacao.html')

if __name__ == '__main__':
    app.run()

    @app.route('/')
def index():
    # Processar os dados da solicitação
    resultado = processar_solicitacao()

    # Renderizar a página HTML com o resultado
    return render_template('solicitacao.html', resultado=resultado)

def verificar_cnpj():
    cnpj = entry_cnpj.get()
    
    # Aqui você pode adicionar a lógica para verificar o CNPJ
    
    # Exemplo de exibição do resultado
    if cnpj == "123456789":
        label_resultado.config(text="CNPJ válido")
    else:
        label_resultado.config(text="CNPJ inválido")

def escolher_plano():
    plano = selected_plano.get()

# Criação da janela
window = tk.Tk()
window.title("Verificar CNPJ")

# Label e campo de entrada para o CNPJ
label_cnpj = tk.Label(window, text="CNPJ:")
label_cnpj.pack()
entry_cnpj = tk.Entry(window)
entry_cnpj.pack()

# Opções de plano
label_plano = tk.Label(window, text="Escolha o plano:")
label_plano.pack()
selected_plano = tk.IntVar()
radio_plano1 = tk.Radiobutton(window, text="Plano 1", variable=selected_plano, value=1)
radio_plano1.pack()
radio_plano2 = tk.Radiobutton(window, text="Plano 2", variable=selected_plano, value=2)
radio_plano2.pack()
radio_plano3 = tk.Radiobutton(window, text="Plano 3", variable=selected_plano, value=3)
radio_plano3.pack()
radio_plano4 = tk.Radiobutton(window, text="Plano 4", variable=selected_plano, value=4)
radio_plano4.pack()
radio_plano5 = tk.Radiobutton(window, text="Plano 5", variable=selected_plano, value=5)
radio_plano5.pack()
radio_plano6 = tk.Radiobutton(window, text="Plano 6", variable=selected_plano, value=6)
radio_plano6.pack()

# Botão para verificar o CNPJ
button_verificar = tk.Button(window, text="Verificar", command=verificar_cnpj)
button_verificar.pack()

# Label para exibir o resultado
label_resultado = tk.Label(window, text="")
label_resultado.pack()

# Execução da interface gráfica
window.mainloop()
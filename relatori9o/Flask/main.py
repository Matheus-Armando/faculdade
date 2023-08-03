from flask import Flask, render_template

app = Flask(__name__)

#criar a 1 pagina do site
#   route -> usa para criar pagina prinpipal, paginas secundarias e tudo mais
#   funcao -> o que eu vou colocar detnro da pagina
#   template ->

@app.route("/")
def homepage():
    return render_template("homepage.html")

@app.route("/solicitarrelatorio")
def solicitarrelatorio():
    return render_template("solicitarrelatorio.html")

#colocar site no ar
if __name__ == "__main__":
    app.run(debug=True)
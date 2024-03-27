const axios = require('axios');
const fs = require('fs');

const url = "https://cep.awesomeapi.com.br/json/";

const headers = {
  'Content-Type': 'application/json'
};

let ceps = [1111,13465000, 85504540, 13285324];
let info = [];
  
  (async () => {
    for (const cep of ceps) {
      await new Promise(resolve => setTimeout(resolve, 600));
      try{
        const response = await axios.get(`${url}${cep}`, { headers })
        const data = response.data;
        info.push(data)
      }
          catch(error)  {
            const date = new Date().toLocaleString();
            const errorMessage = `\n${date} || Erro na request para o CEP: ${cep}. Erro: ${error}`;
            fs.appendFileSync('error.txt', errorMessage);
          };
      }
      console.log(info);
  })();
fetch('/dados')
  .then(response => response.json())
  .then(data => {
    console.log(data); // Exibe os dados recebidos do backend no console
  })
  .catch(error => {
    console.error('Erro:', error);
  });

function validar() {
  // pegando o valor do nome pelos names
  var codigo = document.getElementById('codigo')
  var nomeCliente = document.getElementById('nomeCliente')
  var nomeColaborador = document.getElementById('nomeColaborador')
  var produto = document.getElementById('produto')

  // verificar se o codigo está vazio
  if (codigo.value == '') {
    alert('Código não informado')

    // Deixa o input com o focus
    codigo.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  // verificar se o nome está vazio
  if (nomeCliente.value == '') {
    alert('Nome do cliente não informado')

    // Deixa o input com o focus
    nomeCliente.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  if (nomeColaborador.value == '') {
    alert('Nome do colaborador não informado')

    // Deixa o input com o focus
    nomeColaborador.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  if (produto.value == '') {
    alert('Produto não informado')

    // Deixa o input com o focus
    produto.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  alert('Formulário enviado!')

  // envia o formulário
  //formulario.submit();
}

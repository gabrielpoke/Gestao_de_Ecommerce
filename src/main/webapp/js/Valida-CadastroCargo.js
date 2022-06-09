function validar() {
  // pegando o valor do nome pelos names
  var codigo = document.getElementById('codigo')
  var nome = document.getElementById('nome')

  // verificar se o codigo está vazio
  if (codigo.value == '') {
    alert('Código não informado')

    // Deixa o input com o focus
    codigo.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  // verificar se o nome está vazio
  if (nome.value == '') {
    alert('Nome não informado')

    // Deixa o input com o focus
    nome.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  alert('Formulário enviado!')

  // envia o formulário
  //formulario.submit();
}

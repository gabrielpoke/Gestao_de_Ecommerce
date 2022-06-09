function validar() {
  // pegando o valor do nome pelos names

  var codigo = document.getElementById('codigo')
  var nome = document.getElementById('nome')
  var categoria = document.getElementById('categoria')
  var ean = document.getElementById('ean')
  var preco = document.getElementById('preco')
  var descricao = document.getElementById('descricao')

  if (codigo.value == '') {
    alert('Código não informado')
    codigo.focus()

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

  if (categoria.value == '') {
    alert('Categoria não informado')
    categoria.focus()

    return false
  }

  if (ean.value == '') {
    alert('Ean não informado')
    ean.focus()

    return false
  }

  if (preco.value == '') {
    alert('Preço não informado')
    preco.focus()

    return false
  }

  if (descricao.value == '') {
    alert('Descrição não informado')
    descricao.focus()

    return false
  }

  alert('Formulário enviado!')

  // envia o formulário
  //formulario.submit();
}

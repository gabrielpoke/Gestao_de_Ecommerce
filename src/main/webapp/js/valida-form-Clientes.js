function validar() {
  // pegando o valor do nome pelos names

  var codigo = document.getElementById('codigo')
  var nome = document.getElementById('nome')
  var sobrenome = document.getElementById('sobrenome')
  var email = document.getElementById('email')
  var cidade = document.getElementById('cidade')
  var bairro = document.getElementById('bairro')
  var telefone = document.getElementById('telefone')
  var cep = document.getElementById('cep')

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

  if (sobrenome.value == '') {
    alert('Sobrenome não informado')
    sobrenome.focus()

    return false
  }

  if (email.value == '') {
    alert('E-mail não informado')
    email.focus()

    return false
  }

  if (cidade.value == '') {
    alert('Cidade não informada')
    cidade.focus()

    return false
  }

  if (bairro.value == '') {
    alert('Bairro não informado')
    bairro.focus()

    return false
  }

  if (telefone.value == '') {
    alert('Telefone não informado')
    telefone.focus()

    return false
  }

  if (cep.value == '') {
    alert('CEP não informado')
    cep.focus()

    return false
  }

  alert('Formulário enviado!')

  // envia o formulário
  //formulario.submit();
}

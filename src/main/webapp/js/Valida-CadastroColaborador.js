function validar() {

  var nome = document.getElementById('nome')
  var cargo = document.getElementById('cargo')
  var email = document.getElementById('email')

  // verificar se o nome está vazio
  if (nome.value == '') {
    alert('Nome não informado')

    // Deixa o input com o focus
    nome.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  if (cargo.value == '') {
    alert('Cargo não informado')

    // Deixa o input com o focus
    cargo.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  if (email.value == '') {
    alert('Email não informado')

    // Deixa o input com o focus
    email.focus()

    // retorna a função e não olha as outras linhas
    return false
  }

  alert('Formulário enviado!')

  // envia o formulário
  //formulario.submit();
}

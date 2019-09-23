<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Nac Valet</title>
    <link rel="stylesheet" href="css/main.css">
  </head>
  <body>
    <section class="container">
      <div class="form-login">
        <h1 class="title">Avenger´s Park</h1>
          <form action="login" method="post">
          <label>E-mail:
            <input type="email" name="email" placeholder="Informe seu e-mail ou nome de usuário" required />
          </label>
          <label>Senha:
            <input type="password" name="senha" placeholder="Informe sua senha" required />
          </label>
          <button>Acessar</button>
        </form>
      </div>
    </section>
  </body>
</html>
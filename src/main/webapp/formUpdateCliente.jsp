<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Java - Atualizar Cliente | Home</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind">Lista de Clientes</a>
        </li>
      </ul>
      <form action="ClienteMakeAndSearch" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Atualizar Cliente</h3>
			<hr>
			<form action="ClienteUpdate" method="POST">
				<input value="${cliente.idCliente}" name="idCliente" style="visibility:hidden">
				<div class="form-floating mb-3">
						<input value="${cliente.nome}" name="nome" maxlength="300" type="text" class="form-control" id="floatingInput1"> 
						<label>Nome completo</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.email}" name="email" maxlength="150" type="text" class="form-control" id="floatingInput1"> 
						<label>E-mail</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.senha}" name="senha" maxlength="50" type="text" class="form-control" id="floatingInput1"> 
						<label>Senha</label>
				</div>
				<div class="form-floating mb-3">
					<input value="${cliente.cpf}" name="cpf" maxlength="11" type="text" class="form-control"> 
					<label>CPF (apenas números)</label>
				</div>
				<div class="form-floating mb-3">
					<input value="${cliente.dataDeNascimento}" name="dataDeNascimento" type="date" class="form-control" placeholder="dataDeNascimento">
					<label>Data de Nascimento</label>
				</div>

				<button class="btn btn-primary" type="submit">Atualizar
					Dados</button>
				<button class="btn btn-secondary" type="reset">Limpar
					Formulário</button>
			</form>
			<br>
			<h5><a href="ClienteMakeAndSearch">Lista de Clientes</a></h5>
		</div>
		
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="ISO-8859-1">
<title>Wallz Tour - Lista de Funcion�rios</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"         integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./assets/style/main.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
    <header class="container-fluid d-flex flex-row align-items-center cor-de-fundo justify-content-center">
        <div class="container row justify-content-between">
            <div>
                <a href="./index.html"> <img src="./assets/img/Wallztour-Icon.png" /> </a>
            </div>
            <div class="d-flex align-items-center">
                <nav>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="ClienteMakeAndSearch">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link aba-selecionada" href="FuncionarioMakeAndSearch">Funcion�rios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="DestinoMakeAndSearch">Destinos</a>
                        </li>
                       	<li class="nav-item">
                            <a class="nav-link active cor-link" href="TransicaoMakeAndSearch">Transi��es</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>        
    </header>
    <main>
    	<section>
    		<div class="container d-flex align-items-center justify-content-center py-3">
    		    <nav>
                    <ul class="nav px-5">
                        <li class="nav-item">
                            <a class="nav-link active cor-link2" href="./cadastroFuncionario.jsp">Novo Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link2" href="FuncionarioMakeAndSearch">Lista de Funcionarios</a>
                        </li>
                    </ul>
                </nav>
               		 <form action="FuncionarioMakeAndSearch" method="GET" class="d-flex">
						<input name="pesquisa" class="form-control me-2" type="search" placeholder="Busque pelo Nome" aria-label="Search">
						<button class="btn search-icon" type="submit"> <i class="bi bi-search"></i> </button>
					</form>
    		</div>
    	</section>
    	<section>
     	   <div class="container">
				<div class="row d-flex align-items-center justify-content-center">
					<div class="cold-md-7">
						<hr>
						<h3 class="titulo-aba d-flex justify-content-center">Funcion�rios Cadastrados</h3>
						<hr>
					</div>
					<table class="table tabela-padrao">
						<thead>
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>Email</th>
								<!-- A senha do usu�rio n�o pode aparecer <th>Senha</th> -->
								<th>Registro da Matr�cula</th>
								<th>Perfil</th>
								<th>A��es</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${funcionarios}" var="funcionario">
								<tr>
									<td>${funcionario.idFuncionario}</td>
									<td>${funcionario.nome}</td>
									<td>${funcionario.email}</td> 
									<!-- A senha do usu�rio n�o pode aparecer <td>${funcionario.senha}</td> -->
									<td>
										<c:choose>
											<c:when test="${funcionario.registroMatricula!=null}">
												RM ${funcionario.registroMatricula}
											</c:when>
											<c:otherwise>
												 ${funcionario.registroMatricula}
											</c:otherwise>
										</c:choose>
									</td>
									<td>${funcionario.perfil}</td>
									<td>
										<a href="FuncionarioUpdate?funcionarioId=${funcionario.idFuncionario}"> <button type="submit" class="btn btn-config"> <i class="bi bi-pencil-square"></i> Alterar</button></a>
										<a href="FuncionarioRemove?funcionarioId=${funcionario.idFuncionario}"> <button type="submit" class="btn btn-config-delete"> <i class="bi bi-trash3-fill"></i> Deletar</button></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
    	</section>
    </main>
    <footer class="cor-de-fundo-footer">
        <p class="container d-flex flex-row align-items-center">
            Copyright � 2022 Recode. Todos os direitos reservados.
        </p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="ISO-8859-1">
<title>Wallz Tour - Lista de Transições</title>
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
                            <a class="nav-link active cor-link" href="FuncionarioMakeAndSearch">Funcionários</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="DestinoMakeAndSearch">Destinos</a>
                        </li>
                       	<li class="nav-item">
                            <a class="nav-link active cor-link aba-selecionada" href="TransicaoMakeAndSearch">Transições</a>
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
                            <a class="nav-link active cor-link2" href="./cadastroTransicao.jsp">Novo Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link2" href="TransicaoMakeAndSearch">Lista de Transicões</a>
                        </li>
                    </ul>
                </nav>
               		 <form action="TransicaoMakeAndSearch" method="GET" class="d-flex">
						<input name="pesquisa" class="form-control me-2" type="search" placeholder="Busque o ID da transição" aria-label="Search">
						<button class="btn search-icon" type="submit"> <i class="bi bi-search"></i> </button>
					</form>
    		</div>
    	</section>
    	<section>
     	   <div class="container">
				<div class="row d-flex align-items-center justify-content-center">
					<div class="cold-md-7">
						<hr>
						<h3 class="titulo-aba d-flex justify-content-center">Transições Cadastradas</h3>
						<hr>
					</div>
					<table class="table tabela-padrao">
						<thead>
							<tr>
								<th>#</th>
								<!-- <th>Id Cliente</th>-->
								<!-- <th>Id Destino</th>-->
								<th>Quantidade de Diárias</th>
								<th>Data da viagem</th>
								<th>Optante Seguro</th>
								<th>Taxa de Seguro</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${transicoes}" var="transicao">
								<tr>
									<td>${transicao.idTransicao}</td>
									<!-- <td>${transicao.idCliente}</td>-->
									<!-- <td>${transicao.idDestino}</td>-->
									<td>${transicao.quantidadeDiarias}</td>
									<td>${transicao.dataViagem}</td>
									<td>
										<c:choose>
											<c:when test="${transicao.optanteSeguro==true}">
												<b>Sim</b>
											</c:when>
											<c:otherwise>
												Não
											</c:otherwise>
										</c:choose>
									</td>
									<td>${transicao.taxaSeguro*100}%</td>
									<td>
										<a href="TransicaoUpdate?transicaoId=${transicao.idTransicao}"> <button type="submit" class="btn btn-config"> <i class="bi bi-pencil-square"></i> Alterar</button></a>
										<a href="TransicaoRemove?transicaoId=${transicao.idTransicao}"> <button type="submit" class="btn btn-config-delete"> <i class="bi bi-trash3-fill"></i> Deletar</button></a>
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
            Copyright © 2022 Recode. Todos os direitos reservados.
        </p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>
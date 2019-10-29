<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <!------------------------------------------------------------------------------------------> 
        <meta charset="ISO-8859-1">
        <!------------------------------------------------------------------------------------------> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!------------------------------------------------------------------------------------------> 
        <script src="view/js/usuarioScript.js"></script>
        <!------------------------------------------------------------------------------------------> 
        <link rel="stylesheet" href="view/css/styleUsuario.css" type="text/css" />
        <!------------------------------------------------------------------------------------------> 
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <!------------------------------------------------------------------------------------------> 
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <!------------------------------------------------------------------------------------------> 
        <title>Cadastro de Usuarios</title>


    </head>
    <body>

        <!----- Cadastro de Usuários ----->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <div class="col-md-6 my-1">
                            <label class="sr-only" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">@</div>
                                </div>
                                <input type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>


        <!----- A partir daqui é o cabeçalho ---->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">Bar</a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Cadastrar</a>
                            <a class="dropdown-item" href="#">Visualizar</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <!----- A partir daqui é o formulário ---->
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>${pagina}</h3>
                    <form name="cadUsuario" action="${action}" method="POST">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="nomeUsuario">Nome:</label> 
                                    <input type="text" accept="
                                           "class="form-control" id="nomeUsuario" name="nomeUsuario"
                                           placeholder="Digite seu nome..." value="${nomeUsuario}">
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <label for="emailUsuario">Email</label> 
                                    <input type="email"
                                           class="form-control" id="emailUsuario" name="emailUsuario"
                                           aria-describedby="emailHelp" placeholder="Digite seu e-mail..."
                                           value="${emailUsuario}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="senhaUsuario">Senha</label> 
                                    <input type="password"
                                           class="form-control" id="senhaUsuario" name="senhaUsuario"
                                           placeholder="Digite sua senha...">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="sexoUsuario">Sexo</label> <select
                                        class="form-control" id="sexoUsuario" name="sexoUsuario">
                                        <option value="${sexoUsuario}" selected>${sexoUsuario}</option>
                                        <option value="m">M</option>
                                        <option value="f">F</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="nivelAcessoUsuario">Cargo</label> <select
                                        class="form-control" id="nivelAcessoUsuario"
                                        name="nivelAcessoUsuario">
                                        <option value="1">Gerente</option>
                                        <option value="2">Diretor</option>

                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="Filial">Filial </label> <select class="form-control"
                                                                                id="filial" name="filial">

                                        <c:forEach var="filiais" items="${listaFiliais}">
                                            <option value="${filiais['id']}">${filiais['nome']}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success" data-toggle="modal"
                                        data-target="#produtoModalSucesso">Cadastrar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <br>
        <footer class="section footer-classic context-dark bg-image"
                style="background: #2d3246;">
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    </body>
</html>
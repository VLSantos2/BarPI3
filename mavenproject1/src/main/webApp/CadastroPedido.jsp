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
            <a class="navbar-brand" href="#">BarTades</a>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Usuários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Filiais</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>

        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>${pagina}</h3>
                    <form name="cadUsuario" action="${action}" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="nomeUsuario">Nome:</label> <input type="text"
                                                                                  class="form-control" id="nomeUsuario" name="nomeUsuario"
                                                                                  placeholder="Digite seu nome..." value="${nomeUsuario}">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="cpfUsuario">CPF</label> <input type="text"
                                                                               class="form-control" id="cpfUsuario" name="cpfUsuario"
                                                                               placeholder="Digite seu CPF..."
                                                                               onKeyPress="MascaraCPF(cadUsuario.cpfUsuario);" maxlength="14"
                                                                               value="${cpfUsuario}">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="emailUsuario">Email</label> <input type="email"
                                                                                   class="form-control" id="emailUsuario" name="emailUsuario"
                                                                                   aria-describedby="emailHelp" placeholder="Digite seu e-mail..."
                                                                                   value="${emailUsuario}">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="senhaUsuario">Senha</label> <input type="password"
                                                                                   class="form-control" id="senhaUsuario" name="senhaUsuario"
                                                                                   placeholder="Digite sua senha...">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="telefoneUsuario">Telefone</label> <input type="text"
                                                                                         class="form-control" id="telefoneUsuario"
                                                                                         name="telefoneUsuario" placeholder="Digite seu telefone..."
                                                                                         onKeyPress="MascaraTelefone(cadUsuario.telefoneUsuario);"
                                                                                         maxlength="14" value="${telefoneUsuario}">
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
                                        <option value="Gerente">Gerente</option>
                                        <option value="Diretor">Diretor</option>

                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="unidadeAtuacaoUsuario">Unidade de
                                        Atua&ccedil;&atilde;o </label> <select class="form-control"
                                                                           id="unidadeAtuacaoUsuario" name="unidadeAtuacaoUsuario">

                                        <c:forEach var="franquias" items="${listaFranquias}">
                                            <option value="${franquias['nome']}">${franquias['nome']}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success" data-toggle="modal"
                                        data-target="#produtoModalSucesso">Cadastrar</button>
                            </div>

                            <div class="modal fade" id="produtoModalSucesso" tabindex="-1"
                                 role="dialog" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Sucesso!</h5>
                                            <button type="button" class="close" data-dismiss="modal"
                                                    aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Usuário cadastrado com sucesso!</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" name="idUsuario" value="${idUsuario}"
                                                    class="btn btn-primary">Prosseguir</button>
                                        </div>
                                    </div>
                                </div>
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
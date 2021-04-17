<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Cadastro de Pessoas">
    <form name="cadPessoa" action="/pessoa" method="post" >
        <div class="form-group row">
            <label class="col-sm-3 text-right"> CNPJF: </label>
            <input class="col-sm-9" name="cpf" value="<c:out value="${pessoa.cpf}" />" />
        </div>

        <div class="form-group row">
            <label class="col-sm-3 text-right"> Nome: </label>
            <input class="col-sm-9" name="nome" value="<c:out value="${pessoa.nome}" />" />
        </div>

        <div class="form-group row">
            <label class="col-sm-3 text-right"> Data Nasc: </label>
            <input class="col-sm-9" name="datanasc" value="<c:out value="${pessoa.datanasc}" />" />
        </div>

        <div class="form-group row">
                    <label class="col-sm-3 text-right"> Sexo: </label>
                    <input type="radio" name="sexo" value="MACHO" CHECKED/> Masculino
                    <input type="radio" name="sexo" value="FEMEA"/> Feminino
        </div>

        <div class="form-group col-sm-12 text-right">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</tag:maintemplate>
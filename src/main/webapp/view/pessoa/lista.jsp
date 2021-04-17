<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Lista de pessoas">

    <table class="table">
        <thead>
            <tr>
              <th scope="col">CNPJF</th>
              <th scope="col">Nome</th>
              <th scope="col">Sexo</th>
              <th scope="col">Data Nasc.</th>
              <th scope="col">-</th>
              <th scope="col">-</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pessoa" items="${pessoas}">
                <tr>
                    <td><c:out value="${pessoa.cpf}" /></td>
                    <td><c:out value="${pessoa.nome}" /></td>
                    <td><c:out value="${pessoa.sexo}" /></td>
                    <td><c:out value="${pessoa.datanasc}" /></td>
                    <td><a href="<c:url value="/pessoa?cpf=${pessoa.cpf}"/>">Editar</a></td>
                    <td><a href="<c:url value="/excluirpessoa?cpf=${pessoa.cpf}"/>">Excluir</a></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>

</tag:maintemplate>
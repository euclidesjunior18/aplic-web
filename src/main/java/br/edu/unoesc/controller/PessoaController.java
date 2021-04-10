package br.edu.unoesc.controller;

import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.model.Produto;
import br.edu.unoesc.service.PessoaService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PessoaController extends HttpServlet {

    PessoaService pessoaService = new PessoaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa pessoa = new Pessoa();
        if(req.getParameter("cpf") != null){
            pessoa = pessoaService.buscarPessoaPeloCpf(Integer.valueOf(req.getParameter("cpf"))).orElse(new Pessoa());
        }

        req.setAttribute("pessoa", pessoa);
        RequestDispatcher view = req.getRequestDispatcher("/view/pessoa/cadastro.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(converteCodigoParaInteger(req.getParameter("cpf")));
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setSexo(converteStringParaChar(req.getParameter("sexo")));
        pessoa.setDatanasc(req.getParameter("datanasc"));
        pessoaService.inserirAlterarPessoa(pessoa);
        resp.sendRedirect("/listarpessoas");
    }

    private Integer converteCodigoParaInteger(String codigo){
        try {
            return Integer.parseInt(codigo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Character converteStringParaChar(String text){
        try {
            return text.charAt(0);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}

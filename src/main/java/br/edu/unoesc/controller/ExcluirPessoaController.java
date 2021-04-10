package br.edu.unoesc.controller;

import br.edu.unoesc.service.PessoaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirPessoaController extends HttpServlet {
    PessoaService pessoaService = new PessoaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pessoaService.removerPessoaPeloCpf(Integer.parseInt(req.getParameter("cpf")));
        resp.sendRedirect("/listarpessoas");
    }
}

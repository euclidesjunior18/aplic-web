package br.edu.unoesc.service;

import br.edu.unoesc.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaService {
    private static final List<Pessoa> PESSOAS = new ArrayList<>();

    public void inserirAlterarPessoa(Pessoa pessoa) {
        if(pessoa.getCpf() != null && buscarPessoaPeloCpf(pessoa.getCpf()).isPresent()){
            PESSOAS.replaceAll(p -> p.getCpf().equals(pessoa.getCpf()) ? pessoa : p);
        } else {
            PESSOAS.add(pessoa);
        }
    }
    public List<Pessoa> listarPessoas() {
        return PESSOAS;
    }

    public Optional<Pessoa> buscarPessoaPeloCpf(Integer cpf){
        return PESSOAS.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();
    }

    public void removerPessoaPeloCpf(Integer cpf) {
        PESSOAS.removeIf(p -> p.getCpf().equals(cpf));
    }
}

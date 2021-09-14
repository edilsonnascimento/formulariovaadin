package com.example.application.data;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    private static final PessoaService instance = new PessoaService();
    private static Integer indexId = 0;
    private List<Pessoa> lista;

    public PessoaService() {
        this.lista = new ArrayList<>();
    }

    public List<Pessoa> listAll(){
        return lista;
    }

    public static PessoaService getInstance(){
        return instance;
    }

    public void Add(Pessoa pessoa){
        indexId += 1;
        pessoa.setId(indexId);
        lista.add(pessoa);
    }

    public Pessoa getById(Integer id){
        if(id < 1 || id > lista.size()) return null;
        return lista.get(id - 1);
    }
}

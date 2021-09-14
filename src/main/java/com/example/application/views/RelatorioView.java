package com.example.application.views;

import com.example.application.data.Pessoa;
import com.example.application.data.PessoaService;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.html.H1;

@Route
public class RelatorioView extends VerticalLayout {

    RouterLink voltar = new RouterLink("Cadastrar", FormularioView.class);
    H1 titulo = new H1("Lista de Pessoas");

    public RelatorioView() {
        add(titulo, voltar);
        listarPessoas();
    }

   private void listarPessoas() {
        for(Pessoa pessoa : PessoaService.getInstance().listAll())
            add(new RouterLink(pessoa.getNome() + " - " + pessoa.getDescricao(), PessoaDetalhesView.class, pessoa.getId()));
            //add(new Span(pessoa.getNome() + " - " + pessoa.getDepartamento()));
    }
}

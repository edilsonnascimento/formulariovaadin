package com.example.application.views;

import com.example.application.data.Pessoa;
import com.example.application.data.PessoaService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route
public class PessoaDetalhesView extends VerticalLayout implements HasUrlParameter<Integer> {

    H1 titulo = new H1("Detalhes de Pessoa");
    RouterLink voltar = new RouterLink("Voltar", RelatorioView.class);

    public PessoaDetalhesView() {
        add(titulo);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer id) {
        //se parametro vazio redireciona para ProdutoView
        if(id == null){
            event.forwardTo(RelatorioView.class);
            return;
        }
        Pessoa pessoa = PessoaService.getInstance().getById(id);
        if(pessoa != null){
            add(new Span("Nome: " + pessoa.getNome()));
            add(new Span("Email: " + pessoa.getEmail()));
            add(new Span("Senha: " + pessoa.getSenha()));
            add(new Span("Data de Nascimento: " + String.valueOf(pessoa.getDataNascimento())));
            add(new Span("Descrição: " + pessoa.getDescricao()));
            add(new Span("Departamento: " + pessoa.getDepartamentos().toString()));
            add(new Span("Região: " + pessoa.getRegiao()));
            add(new Span("Renda mensal: " + String.valueOf(pessoa.getRendaMensal())));
        }

        add(voltar);

    }
}

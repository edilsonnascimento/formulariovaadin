package com.example.application.views;

import com.example.application.data.Pessoa;
import com.example.application.data.PessoaService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route("/")
public class FormularioView extends HorizontalLayout {

    private TextField nomeField = new TextField();
    private EmailField emailField = new EmailField();
    private PasswordField passwordField = new PasswordField();
    private DatePicker dataNascimento = new DatePicker();
    private TextArea descricaoField = new TextArea();
    private CheckboxGroup<String> checkDepartamentos = new CheckboxGroup<>();
    private ComboBox<String> comboRegioes = new ComboBox<>();
    private String regiao = "";
    private BigDecimalField rendaEmReais = new BigDecimalField("Renda em Reais");
    private BigDecimalField rendaEmDollar = new BigDecimalField("Renda em Dollar");
    private List<String> departamentosAux = new ArrayList<>();


    public FormularioView() {

        FormLayout form = new FormLayout();

        H1 titulo = new H1("Exemplo de Formulario!");
        form.add(titulo);
        form.setColspan(titulo, 2);

        nomeField.setLabel("Nome");
        nomeField.setPlaceholder("Nome completo");
        nomeField.setPlaceholder("Nome completo");
        nomeField.addValueChangeListener(event -> {
            nomeField.setValue(nomeField.getValue().toUpperCase());
        });
        nomeField.setValueChangeMode(ValueChangeMode.EAGER);
        form.add(nomeField);

        emailField.setLabel("Email");
        emailField.setRequiredIndicatorVisible(true);
        emailField.addBlurListener(event -> {
           if(emailField.getValue().isEmpty() || emailField.isInvalid()){
               emailField.setErrorMessage("O email é inválido!");
               emailField.focus();
           }
        });
        form.add(emailField);

        passwordField.setLabel("Senha");
        passwordField.setRequiredIndicatorVisible(true);
        form.add(passwordField);

        dataNascimento.setLabel("Data de Nascimento");
        LocalDate dataAtual = LocalDate.now();
        dataNascimento.setValue(dataAtual);
        form.add(dataNascimento);

        descricaoField.setLabel("Descrição");
        form.add(descricaoField);

        checkDepartamentos.setLabel("Departamentos");
        checkDepartamentos.setItems("Administrativo", "Financeiro", "RH", "TI");
        checkDepartamentos.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        form.add(checkDepartamentos);

        comboRegioes.setLabel("Regiões");
        comboRegioes.setItems(Arrays.asList("Sul", "Sudeste", "Centro oeste", "Nordeste", "Norte"));
        comboRegioes.setValue("Escolha uma região");
        comboRegioes.addValueChangeListener(event -> {
            if(event.getValue() != null) regiao = event.getValue();
        });
        form.add(comboRegioes);


        String indice = "5.21";
        rendaEmDollar.setLabel("Dólar Americano: $" + indice);
        rendaEmDollar.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        rendaEmDollar.setEnabled(false);
        rendaEmReais.addBlurListener(event -> {
            if (rendaEmReais.getValue() != null) {
                rendaEmDollar.setValue(rendaEmReais.getValue().multiply(new BigDecimal(indice))
                        .setScale(2, RoundingMode.HALF_EVEN));
            }

        });
        form.add(rendaEmReais, rendaEmDollar);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.addClickListener(event -> {
               adicionarCampos();
               getUI().ifPresent(action -> action.navigate(RelatorioView.class));
        });

        form.add(btnSalvar);

        add(form);
    }

    public void adicionarCampos(){
        PessoaService pessoaService = PessoaService.getInstance();
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(nomeField.getValue());
        pessoa.setEmail(emailField.getValue());
        pessoa.setSenha(passwordField.getValue());
        pessoa.setDataNascimento(dataNascimento.getValue());
        pessoa.setDescricao(descricaoField.getValue());
        pessoa.setRegiao(regiao);
        pessoa.setDepartamentos(checkDepartamentos.getValue());
        pessoa.setRendaMensal(rendaEmReais.getValue());
        pessoaService.Add(pessoa);

    }

}

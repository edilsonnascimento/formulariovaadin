package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.Arrays;

@Route
public class MainView extends VerticalLayout {

    public MainView() {

        FormLayout form = new FormLayout();

        H1 titulo = new H1("Exemplo de Formulario!");
        form.add(titulo);
        form.setColspan(titulo, 2);

        TextField nomeField = new TextField();
        nomeField.setLabel("Nome");
        nomeField.setPlaceholder("Nome completo");
        nomeField.setPlaceholder("Nome completo");
        nomeField.addValueChangeListener(event -> {
            nomeField.setValue(nomeField.getValue().toUpperCase());
        });
        nomeField.setValueChangeMode(ValueChangeMode.EAGER);
        form.add(nomeField);

        EmailField emailField = new EmailField();
        emailField.setLabel("Email");
        emailField.setRequiredIndicatorVisible(true);
        emailField.addBlurListener(event -> {
           if(emailField.getValue().isEmpty()){
               Notification.show("Campo não pode ser vazio!");
               emailField.focus();
           }
           if(!emailField.isInvalid()){
               emailField.setInvalid(true);
               emailField.setErrorMessage("O email inválido!");
               emailField.focus();
           }
            emailField.setInvalid(false);
            emailField.setErrorMessage("");
        });
        form.add(emailField);

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Senha");
        passwordField.setRequiredIndicatorVisible(true);
        form.add(passwordField);

        TextArea descricaoField = new TextArea();
        descricaoField.setLabel("Descrição");
        form.add(descricaoField);

        CheckboxGroup<String> grupoItens = new CheckboxGroup<>();
        grupoItens.setLabel("Departamentos");
        grupoItens.setItems("Administrativo", "Financeiro", "RH", "TI");
        grupoItens.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        form.add(grupoItens);

        ComboBox<String> comboItens = new ComboBox<>();
        comboItens.setLabel("Regiões");
        comboItens.setItems(Arrays.asList("Sul", "Sudeste", "Centro oeste", "Nordeste", "Norte"));
        form.add(comboItens);

        Div container = new Div();
        container.setMaxWidth("50%");
        container.add(new H1("Visualizador de dados"));

        H2 nomeExibido = new H2();
        nomeExibido.setVisible(false);
        container.add(nomeExibido);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.addClickListener(event -> {
           if(!nomeField.getValue().isEmpty()){
               container.add(new H2("Nome: " + nomeField.getValue()));
               nomeField.setValue(nomeField.getEmptyValue());
           }else {
               getUI().ifPresent(action -> action.navigate(FormularioView.class));
           }
        });

        add(form, btnSalvar, container);
    }
}

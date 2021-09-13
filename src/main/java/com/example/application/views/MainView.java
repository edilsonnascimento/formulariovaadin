package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
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
        form.add(nomeField);

        EmailField emailField = new EmailField();
        emailField.setLabel("Email");
        emailField.setRequiredIndicatorVisible(true);
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

        Button btnSalvar = new Button("Salvar");

        add(form, btnSalvar);
    }
}

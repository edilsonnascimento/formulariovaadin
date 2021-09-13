package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
        add(new H1("Exemplo de Formulario!"));

        TextField nomeField = new TextField();
        nomeField.setLabel("Nome");
        nomeField.setPlaceholder("Nome completo");
        add(nomeField);

        EmailField emailField = new EmailField();
        emailField.setLabel("Email");
        emailField.setRequiredIndicatorVisible(true);
        add(emailField);

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Senha");
        passwordField.setRequiredIndicatorVisible(true);
        add(passwordField);

        TextArea descricaoField = new TextArea();
        descricaoField.setLabel("Descrição");
        add(descricaoField);

        CheckboxGroup<String> grupoItens = new CheckboxGroup<>();
        grupoItens.setLabel("Departamentos");
        grupoItens.setItems("Administrativo", "Financeiro", "RH", "TI");
        grupoItens.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        add(grupoItens);

        ComboBox<String> comboItens = new ComboBox<>();
        comboItens.setLabel("Regiões");
        comboItens.setItems(Arrays.asList("Sul", "Sudeste", "Centro oeste", "Nordeste", "Norte"));
        add(comboItens);

        Button btnSalvar = new Button("Salvar");
        add(btnSalvar);
    }
}

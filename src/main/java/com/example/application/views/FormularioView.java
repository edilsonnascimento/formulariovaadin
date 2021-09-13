package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.Arrays;

@Route
public class FormularioView extends HorizontalLayout {

    public FormularioView() {

        FormLayout form = new FormLayout();

        H1 titulo = new H1("Exemplo de Formulario!");
        form.add(titulo);
        form.setColspan(titulo, 2);

        TextField nomeField = new TextField();
        nomeField.setPlaceholder("Nome completo");
        form.addFormItem(nomeField, "Nome");

        EmailField emailField = new EmailField();
        emailField.setRequiredIndicatorVisible(true);
        form.addFormItem(emailField, "Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setRequiredIndicatorVisible(true);
        form.addFormItem(passwordField, "Senha");

        TextArea descricaoField = new TextArea();
        form.addFormItem(descricaoField,"Descrição");

        CheckboxGroup<String> grupoItens = new CheckboxGroup<>();
        grupoItens.setItems("Administrativo", "Financeiro", "RH", "TI");
        grupoItens.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        form.addFormItem(grupoItens, "Departamentos");

        ComboBox<String> comboItens = new ComboBox<>();
        comboItens.setItems(Arrays.asList("Sul", "Sudeste", "Centro oeste", "Nordeste", "Norte"));
        form.addFormItem(comboItens, "Regiões");

        Button btnSalvar = new Button("Salvar");
        form.add(btnSalvar);



        add(form);
    }
}

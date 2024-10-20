package com.ndh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

import com.ndh.App;

public class RegisterController {

    @FXML
    private Label labelViewRegister;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerBtn;

    @FXML
    private Label lbLogin;

    @FXML
    public void initialize() {
        lbLogin.setOnMouseClicked(event -> {
            try {
                App.setRoot("Login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

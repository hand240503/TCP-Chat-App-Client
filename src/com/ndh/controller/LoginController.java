package com.ndh.controller;

import java.io.IOException;

import com.ndh.App;
import com.ndh.ClientHandler; // Nhập lớp ClientHandler

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@FXML
	private Button loginBtn;

	@FXML
	private Label lbRegister;

	private ClientHandler clientHandler;

	@FXML
	public void initialize() {

		lbRegister.setOnMouseClicked(this::handleRegisterClick);
		loginBtn.setOnMouseClicked(this::handleLoginClick);
	}

	private void handleRegisterClick(MouseEvent event) {
		clientHandler = App.getClientHandler();
		if (clientHandler != null) {
			clientHandler.closeClient();
		}
		try {
			App.setRoot("Register");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleLoginClick(MouseEvent event) {
		clientHandler = App.getClientHandler();
		String username = usernameField.getText();
		String password = passwordField.getText();

		if (clientHandler != null) {
            clientHandler.sendLoginRequest(username, password);
		}
	}
}

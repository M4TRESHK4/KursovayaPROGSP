package com.example.kursovayaprogsp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {

    @FXML
    private Button authorizeButton;

    @FXML
    private Button goToRegistrationButton;

    @FXML
    private void switchToReg() {
        try {
            // Загружаем новое окно
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registration-view.fxml"));
            Parent root = loader.load();

            // Создаем новое окно
            Stage regStage = new Stage();
            regStage.setResizable(false);
            regStage.setScene(new Scene(root));

            // Закрываем текущее окно
            Stage currentStage = (Stage) goToRegistrationButton.getScene().getWindow();
            currentStage.close();

            // Показываем новое окно
            regStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;


}


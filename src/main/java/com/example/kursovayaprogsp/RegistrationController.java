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

public class RegistrationController {

    @FXML
    private Button backToAuthorizationButton;

    @FXML
    private PasswordField rEmailField;

    @FXML
    private TextField rLoginField;

    @FXML
    private PasswordField rPasswordField;

    @FXML
    private PasswordField rPasswordFieldAgain;

    @FXML
    private Button registrationButton;

    @FXML
    private void switchToAuth() {
        try {
            // Загружаем новое окно
            FXMLLoader loader = new FXMLLoader(getClass().getResource("authorization-view.fxml"));
            Parent root = loader.load();

            // Создаем новое окно
            Stage authStage = new Stage();
            authStage.setResizable(false);
            authStage.setScene(new Scene(root));

            // Закрываем текущее окно
            Stage currentStage = (Stage) backToAuthorizationButton.getScene().getWindow();
            currentStage.close();

            // Показываем новое окно
            authStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.example.kursovayaprogsp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminMainController {
    @FXML
    private TableView<Student> studentsTable;
    @FXML
    private TableColumn<Student, Integer> indexColumn;
    @FXML
    private TableColumn<Student, String> fioColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> facultyColumn;
    @FXML
    private TableColumn<Student, String> groupColumn;
    @FXML
    private TableColumn<Student, String> performanceColumn;
    @FXML
    private TableColumn<Student, Double> scholarshipColumn;

    @FXML
    private TextField addActivityField;
    @FXML
    private TextField addDiscountField;

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField facultyField;
    @FXML
    private TextField groupField;

    @FXML
    private Button addStudentButton;
    @FXML
    private Button removeStudentButton;
    @FXML
    private Button addActivityButton;
    @FXML
    private Button addDiscountButton;

    private ObservableList<Student> students;

    @FXML
    public void initialize() {
        // Устанавливаем данные для столбцов таблицы
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        facultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));
        performanceColumn.setCellValueFactory(new PropertyValueFactory<>("performance"));
        scholarshipColumn.setCellValueFactory(new PropertyValueFactory<>("scholarship"));

        // Пример данных студентов
        students = FXCollections.observableArrayList(
                new Student(1, "Иванов Иван", "ivanov@example.com", "ФИТ", "123", "90%", 300.0),
                new Student(2, "Петров Петр", "petrov@example.com", "ФИТ", "123", "85%", 250.0)
        );

        studentsTable.setItems(students);

        // Настраиваем кнопки
        addStudentButton.setOnAction(event -> addStudent());
        removeStudentButton.setOnAction(event -> removeStudent());
        addActivityButton.setOnAction(event -> addActivity());
        addDiscountButton.setOnAction(event -> addDiscount());
    }

    // Добавление нового студента
    private void addStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String faculty = facultyField.getText();
        String group = groupField.getText();

        if (!name.isEmpty() && !email.isEmpty() && !faculty.isEmpty() && !group.isEmpty()) {
            int newIndex = students.size() + 1;
            students.add(new Student(newIndex, name, email, faculty, group, "100%", 200.0)); // Успеваемость и стипендия — дефолтные
            clearInputFields();
        } else {
            showAlert("Ошибка", "Все поля должны быть заполнены!");
        }
    }

    // Удаление выбранного студента
    private void removeStudent() {
        Student selectedStudent = studentsTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            students.remove(selectedStudent);
        } else {
            showAlert("Ошибка", "Выберите студента для удаления!");
        }
    }

    // Добавление активности (пока просто выводит сообщение)
    private void addActivity() {
        String activity = addActivityField.getText();
        if (!activity.isEmpty()) {
            showAlert("Активность добавлена", "Активность \"" + activity + "\" успешно добавлена!");
            addActivityField.clear();
        } else {
            showAlert("Ошибка", "Введите название активности!");
        }
    }

    // Добавление льготы (пока просто выводит сообщение)
    private void addDiscount() {
        String discount = addDiscountField.getText();
        if (!discount.isEmpty()) {
            showAlert("Льгота добавлена", "Льгота \"" + discount + "\" успешно добавлена!");
            addDiscountField.clear();
        } else {
            showAlert("Ошибка", "Введите название льготы!");
        }
    }

    // Очистка полей ввода
    private void clearInputFields() {
        nameField.clear();
        emailField.clear();
        facultyField.clear();
        groupField.clear();
    }

    // Показать сообщение об ошибке
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

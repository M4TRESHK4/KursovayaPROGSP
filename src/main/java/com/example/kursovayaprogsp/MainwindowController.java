package com.example.kursovayaprogsp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainwindowController {

    @FXML
    private ImageView profileImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label groupLabel;

    @FXML
    private Label facultyLabel;

    @FXML
    private RadioButton semester1RadioButton;

    @FXML
    private RadioButton semester2RadioButton;

    @FXML
    private RadioButton semester3RadioButton;

    @FXML
    private TableView<SubjectRating> ratingTable;

    @FXML
    private TableColumn<SubjectRating, String> subjectColumn;

    @FXML
    private TableColumn<SubjectRating, Integer> gradeColumn;

    @FXML
    private Label averageLabel;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> indexColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    private ObservableList<SubjectRating> semester1Ratings;
    private ObservableList<SubjectRating> semester2Ratings;
    private ObservableList<SubjectRating> semester3Ratings;
    private ObservableList<Student> students;

    @FXML
    public void initialize() {
        // Инициализация данных
//        initProfile();
        initStudents();
        initRatings();

        // Устанавливаем фабрики для столбцов таблицы
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Обработчики семестров
        semester1RadioButton.setOnAction(e -> updateRatings(semester1Ratings));
        semester2RadioButton.setOnAction(e -> updateRatings(semester2Ratings));
        semester3RadioButton.setOnAction(e -> updateRatings(semester3Ratings));

        // Отображаем данные для 1 семестра по умолчанию
        updateRatings(semester1Ratings);
    }

//    private void initProfile() {
//        // Загружаем изображение профиля
//        profileImage.setImage(new Image("@default-profile.png"));
//        nameLabel.setText("ФИО: Иванов Иван Иванович");
//        groupLabel.setText("Группа: 123456");
//        facultyLabel.setText("Факультет: ФИТ");
//    }

    private void initStudents() {
        // Пример студентов
        students = FXCollections.observableArrayList(
                new Student(1, "Иванов Иван Иванович"),
                new Student(2, "Петров Петр Петрович"),
                new Student(3, "Сидоров Сидор Сидорович")
        );
        studentsTable.setItems(students);
    }

    private void initRatings() {
        // Рейтинги для различных семестров
        semester1Ratings = FXCollections.observableArrayList(
                new SubjectRating("Математика", 9),
                new SubjectRating("Физика", 8)
        );

        semester2Ratings = FXCollections.observableArrayList(
                new SubjectRating("Программирование", 10),
                new SubjectRating("Алгоритмы", 7)
        );

        semester3Ratings = FXCollections.observableArrayList(
                new SubjectRating("Математика", 8),
                new SubjectRating("Операционные системы", 9)
        );
    }

    private void updateRatings(ObservableList<SubjectRating> ratings) {
        ratingTable.setItems(ratings);
        updateAverage(ratings);
    }

    private void updateAverage(ObservableList<SubjectRating> ratings) {
        double sum = 0;
        for (SubjectRating rating : ratings) {
            sum += rating.getGrade();
        }
        double average = sum / ratings.size();
        averageLabel.setText(String.format("Средний балл: %.2f", average));
    }
}

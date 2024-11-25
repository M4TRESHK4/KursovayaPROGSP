package com.example.kursovayaprogsp;

import javafx.beans.property.*;

public class Benefit {
    private StringProperty description;
    private DoubleProperty amount;

    public Benefit(String description, double amount) {
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleDoubleProperty(amount);
    }

    public StringProperty descriptionProperty() { return description; }
    public DoubleProperty amountProperty() { return amount; }
}

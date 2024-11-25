package com.example.kursovayaprogsp;

public class Student {
    private int index;
    private String name;
    private String email;
    private String faculty;
    private String group;
    private String performance;
    private double scholarship;

    public Student(int index, String name, String email, String faculty, String group, String performance, double scholarship) {
        this.index = index;
        this.name = name;
        this.email = email;
        this.faculty = faculty;
        this.group = group;
        this.performance = performance;
        this.scholarship = scholarship;
    }

    public Student(int index, String name) {
        this.name = name;
        this.index = index;
    }

    // Геттеры
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public String getPerformance() {
        return performance;
    }

    public double getScholarship() {
        return scholarship;
    }

    // Сеттеры
    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return String.format("Student{index=%d, name='%s', email='%s', faculty='%s', group='%s', performance='%s', scholarship=%.2f}",
                index, name, email, faculty, group, performance, scholarship);
    }
}

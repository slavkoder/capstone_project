package com.slavaware.attached.model;

public class QuizQuestion {

    private final int stringResourceId;
    private final Category category;

    public QuizQuestion(int stringResourceId, Category category) {
        this.stringResourceId = stringResourceId;
        this.category = category;
    }

    public int getStringResourceId() {
        return stringResourceId;
    }

    public Category getCategory() {
        return category;
    }
}

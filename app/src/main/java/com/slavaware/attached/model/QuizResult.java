package com.slavaware.attached.model;

public class QuizResult {

    final int resultResourceId;
    final Category category;
    final int score;

    public QuizResult(int resultResourceId, Category category, int score) {
        this.resultResourceId = resultResourceId;
        this.category = category;
        this.score = score;
    }


}

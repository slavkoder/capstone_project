package com.slavaware.attached.model;

public interface IQuiz {

    QuizQuestion nextQuestion();

    boolean hasNext();

    void answerCurrentQuestion(int answer);

    int size();

    int currentQuestionPosition();

    Category result();


}

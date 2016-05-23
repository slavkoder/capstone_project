package com.slavaware.attached.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz1 implements IQuiz {

    private List<QuizQuestion> questions;
    private Map<Category, Integer> results;
    private int currentPosition = -1;

    public Quiz1(List<QuizQuestion> questions) {
        this.questions = questions;

        results = new HashMap<>(Category.values().length);
    }

    @Override
    public QuizQuestion nextQuestion() {
        currentPosition++;
        return questions.get(currentPosition);
    }

    @Override
    public boolean hasNext() {
        return currentPosition + 1 < questions.size();
    }

    @Override
    public void answerCurrentQuestion(int answer) {
        if (answer > 0) {
            final QuizQuestion currentQuestion = questions.get(currentPosition);
            final Integer result = results.get(currentQuestion.getCategory());
            results.put(currentQuestion.getCategory(), result != null ? result + 1 : 1);
        }
    }

    @Override
    public int size() {
        if (questions == null) {
            throw new NullPointerException("Questions array should have been passed");
        }

        return questions.size();
    }

    @Override
    public int currentQuestionPosition() {
        return currentPosition;
    }

    @Override
    public Category result() {
        Category result = null;
        Integer maxCount = 0;
        for (Category category : results.keySet()) {
            if (results.get(category) > maxCount) {
                maxCount = results.get(category);
                result = category;
            }
        }

        return result;
    }
}

package com.slavaware.attached.service;

import com.slavaware.attached.R;
import com.slavaware.attached.model.Category;
import com.slavaware.attached.model.IQuiz;
import com.slavaware.attached.model.Quiz1;
import com.slavaware.attached.model.QuizQuestion;
import java.util.ArrayList;
import java.util.List;

public class QuizProvider implements IQuizProvider {

    public static final int QUIZ_1_ID = 1005001;
    public static final int QUIZ_2_ID = 1005002;

    @Override
    public IQuiz getQuiz(int quizId) {
        switch (quizId) {
            case QUIZ_1_ID:
                return getQuiz1();
            case QUIZ_2_ID:
                return getQuiz2();
            default:
                throw new IllegalArgumentException("No quiz with id: " + quizId);
        }
    }

    private IQuiz getQuiz1() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion(R.string.quiz_1_question_1, Category.a));
        quizQuestions.add(new QuizQuestion(R.string.quiz_1_question_2, Category.b));
        quizQuestions.add(new QuizQuestion(R.string.quiz_1_question_3, Category.a));
        quizQuestions.add(new QuizQuestion(R.string.quiz_1_question_4, Category.c));
        quizQuestions.add(new QuizQuestion(R.string.quiz_1_question_5, Category.a));
        final IQuiz quiz = new Quiz1(quizQuestions);
        return quiz;
    }

    private IQuiz getQuiz2() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        // TODO: fill in quiz questions
        final IQuiz quiz = new Quiz1(quizQuestions);
        return quiz;
    }
}

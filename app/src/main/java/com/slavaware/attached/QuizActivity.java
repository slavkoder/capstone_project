package com.slavaware.attached;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.slavaware.attached.model.IQuiz;
import com.slavaware.attached.model.QuizQuestion;
import com.slavaware.attached.service.IQuizProvider;
import com.slavaware.attached.service.QuizProvider;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_QUIZ_ID = "com.slavaware.attached.EXTRA_QUIZ_ID";

    @BindView(R.id.question_title)
    TextView questionTitleView;

    @BindView(R.id.question_text)
    TextView questionTextView;

    @BindView(R.id.btn_yes)
    Button yesButton;

    @BindView(R.id.btn_no)
    Button noButton;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private IQuiz quiz;
    private IQuizProvider quizProvider;
    private int quizId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ButterKnife.bind(this);

        quizProvider = new QuizProvider();

        quizId = getIntent().getIntExtra(EXTRA_QUIZ_ID, 0);
        quiz = quizProvider.getQuiz(quizId);

        initViews();
    }

    private void initViews() {
        // set up progress bar
        progressBar.setMax(quiz.size());
        progressBar.setProgress(quiz.currentQuestionPosition());

        // set up buttons behavior
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz.answerCurrentQuestion(1);
                showNextQuestionOrResult();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                quiz.answerCurrentQuestion(0);
                showNextQuestionOrResult();
            }
        });

        showNextQuestionOrResult();
    }

    private void showNextQuestionOrResult() {
        if (quiz.hasNext()) {
            QuizQuestion question = quiz.nextQuestion();
            final int currentQuestionPosition = quiz.currentQuestionPosition();
            questionTitleView.setText(getResources().getString(R.string.question_title_format, currentQuestionPosition + 1));
            questionTextView.setText(getResources().getString(question.getStringResourceId()));

            progressBar.setProgress(currentQuestionPosition);
        } else {
            AlertDialog resultsDialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.result_title)
                    .setMessage(getQuizResult())
                    .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    }).show();
        }
    }

    private String getQuizResult() {
        switch (quiz.result()) {
            case a:
                return getString(R.string.quiz_1_result_a);
            case b:
                return getString(R.string.quiz_1_result_b);
            case c:
                return getString(R.string.quiz_1_result_c);
            default:
                return getString(R.string.quiz_result_unknown);
        }
    }
}

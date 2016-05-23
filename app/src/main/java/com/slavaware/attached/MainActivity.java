package com.slavaware.attached;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.slavaware.attached.service.QuizProvider;

import static com.slavaware.attached.QuizActivity.EXTRA_QUIZ_ID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_navigation_quiz_1)
    public void navigateToFirstQuiz(View v) {
        startQuizActivity(QuizProvider.QUIZ_1_ID);
    }

    @OnClick(R.id.btn_navigation_quiz_2)
    public void navigateToSecondQuiz(View v) {
        startQuizActivity(QuizProvider.QUIZ_2_ID);
    }

    private void startQuizActivity(int id) {
        Intent showQuizIntent = new Intent(this, QuizActivity.class);
        showQuizIntent.putExtra(EXTRA_QUIZ_ID, id);
        startActivity(showQuizIntent);
    }
}

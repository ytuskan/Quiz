package com.app.tuskan.quiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.tuskan.quiz.R;
import com.app.tuskan.quiz.models.Question;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextImageButton;
    private TextView questionTextview;

    private Question[] questions = new Question[2];
    private int currentIndex = 0;

    private void init() {
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextImageButton = findViewById(R.id.next_imageButton);
        questionTextview = findViewById(R.id.question_textview);
    }

    private void triggerInit() {
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(trueButton);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(falseButton);
            }
        });

        nextImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeQuestion();
            }
        });
    }

    private void createQuestions() {
        Question question0 = new Question("asdasfasdasd", "false");
        questions[0] = question0;
        Question question1 = new Question("gjjkghjghjg", "true");
        questions[1] = question1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        triggerInit();
        createQuestions();
        questionTextview.setText(questions[0].getQuestion());
    }

    private void checkAnswer(Button button) {
        if (questions[currentIndex].getAnswer().equals(button.getText().toString())) {
            Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show();
        }
    }

    private void changeQuestion() {
        currentIndex = (currentIndex + 1) % questions.length;
        questionTextview.setText(questions[currentIndex].getQuestion());
    }


}
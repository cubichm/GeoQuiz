package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private ImageButton mpreButton;
    private Button mB1;
    private Button mB2;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;

    private static final String TAG="MainActivity";
    private static final String KEY_INDEX="Index";

    private question[] mQuesArray=new question[]{
            new question(R.string.Question_ocean,true),
            new question(R.string.Question_Mideast,true),
            new question(R.string.Question_africa,true),
            new question(R.string.Question_america,false),
            new question(R.string.Question_asia,false)
    };

    private int mCurrentIndex =0;

    public void updateQuestion(){
        int ques = mQuesArray[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(ques);

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart called.");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause called.");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume called.");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop called.");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy called.");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG,"onCreate called.");

        mQuestionTextView= (TextView)findViewById(R.id.ques);
        updateQuestion();
        mB1 = (Button) findViewById(R.id.true_button);
        mB2 = (Button) findViewById(R.id.false_button);

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex =(mCurrentIndex + 1)% mQuesArray.length; // (0 +5)%5 = 1
                updateQuestion();

            }

        });

        mpreButton = (ImageButton) findViewById(R.id.pre_button);
        mpreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex - 1) % mQuesArray.length;
                Log.d(TAG, "mCurrentIndex value " + mCurrentIndex);
                //(0-1)%5=-1
                if (mCurrentIndex < 0) {
                    Log.d(TAG, "mCurrentIndex value in check " + mCurrentIndex);
                    mCurrentIndex = 4;
                }
                updateQuestion();

            }

        });
        mB1 = (Button) findViewById(R.id.true_button);
        mB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(true);
            }
        });



        //mB2=(Button)findViewById(R.id.B1);
        mB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(false);
            }
        });

    }
        public void onSaveInstanceState(Bundle savedInstanceState){
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);

            if(savedInstanceState!=null)
            {
                mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
            }

            mQuestionTextView = (TextView)findViewById(R.id.ques);
            updateQuestion();

            mB1 = (Button) findViewById(R.id.true_button);
            mB1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns(true);
                }
            });



            //mB2=(Button)findViewById(R.id.B1);
            mB2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAns(false);
                }
            });
        }

    public void checkAns(boolean uP){
        boolean anwerIsTrue =mQuesArray[mCurrentIndex].isAnswerTrue();

        int messegResId=0;

        if(uP==anwerIsTrue){
            messegResId= R.string.correct_toast;
        }
        else{
            messegResId= R.string.incorrect_toast;
        }
        Toast.makeText(this,messegResId,Toast.LENGTH_SHORT).show();
    }
}

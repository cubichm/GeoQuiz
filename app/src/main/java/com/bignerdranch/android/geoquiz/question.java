package com.bignerdranch.android.geoquiz;

/**
 * Created by Hp on 9/17/2016.
 */
public class question

{

    private int mTextResId;
    private boolean mAnswerTrue;


    public question (int textResId,boolean answerTrue){
        mTextResId= textResId;
        mAnswerTrue=answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}




package com.example.aidpack;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextViewAnimator {
    TextView mHolder;
    Animation fadeInAnimationObject;
    Animation textDisplayAnimationObject;
    Animation delayBetweenAnimations;
    Animation fadeOutAnimationObject;
    private final int fadeEffectDuration;
    private final int delayDuration;
    private final int displayFor;
    public int position = 0;
    public String[] mCollectionHolder;

    public TextViewAnimator(TextView textV, String[] textList){
        this(textV, 700, 2000, 3000, textList);
    }

    public TextViewAnimator(TextView textView, int fadeEffectDuration, int delayDuration, int displayLength, String[] textList )
    {
        mHolder = textView;
        mCollectionHolder = textList;
        this.fadeEffectDuration = fadeEffectDuration;
        this.delayDuration = delayDuration;
        this.displayFor = displayLength;
        InitializeAnimation();
    }

    private void InitializeAnimation() {
        fadeInAnimationObject = new AlphaAnimation(0f, 1f);
        fadeInAnimationObject.setDuration(fadeEffectDuration);
        textDisplayAnimationObject = new AlphaAnimation(1f, 1f);
        textDisplayAnimationObject.setDuration(displayFor);
        delayBetweenAnimations = new AlphaAnimation(0f, 0f);
        delayBetweenAnimations.setDuration(delayDuration);
        fadeOutAnimationObject = new AlphaAnimation(1f, 0f);
        fadeOutAnimationObject.setDuration(fadeEffectDuration);

        fadeInAnimationObject.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                position++;
                if (position >= mCollectionHolder.length){
                    position = 0;
                }

                mHolder.setText(mCollectionHolder[position]);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHolder.startAnimation(textDisplayAnimationObject);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        textDisplayAnimationObject.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHolder.startAnimation(fadeOutAnimationObject);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeOutAnimationObject.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHolder.startAnimation(delayBetweenAnimations);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        delayBetweenAnimations.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mHolder.startAnimation(fadeInAnimationObject);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startAnimation(){
        mHolder.startAnimation(fadeOutAnimationObject);
    }

}


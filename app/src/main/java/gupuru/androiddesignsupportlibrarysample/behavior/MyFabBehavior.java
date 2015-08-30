package gupuru.androiddesignsupportlibrarysample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

public class MyFabBehavior extends FloatingActionButton.Behavior {

    private boolean mIsAnimating;

    public MyFabBehavior(Context context, AttributeSet attributeSet) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (dyConsumed > 0) {
            animateHide(child);
        } else if (dyConsumed < 0) {
            animateShow(child);
        }
    }

    private void animateHide(FloatingActionButton button) {
        ViewCompat.animate(button).scaleX(0.0F).scaleY(0.0F).alpha(0.0F)
                .setInterpolator(new FastOutSlowInInterpolator() )
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        mIsAnimating = true;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        mIsAnimating = false;
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        mIsAnimating = false;
                    }
                });
    }

    private void animateShow(FloatingActionButton button) {
        ViewCompat.animate(button).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setInterpolator(new FastOutSlowInInterpolator());
    }
}

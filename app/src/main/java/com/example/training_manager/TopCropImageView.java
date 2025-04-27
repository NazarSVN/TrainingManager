package com.example.training_manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.graphics.Matrix;

import androidx.appcompat.widget.AppCompatImageView;

public class TopCropImageView extends AppCompatImageView {
    public TopCropImageView(Context context) {
        super(context);
        init();
    }

    public TopCropImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TopCropImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateMatrix();
    }

    private void updateMatrix() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }

        float viewWidth = getWidth();
        float viewHeight = getHeight();
        int drawableWidth = drawable.getIntrinsicWidth();
        int drawableHeight = drawable.getIntrinsicHeight();

        Matrix matrix = new Matrix();

        float scale = viewWidth / (float) drawableWidth;

        matrix.setScale(scale, scale);

        matrix.postTranslate(0, 0);

        setImageMatrix(matrix);
    }

}

package com.example.training_manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressView extends View {
    private Paint backgroundPaint;
    private Paint progressPaint;
    private float progress = 0.5f; // від 0.0 до 1.0

    public CircularProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(Color.parseColor("#1F1F1F"));
        backgroundPaint.setStrokeWidth(66);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeCap(Paint.Cap.ROUND);

        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setColor(Color.parseColor("#D9FF4F"));
        progressPaint.setStrokeWidth(66);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float size = Math.min(getWidth(), getHeight()) - 66;
        float left = (getWidth() - size) / 2;
        float top = (getHeight() - size) / 2;
        RectF oval = new RectF(left, top, left + size, top + size);
        float sweepAngle = 280f;
        float startAngle = 130f;
        canvas.drawArc(oval, startAngle, sweepAngle, false, backgroundPaint);
        canvas.drawArc(oval, startAngle, progress * sweepAngle, false, progressPaint);

    }

    public void setProgress(float value) {
        progress = value;
        invalidate();
    }
}

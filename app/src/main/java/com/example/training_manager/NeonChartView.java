package com.example.training_manager;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NeonChartView extends View {
    private Paint tonnagePaint, tonnageDotPaint;
    private Paint intensityPaint, intensityDotPaint;
    private Path tonnagePath, intensityPath;
    private Paint tonnageGlowPaint;
    private Paint intensityGlowPaint;
    private List<PointF> tonnagePoints = new ArrayList<>();
    private List<PointF> intensityPoints = new ArrayList<>();

    public NeonChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        tonnageGlowPaint = new Paint();
        tonnageGlowPaint.setColor(Color.YELLOW);
        tonnageGlowPaint.setStrokeWidth(10f);
        tonnageGlowPaint.setStyle(Paint.Style.STROKE);
        tonnageGlowPaint.setAntiAlias(true);
        tonnageGlowPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL));

        tonnagePaint = new Paint();
        tonnagePaint.setColor(Color.YELLOW);
        tonnagePaint.setStrokeWidth(4f);
        tonnagePaint.setStyle(Paint.Style.STROKE);
        tonnagePaint.setAntiAlias(true);

        intensityGlowPaint = new Paint();
        intensityGlowPaint.setColor(Color.MAGENTA);
        intensityGlowPaint.setStrokeWidth(10f);
        intensityGlowPaint.setStyle(Paint.Style.STROKE);
        intensityGlowPaint.setAntiAlias(true);
        intensityGlowPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL));

        intensityPaint = new Paint();
        intensityPaint.setColor(Color.MAGENTA);
        intensityPaint.setStrokeWidth(4f);
        intensityPaint.setStyle(Paint.Style.STROKE);
        intensityPaint.setAntiAlias(true);

        tonnagePoints.add(new PointF(90, 280));
        tonnagePoints.add(new PointF(250, 310));
        tonnagePoints.add(new PointF(300, 280));
        tonnagePoints.add(new PointF(350, 250));
        intensityPoints.add(new PointF(90, 290));
        intensityPoints.add(new PointF(250, 220));
        intensityPoints.add(new PointF(300, 330));
        intensityPoints.add(new PointF(350, 310));

        tonnagePath = new Path();
        intensityPath = new Path();

        if (!tonnagePoints.isEmpty()) {
            tonnagePath.moveTo(tonnagePoints.get(0).x, tonnagePoints.get(0).y);
            for (int i = 1; i < tonnagePoints.size(); i++) {
                tonnagePath.lineTo(tonnagePoints.get(i).x, tonnagePoints.get(i).y);
            }
        }

        if (!intensityPoints.isEmpty()) {
            intensityPath.moveTo(intensityPoints.get(0).x, intensityPoints.get(0).y);
            for (int i = 1; i < intensityPoints.size(); i++) {
                intensityPath.lineTo(intensityPoints.get(i).x, intensityPoints.get(i).y);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Осі координат
        Paint axisPaint = new Paint();
        axisPaint.setColor(Color.DKGRAY);
        axisPaint.setStrokeWidth(2f);
        canvas.drawLine(80, 50, 80, getHeight() - 30, axisPaint); // Y
        canvas.drawLine(80, getHeight() - 30, getWidth() - 30, getHeight() - 30, axisPaint); // X

        // Спочатку glow
        canvas.drawPath(tonnagePath, tonnageGlowPaint);
        canvas.drawPath(intensityPath, intensityGlowPaint);

        // Потім чітка лінія
        canvas.drawPath(tonnagePath, tonnagePaint);
        canvas.drawPath(intensityPath, intensityPaint);

        // Точки
        for (PointF point : tonnagePoints) {
            canvas.drawCircle(point.x, point.y, 10, tonnageDotPaint);
        }
        for (PointF point : intensityPoints) {
            canvas.drawCircle(point.x, point.y, 10, intensityDotPaint);
        }
    }

}

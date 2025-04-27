package com.example.training_manager;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class GlowLineChartRenderer extends LineChartRenderer {
    private Paint glowPaint;

    public GlowLineChartRenderer(LineChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        glowPaint = new Paint();
        glowPaint.setStyle(Paint.Style.STROKE);
        glowPaint.setStrokeWidth(20f);
        glowPaint.setMaskFilter(new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL));
        glowPaint.setAntiAlias(true);
        glowPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void drawExtras(Canvas c) {
        super.drawExtras(c);

        for (int i = 0; i < mChart.getLineData().getDataSetCount(); i++) {
            LineDataSet dataSet = (LineDataSet) mChart.getLineData().getDataSetByIndex(i);
            if (dataSet.isVisible()) {
                drawGlowLine(c, dataSet);
            }
        }
    }

    private void drawGlowLine(Canvas c, LineDataSet dataSet) {
        int glowColor = dataSet.getColor();
        glowPaint.setColor(glowColor);

        Path linePath = new Path();

        for (int j = 0; j < dataSet.getEntryCount(); j++) {
            Entry e = dataSet.getEntryForIndex(j);
            float[] pts = new float[]{e.getX(), e.getY()};
            mChart.getTransformer(dataSet.getAxisDependency()).pointValuesToPixel(pts);

            if (j == 0) {
                linePath.moveTo(pts[0], pts[1]);
            } else {
                linePath.lineTo(pts[0], pts[1]);
            }
        }

        c.drawPath(linePath, glowPaint);
    }
}

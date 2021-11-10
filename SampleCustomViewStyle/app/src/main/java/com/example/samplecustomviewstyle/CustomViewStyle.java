package com.example.samplecustomviewstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewStyle extends View {
    Paint paint;

    public CustomViewStyle(Context context) {
        super(context);

        init(context);
    }

    public CustomViewStyle(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 첫 번째 사각형을 Fill 스타일로 설정 (채우기)
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(10, 10, 100, 100, paint);

        // 첫 번째 사각형을 Stroke 스타일로 설정 (테두리)
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0F);
        paint.setColor(Color.GREEN);
        canvas.drawRect(10, 10, 100, 100, paint);

        // 두 번째 사각형을 Fill 스타일로 설정 (채우기)
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(128, 0, 0, 255);
        canvas.drawRect(120, 10, 210, 100, paint);

        // 두 번째 사각형을 Stroke 스타일로 설정하고 PathEffect(점선) 적용 (테두리)
        DashPathEffect dashEffect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0F);
        paint.setPathEffect(dashEffect);
        paint.setColor(Color.GREEN);
        canvas.drawRect(120,10, 210,100, paint);

        paint = new Paint();

        // 첫 번째 원에 색상 적용
        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(50, 160, 40, paint);

        // 두 번째 원에 AntiAlias 설정
        paint.setAntiAlias(true);
        canvas.drawCircle(160, 160, 40, paint);

        // 첫 번째 텍스트를 Stroke 스타일로 설정 (선)
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(30);
        canvas.drawText("Text (Stroke)", 20, 260, paint);

        // 두 번째 텍스트를 Fill 스타일로 설정 (채우기0
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        canvas.drawText("Text", 20, 320, paint);
    }
}

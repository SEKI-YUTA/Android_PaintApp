package com.example.paintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;



public class MyCanvasSample extends View {
    private Path path;
    private Paint paint;
    public MyCanvasSample(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate(); //　更新し続けろって命令
                break;
            case  MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

//        return super.onTouchEvent(event);
        return true;
    }

    public void clearCanvas() {
        path.reset();
        invalidate();
    }
}

package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var path: Path = Path()
    private var paint: Paint = Paint()
    private var drawX: Float = 0F
    private var drawY: Float = 0F
    private var paintColor: Int = Color.RED
    private var paintWidth: Float = 20F

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = paintColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = paintWidth
        canvas?.drawPath(path,paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        drawX = event!!.x
        drawY = event!!.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(drawX, drawY)
            MotionEvent.ACTION_MOVE -> path.lineTo(drawX, drawY)
        }

        invalidate() // 再描画させるための指示

//        return super.onTouchEvent(event)
        return true
    }

    public fun clearCanvas() {
        path.reset()
        invalidate()
    }

    public fun changePaintColor(color: Int) {
        paintColor = color
    }

    public fun changePaintWidth(width: Float) {
        paintWidth = width
    }
}
package com.example.ca2_circle

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(CustomCanvas(this))
    }
    inner class CustomCanvas(context: Context) : View(context) {
        private var circleRadius = 150f
        private var circle1X = 0f
        private var circle2X = 0f
        private var circleY = 0f
        private var centerX = 0f
        private var isMovingToCenter = false
        private val paint1 = Paint().apply {
            color = Color.RED
        }
        private val paint2 = Paint().apply {
            color = Color.BLUE
        }
        init {
            setBackgroundColor(Color.YELLOW)
        }
        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            super.onSizeChanged(w, h, oldw, oldh)
            circle1X = w * 0.25f
            circle2X = w * 0.75f
            circleY = h / 2f
            centerX = w / 2f
        }
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            canvas.drawCircle(circle1X, circleY, circleRadius, paint1)
            canvas.drawCircle(circle2X, circleY, circleRadius, paint2)
        }
        override fun onTouchEvent(event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (!isMovingToCenter) {
                        isMovingToCenter = true
                        animateCircles()
                    } else {
                        isMovingToCenter = false
                        resetCircles()
                    }
                }
            }
            return true
        }
        private fun animateCircles() {
            val animator1 = ValueAnimator.ofFloat(circle1X, centerX - circleRadius)
            animator1.addUpdateListener { animation ->
                circle1X = animation.animatedValue as Float
                invalidate()
            }
            val animator2 = ValueAnimator.ofFloat(circle2X, centerX + circleRadius)
            animator2.addUpdateListener { animation ->
                circle2X = animation.animatedValue as Float
                invalidate()
            }
            animator1.duration = 1000
            animator2.duration = 1000
            animator1.interpolator = AccelerateDecelerateInterpolator()
            animator2.interpolator = AccelerateDecelerateInterpolator()
            animator1.start()
            animator2.start()
        }
        private fun resetCircles() {
            val animator1 = ValueAnimator.ofFloat(circle1X, width * 0.25f)
            animator1.addUpdateListener { animation ->
                circle1X = animation.animatedValue as Float
                invalidate()
            }
            val animator2 = ValueAnimator.ofFloat(circle2X, width * 0.75f)
            animator2.addUpdateListener { animation ->
                circle2X = animation.animatedValue as Float
                invalidate()
            }
            animator1.duration = 1000
            animator2.duration = 1000
            animator1.interpolator = AccelerateDecelerateInterpolator()
            animator2.interpolator = AccelerateDecelerateInterpolator()
            animator1.start()
            animator2.start()
        }
    }
}
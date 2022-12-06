package com.example.customviewd

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

    }
}



class CustomProgress(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    private val aPaint: Paint = Paint()
    private val bPaint: Paint = Paint()
    private val cPaint: Paint = Paint()
    var rndsOne = (0..100).random()
    var rndsTwo = (0..100).random()
    var rndsThree = (0..100).random()
    var numOne = rndsOne.toFloat()
    var numTwo = rndsTwo.toFloat()
    var numThree = rndsThree.toFloat()
    var numSum = numOne + numTwo + numThree


    fun Calculator(indexOne: Float, sumNum: Float):Float{
        return (indexOne/sumNum) * 360f

    }


    private  var startAngleAOval = 0f
    private var sweepAngleAOval = Calculator(numOne,numSum)
    private var startAngleBOval = sweepAngleAOval
    private var sweepAngleBOval = Calculator(numTwo,numSum)
    private var startAngleCOval = sweepAngleBOval + sweepAngleAOval
    private var sweepAngleCOval = Calculator(numThree,numSum)

    constructor(context: Context?) : this(context, null) {}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}
    override fun onDraw(canvas: Canvas) {
        aPaint.color = Color.YELLOW
        bPaint.color = Color.CYAN
        cPaint.color = Color.MAGENTA

        val x = ((width - height / 2) / 2).toFloat()
        val y = (height / 4).toFloat()
        val oval = RectF(x, y, width - x, height - y)
        canvas.drawArc(oval,startAngleAOval, sweepAngleAOval  , true, aPaint)
        canvas.drawArc(oval,startAngleBOval, sweepAngleBOval, true, bPaint)
        canvas.drawArc(oval, startAngleCOval, sweepAngleCOval, true, cPaint)

    }

}
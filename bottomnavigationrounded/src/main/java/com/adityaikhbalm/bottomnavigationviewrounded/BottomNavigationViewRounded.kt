package com.adityaikhbalm.bottomnavigationviewrounded

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.util.DisplayMetrics
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationViewRounded(
    context: Context,
    attrs: AttributeSet?
) : BottomNavigationView(context, attrs) {

    private var mPath: Path = Path()
    private var cornerDimensions: FloatArray = FloatArray(8)

    init {
        val bottomNavigationDrawable: ShapeDrawable =
            ShapeDrawable(RoundRectShape(cornerDimensions,null,null))
        var cornerRadius: Int = 0

        if (attrs != null) {
            val ta: TypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationViewRounded)
            val backgroundColor: Int =
                ta.getColor(R.styleable.BottomNavigationViewRounded_bottomNavigationColor, NO_ID)
            cornerRadius = ta.getDimensionPixelSize(
                R.styleable.BottomNavigationViewRounded_bottomNavigationCornerRadius,
                convertDpToPixel(10).toInt()
            )

            if (backgroundColor != NO_ID) bottomNavigationDrawable.paint.color = backgroundColor
            ta.recycle()
        }

        background = bottomNavigationDrawable
        val radius: Float = convertDpToPixel(cornerRadius)
        for (i in cornerDimensions.indices) cornerDimensions[i] = radius
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.clipPath(mPath)
        super.draw(canvas)
        canvas.restore()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val r: RectF = RectF(0f, 0f, w.toFloat(), h.toFloat())

        mPath = Path()
        mPath.addRoundRect(
            r,
            cornerDimensions,
            Path.Direction.CW
        )
        mPath.close()
    }

    private fun convertDpToPixel(cornerRadius: Int) =
        cornerRadius * (Resources.getSystem().displayMetrics.densityDpi.toFloat() /
                DisplayMetrics.DENSITY_DEFAULT)
}
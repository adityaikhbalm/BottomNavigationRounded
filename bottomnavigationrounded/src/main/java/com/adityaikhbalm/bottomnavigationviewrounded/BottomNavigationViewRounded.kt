package com.adityaikhbalm.bottomnavigationviewrounded

import android.content.Context
import android.content.res.Resources
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

    private var mPath = Path()
    private var cornerDimensions = FloatArray(8)

    init {
        val bottomNavigationDrawable =
            ShapeDrawable(RoundRectShape(cornerDimensions,null,null))

        if (attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationViewRounded)
            val backgroundColor = ta.getColor(R.styleable.BottomNavigationViewRounded_backgroundColor, NO_ID)
            if (backgroundColor != NO_ID) bottomNavigationDrawable.paint.color = backgroundColor
            ta.recycle()
        }

        background = bottomNavigationDrawable
        val radius = convertDpToPixel()
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

        val r = RectF(0f, 0f, w.toFloat(), h.toFloat())

        mPath = Path()
        mPath.addRoundRect(
            r,
            cornerDimensions,
            Path.Direction.CW
        )
        mPath.close()
    }

    private fun convertDpToPixel() =
        50 * (Resources.getSystem().displayMetrics.densityDpi.toFloat() /
                DisplayMetrics.DENSITY_DEFAULT)
}
package bupt.liao.fred.customviewpractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(357, 200, 723, 566, -110, 100, true, mPaint);
            canvas.drawArc(357, 200, 723, 566, 30, 120, false, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(357, 200, 723, 566, 180, 60, false, mPaint);
        } else {
            RectF arc = new RectF(357, 200, 723, 566);
            canvas.drawArc(arc, -110, 100, true, mPaint);
            canvas.drawArc(arc, 30, 120, false, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(arc, -180, 60, false, mPaint);
        }    }
}

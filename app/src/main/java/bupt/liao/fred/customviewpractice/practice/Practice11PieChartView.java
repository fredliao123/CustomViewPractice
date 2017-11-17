package bupt.liao.fred.customviewpractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bupt.liao.fred.customviewpractice.R;
import bupt.liao.fred.customviewpractice.model.Data;

public class Practice11PieChartView extends View {


    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private List<Data> mDatas = new ArrayList<>();
    private float max;
    private float total;
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private void init() {
        mDatas.add(new Data("Lollipop", 34.0f, R.color.shapeOne));
        mDatas.add(new Data("Marshmallow", 16.0f, R.color.shapeTwo));
        mDatas.add(new Data("Gingerbread", 3.0f, R.color.shapeThree));
        mDatas.add(new Data("Ice Cream Sandwich", 2.0f, R.color.shapeFour));
        mDatas.add(new Data("Jelly Bean", 16.0f, R.color.shapeFive));
        mDatas.add(new Data("Kitkat", 29.0f, R.color.shapeSix));

        max = Float.MIN_VALUE;
        total = 0;
        for (Data data : mDatas) {
            total += data.getChance();
            max = Math.max(max, data.getChance());
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(48);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("PieChart", canvas.getWidth() * 0.5f, canvas.getHeight() * 0.95f, mPaint);

        canvas.translate(canvas.getWidth() * 0.5f, canvas.getHeight() * 0.5f);
        float radius = canvas.getHeight() * 0.35f;

        RectF rect = new RectF(-radius, -radius, radius, radius);

        float lineStartX;
        float lineStartY;
        float lineEndX;
        float lineEndY;
        float sweepAngle;
        float halfAngle;

        float angle = 0;
        for (Data item : mDatas) {
            mPaint.setStyle(Paint.Style.FILL);
            sweepAngle = item.getChance() / total * 360;
            halfAngle = sweepAngle * 0.5f + angle;
            mPaint.setColor(getResources().getColor(item.getColor()));

            lineStartX = radius * (float) Math.cos(halfAngle / 180 * Math.PI);
            lineStartY = radius * (float) Math.sin(halfAngle / 180 * Math.PI);
            lineEndX = (radius + 50) * (float) Math.cos(halfAngle / 180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(halfAngle / 180 * Math.PI);


            if (max == item.getChance()) {
                canvas.save();
                canvas.translate(lineStartX * 0.1f, lineStartY * 0.1f);
            }
            canvas.drawArc(rect, angle, sweepAngle - 2, true, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.WHITE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, mPaint);
            if (halfAngle > 90 && halfAngle < 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, mPaint);
                mPaint.setTextSize(15);
                mPaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(item.getName(), lineEndX - 50, lineEndY, mPaint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, mPaint);
                mPaint.setTextSize(15);
                mPaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(item.getName(), lineEndX + 50, lineEndY, mPaint);
            }
            if (max == item.getChance()) {
                canvas.restore();
            }
            angle += sweepAngle;
        }
    }
}


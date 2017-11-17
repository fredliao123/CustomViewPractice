package bupt.liao.fred.customviewpractice.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bupt.liao.fred.customviewpractice.model.Data;

public class Practice10HistogramView extends View {


    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private List<Data> mDatas = new ArrayList<>();
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float max = 0;


    private void init() {
        mDatas.add(new Data("Froyo", 5.0f, Color.GREEN));
        mDatas.add(new Data("GB", 25.0f, Color.GREEN));
        mDatas.add(new Data("ICS", 25.0f, Color.GREEN));
        mDatas.add(new Data("JB", 90.0f, Color.GREEN));
        mDatas.add(new Data("KitKat", 180.0f, Color.GREEN));
        mDatas.add(new Data("L", 225.0f, Color.GREEN));
        mDatas.add(new Data("M", 160.0f, Color.GREEN));

        for (Data data : mDatas) {
            max = Math.max(max, data.getChance());
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(48);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Histogram", canvas.getWidth() / 2, canvas.getHeight() * 0.95f, mPaint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.80f);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.7f, mPaint);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, mPaint);

        float width = (canvas.getWidth() * 0.8f - 100) / mDatas.size() * 0.8f;
        float space = (canvas.getWidth() * 0.8f - 100) / mDatas.size() * 0.2f;

        float startX = 0.0f;
        for (Data item : mDatas) {
            mPaint.setColor(Color.WHITE);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(20);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(item.getName(), startX + space + width / 2, 25, mPaint);

            mPaint.setColor(item.getColor());
            canvas.drawRect(startX + space, -item.getChance() / max * canvas.getHeight() * 0.65f, startX + space + width, 0, mPaint);
            startX = space + width + startX;
        }
    }
}

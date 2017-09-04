package bwie.com.xiexingzhang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/4
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class CotsomView extends View {

    private float mDimension;
    private int mColor;
    private int mWidth;
    private int mHeight;

    private CotsomView(Context context) {
        super(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public CotsomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initView(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.CotsomView);
        mColor = typedArray.getColor(R.styleable.CotsomView_view_color, Color.GRAY);
        mDimension = typedArray.getDimension(R.styleable.CotsomView_view_width, 10);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);//防锯齿
        paint.setColor(mColor);
        paint.setStyle(Paint.Style.STROKE); //设置空心
        canvas.drawCircle(mWidth / 2, mHeight / 2, 200f, paint);
        if (mSetColor != null) {
            Paint paint1 = new Paint();
            paint1.setAntiAlias(true);//防锯齿
            paint1.setColor(mSetColor.onSetColor());
            paint1.setStyle(Paint.Style.STROKE); //设置空心
            canvas.drawCircle(mWidth / 2, mHeight / 2, 200f, paint1);
        }
    }

    private SetColor mSetColor;

    public interface SetColor {
        int onSetColor();
    }

    public void setColor(SetColor color) {
        mSetColor = color;
    }
}

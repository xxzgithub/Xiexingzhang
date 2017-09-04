package bwie.com.xiexingzhang;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mUpdate_color;
    private CotsomView mCotsomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mUpdate_color = (TextView) findViewById(R.id.update_color);
        mUpdate_color.setOnClickListener(this);
        mCotsomView = (CotsomView) findViewById(R.id.view);
    }

    @Override
    public void onClick(View view) {
        mCotsomView.setColor(new CotsomView.SetColor() {
            @Override
            public int onSetColor() {
                return Color.RED;
            }
        });
    }
}

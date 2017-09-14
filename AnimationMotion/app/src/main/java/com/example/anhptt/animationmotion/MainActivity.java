package com.example.anhptt.animationmotion;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_magic)
    Button btn;
    @BindView(R.id.tv_text)
    TextView text;
    @BindView(R.id.transitions_container)
    LinearLayout transitionContainer;

    private boolean isVisible;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(transitionContainer);
                isVisible = !isVisible;
                text.setVisibility(isVisible ? View.VISIBLE : View.GONE);
            }
        });
    }
}

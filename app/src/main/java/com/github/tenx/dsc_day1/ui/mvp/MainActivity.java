package com.github.tenx.dsc_day1.ui.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.tenx.dsc_day1.R;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

    private MainPresenter presenter;
    private TextView tvHeader;

    private Button btnClick;

    private ProgressBar pbProgress;

    public void initViews(){
        tvHeader = findViewById(R.id.tv_header);
        btnClick = findViewById(R.id.btn_click);
        pbProgress = findViewById(R.id.pb_progress);
    }


    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void changeHeader(String text) {
        tvHeader.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initViews();
        presenter = new MainPresenter(this);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.handleClick();
            }
        });
    }
}

package com.example.testsieve;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements AsyncResponse {


    @Bind(R.id.input_number)
    EditText inputNumber;

//    @Bind(R.id.output_simple_numbers)
//    TextView outputSimpleNumbers;

    @Bind(R.id.output_summ)
    TextView outputSumm;

    @Bind(R.id.progress_bar)
    ProgressBar progressBar;

    @Bind(R.id.output_simple_numbers)
    WebView webView;

    @Bind(R.id.calculate_btn)
    Button calculateButton;

    ProgressAsyncTask progressAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @Override
    public void processFinish(String output) {
        enableView();
        webView.loadDataWithBaseURL("", output, "text/html", "UTF-8", "");
    }

    @OnClick(R.id.calculate_btn)
    public void calculate() {
        disableView();
        progressAsyncTask = new ProgressAsyncTask();
        progressAsyncTask.delegate = this;
        progressAsyncTask.execute(inputNumber.getText().toString());
    }

    public void disableView(){
        progressBar.setVisibility(View.VISIBLE);
        calculateButton.setEnabled(false);
        inputNumber.setEnabled(false);
    }

    public void enableView(){
        progressBar.setVisibility(View.INVISIBLE);
        calculateButton.setEnabled(true);
        inputNumber.setEnabled(true);
    }
}

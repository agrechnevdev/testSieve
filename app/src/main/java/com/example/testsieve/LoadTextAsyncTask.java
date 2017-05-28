package com.example.testsieve;

import android.os.AsyncTask;
import android.widget.TextView;

public class LoadTextAsyncTask extends AsyncTask<Void, Void, Void> {

    TextView textView;

    public LoadTextAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected Void doInBackground(Void... params) {

        return null;
    }
}

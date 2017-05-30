package com.example.testsieve;


import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ProgressAsyncTask extends AsyncTask<String, Void, Answer> {

    public AsyncResponse delegate = null;

    public ProgressAsyncTask() {
        this.delegate = null;
    }

    @Override
    protected void onPostExecute(Answer answer) {
        delegate.processFinish(answer);
    }


    @Override
    protected Answer doInBackground(String... params) {

        Integer n = Integer.parseInt(params[0]);
        boolean[] mas = new boolean[n + 1];
        Arrays.fill(mas, true);
        mas[0] = false;
        mas[1] = false;
        for (int i = 2; i*i < mas.length; i++) {
            if(mas[i])
                for(int j = i*i; j < mas.length; j = j + i){
                    mas[j] = false;
                }


        }
        Long summ = 0L;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]) {
                str.append(i).append(" ");
                summ += i;
            }
        }

        Answer answer = new Answer(str.toString() , Long.toString(summ));
        return answer;
    }
}

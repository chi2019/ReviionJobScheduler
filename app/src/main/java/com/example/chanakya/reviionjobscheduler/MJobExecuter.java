package com.example.chanakya.reviionjobscheduler;

import android.os.AsyncTask;

/**
 * Created by chanakya on 5/8/2018.
 */

public class MJobExecuter extends AsyncTask<Void,Void,String> {


    @Override
    protected String doInBackground(Void... voids) {
        return "background task finishes";
    }


}

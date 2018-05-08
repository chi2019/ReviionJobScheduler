package com.example.chanakya.reviionjobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by chanakya on 5/8/2018.
 */

public class MyJobScheduler extends JobService {

    MJobExecuter mJobExecuter;

    @Override
    public boolean onStartJob(final JobParameters params) {
       mJobExecuter = new MJobExecuter(){

           @Override
           protected void onPostExecute(String s) {
               Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG);
               jobFinished(params,false);
           }
       };

       mJobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {

        mJobExecuter.cancel(true);
        return false;
    }
}

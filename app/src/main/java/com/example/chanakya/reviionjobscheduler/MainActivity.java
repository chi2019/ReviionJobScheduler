package com.example.chanakya.reviionjobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int  jobId = 101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;


    Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);

        ComponentName componentName = new ComponentName(this,MyJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(jobId,componentName);

        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);


        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobScheduler.schedule(jobInfo);
                Toast.makeText(getApplicationContext(),"Job has shecduled",Toast.LENGTH_SHORT).show();

            }
        });


        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                jobScheduler.cancel(jobId);
                Toast.makeText(getApplicationContext(),"Job has cancelled",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

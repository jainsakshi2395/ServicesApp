package com.example.asyncdownload;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Button startDownload;

    private String TAGNAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickStartDownload(View v){
        Log.e(TAGNAME, "onClickStartDownload");
        ArrayList<String> allFiles = getFiles();

        Intent serviceIntent =  new Intent(this, MyBackgroundService.class);
        Bundle b = new Bundle();
        b.putStringArrayList("allFiles", allFiles);
        serviceIntent.putExtras(b);
        startService(serviceIntent);
    }
    private ArrayList<String> getFiles(){

        e1 = (EditText) findViewById(R.id.file1);
        String s1 = e1.getText().toString();
        if(s1==null){
            s1 = "https://static.googleusercontent.com/media/research.google.com/en//pubs/archive/45530.pdf";
        }
        e2 = (EditText) findViewById(R.id.file2);
        String s2 = e2.getText().toString();
        if(s2== null){
          s2 = "https://hadoop.apache.org/docs/r1.2.1/hdfs_design.pdf";
        }
        e3 = (EditText) findViewById(R.id.file3);
        String s3 = e3.getText().toString();
        if(s3==null){
            s3 = "https://pages.databricks.com/rs/094-YMS-629/images/LearningSpark2.0.pdf";
        }
        e4 = (EditText) findViewById(R.id.file4);
        String s4 = e4.getText().toString();
        if(s4==null){
            s4 = "https://docs.aws.amazon.com/wellarchitected/latest/machine-learning-lens/wellarchitected-machine-learning-lens.pdf";
        }
        e5 = (EditText) findViewById(R.id.file5);
        String s5 = e5.getText().toString();

        if(s5 == null){
            s5= "https://developers.snowflake.com/wp-content/uploads/2020/09/SNO-eBook-7-Reference-Architectures-for-Application-Builders-MachineLearning-DataScience.pdf";
        }

        ArrayList<String> allFiles = new ArrayList<String>();
        allFiles.add(s1);
        allFiles.add(s2);
        allFiles.add(s3);
        allFiles.add(s4);
        allFiles.add(s5);


        Log.e(TAGNAME, "get Files" + allFiles);

        return allFiles;
    }


}
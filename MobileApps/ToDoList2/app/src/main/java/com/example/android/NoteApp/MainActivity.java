package com.example.android.NoteApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME ="exampleAndroid.txt";

   EditText mEditText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      mEditText = findViewById(R.id.edit_text);
    }


public void save(View v)  {
     String txt = mEditText.getText().toString();
    FileOutputStream fo = null ;
    try {
        fo = openFileOutput(FILE_NAME,MODE_PRIVATE);

        fo.write(txt.getBytes());

        mEditText.getText().clear();
        Toast.makeText(this,"saved to"+getFilesDir()+"/"+FILE_NAME,Toast.LENGTH_LONG).show();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        if (fo !=null){

            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
public void load(View v){

FileInputStream fos = null;
    try {
        fos = openFileInput(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fos) ;
        BufferedReader bfr = new BufferedReader(isr);
       StringBuilder sb = new StringBuilder();
       String txt1;
          while ((txt1=bfr.readLine())!=null) {

          sb.append(txt1).append("\n");

          }

    mEditText.setText(sb.toString());

    } catch (FileNotFoundException e) {
        e.printStackTrace();



    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        if (fos!=null){}
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

}

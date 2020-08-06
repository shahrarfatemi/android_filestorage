package com.example.filestorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.textId);
        button = (Button) findViewById(R.id.buttonId);

        button.setOnClickListener(this);

        Toast.makeText(MainActivity.this,"naaaaa",Toast.LENGTH_SHORT).show();
        readData();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonId){
            String data = editText.getText().toString();
            if(data != null){
                storeData(data);
                Toast.makeText(MainActivity.this,"hoise",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"hoy nai",Toast.LENGTH_SHORT).show();
            }
            editText.setText("");
        }
    }

    public void storeData(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("data.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            FileInputStream fileInputStream = openFileInput("data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            String data = "";
            while ((line = bufferedReader.readLine())!= null){
                data += (line +"\n");
            }
            Toast.makeText(MainActivity.this,"kiiii",Toast.LENGTH_SHORT).show();
            editText.setText(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

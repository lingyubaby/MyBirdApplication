package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextBird,editTextZip,editTextName;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTextBird =findViewById(R.id.editTextBird);
        editTextName = findViewById(R.id.editTextName);
        editTextZip =findViewById(R.id.editTextZip);

        buttonSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bird");

        if (buttonSubmit == v ){
            String createBird = editTextBird.getText().toString();
            String createZip = editTextZip.getText().toString();
            String createName = editTextName.getText().toString();

            Bird createBirds = new Bird(createBird,createZip,createName);

            myRef.push().setValue(createBirds);


        }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemRegister){
            Toast.makeText(this, "You are already in Report page, you fool!", Toast.LENGTH_SHORT).show();


        } else if(item.getItemId() == R.id.itemSearch) {
            Intent searchIntent = new Intent(this,SearchActivity.class);
            startActivity(searchIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}


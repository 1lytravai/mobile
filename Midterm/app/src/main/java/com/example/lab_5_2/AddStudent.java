package com.example.lab_5_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {
    TextView stuId, stuName, stuDob, stuEmail, stuPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        stuId = findViewById(R.id.edtId);
        stuName = findViewById(R.id.edtNameStudent);
        stuDob = findViewById(R.id.edtDob);
        stuEmail = findViewById(R.id.edtEmail);
        stuPhone = findViewById(R.id.edtPhone);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void backBeforeActive() {
//        String Id = stuId.getText().toString().trim();
//        String Name = stuName.getText().toString().trim();
//        String Dob = stuDob.getText().toString().trim();
//        String Email = stuEmail.getText().toString().trim();
//        String Phone = stuPhone.getText().toString().trim();

//        Student student = new Student(Id, Name, Dob, Email, Phone);

        Intent resultIntent = new Intent();
//        resultIntent.putExtra("returnEvent", (CharSequence) student);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.iSave) {
            backBeforeActive();
        }
        return super.onOptionsItemSelected(item);
    }

}

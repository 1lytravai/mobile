package com.example.lab_5_2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewStudents;
    private static List<Student> studentList;
    private static StudentAdapter studentAdapter;
    private SearchView searchView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);

        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        studentList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();


        // Tạo sinh viên
        Student student1 = new Student("123456", "John Doe", "22-01-2003", "alice@example.com", "0290328" );
        Student student2 = new Student ("123456","John Doe", "22-01-2003", "alice@example.com", "0290328" );


        // Thêm các sinh viên vào danh sách
        studentList.add(student1);
        studentList.add(student2);

        studentAdapter = new StudentAdapter(studentList);
        recyclerViewStudents.setAdapter(studentAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    private void addActivty() {
        Intent intent = new Intent(MainActivity.this, AddStudent.class);
        startActivity(intent);
    }
    @SuppressLint("NotifyDataSetChanged")
    private static void checkAll() {
        Student student;
        Student temp;
        for (int i = 0; i < studentList.size(); i++) {
            student = studentList.get(i);
            if (student.isChecked() == false) {
                temp = new Student( student.getID(), student.getName(),student.getDoB(), student.getEmail(), student.getPhoneNumber() , true);
                studentList.set(i, temp);
                studentAdapter.notifyDataSetChanged();
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private static void unCheckAll() {
        Student student;
        Student temp;
        for (int i = 0; i < studentList.size(); i++) {
            student = studentList.get(i);
            if (student.isChecked()) {
                temp = new Student( student.getName(), student.getID(), student.getDoB(), student.getEmail(), student.getPhoneNumber() , false);
                studentList.set(i, temp);
                studentAdapter.notifyDataSetChanged();
            }
        }
    }


    private void showSearchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Search");

        // Tạo EditText
        final EditText editTextSearch = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        editTextSearch.setLayoutParams(layoutParams);
        builder.setView(editTextSearch);

        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String searchQuery = editTextSearch.getText().toString();
                searchStudents(searchQuery);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void searchStudents(String query) {
        //
    }
//    private void showSortOptions() {
//        PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.iSort));
//        popupMenu.inflate(R.menu.menu_item);
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                // Xử lý sự kiện khi một lựa chọn sắp xếp được chọn
//                switch (item.getItemId()) {
//                    case R.id.iSortNameAscending:
//                        // Sắp xếp theo tên tăng dần
//                        sortStudentsByNameAscending();
//                        return true;
//                    case R.id.iSortIDAscending:
//                        // Sắp xếp theo ID tăng dần
//                        sortStudentsByIDAscending();
//                        return true;
//                    case R.id.iSortIDDescending:
//                        // Sắp xếp theo ID giảm dần
//                        sortStudentsByIDDescending();
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });
//
//        popupMenu.show();
//    }

    private void sortStudentsByNameAscending() {
        // Sắp xếp sinh viên theo tên tăng dần

        // Cập nhật RecyclerView hoặc ListView hiển thị danh sách sinh viên
        // ...
    }

    private void sortStudentsByNameDescending() {
        // Sắp xếp sinh viên theo tên giảm dần
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getName().compareTo(s1.getName());
            }
        });

        // Cập nhật RecyclerView hoặc ListView hiển thị danh sách sinh viên
        // ...
    }

    private void sortStudentsByIDAscending() {
        // Sắp xếp sinh viên theo ID tăng dần
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getID().compareTo(s2.getID());
            }
        });

        // Cập nhật RecyclerView hoặc ListView hiển thị danh sách sinh viên
        // ...
    }

    private void sortStudentsByIDDescending() {
        // Sắp xếp sinh viên theo ID giảm dần
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getID().compareTo(s1.getID());
            }
        });

        // Cập nhật RecyclerView hoặc ListView hiển thị danh sách sinh viên
        // ...
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.iCheckAll){
            checkAll();
        }
        else if (itemId == R.id.iUncheckAll){
            unCheckAll();
        }
        else if (itemId == R.id.iAdd) {
            addActivty();
            return true;
        }
        else if(itemId == R.id.iSearch) {
                showSearchDialog();
                return true;
            //
        }else if(itemId == R.id.iSort) {
//                showSortOptions();
                return true;
        } else if (itemId == R.id.iDelete) {

        }

        return super.onOptionsItemSelected(item);
    }


}

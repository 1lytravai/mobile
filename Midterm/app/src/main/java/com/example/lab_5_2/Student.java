package com.example.lab_5_2;
import java.util.Date;
import java.util.List;

public class Student {
    private String ID;
    private String Name;
    private String DoB;
    private String Email;
    private String phoneNumber ;

    private boolean isChecked;



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", DoB=" + DoB +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Student(String ID, String name, String doB, String email, String phoneNumber) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.phoneNumber = phoneNumber;
        DoB = doB;
    }
    public Student(String ID, String name, String doB, String email, String phoneNumber, boolean isChecked) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.phoneNumber = phoneNumber;
        DoB = doB;
        this.isChecked = isChecked;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = String.valueOf(doB);
    }
    public void setStudentList(List<Student> studentList) {
    }
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}

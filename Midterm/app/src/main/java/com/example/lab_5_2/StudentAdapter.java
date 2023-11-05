package com.example.lab_5_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    public void updateData(List<Student> updatedList) {
        studentList.clear();
        studentList.addAll(updatedList);
        notifyDataSetChanged();
    }

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textViewID.setText(student.getID());
        holder.textViewName.setText(student.getName());
        holder.textViewEmail.setText(student.getEmail());
        holder.textViewPhoneNumber.setText(student.getPhoneNumber());
        holder.textViewDoB.setText(student.getDoB().toString());
        holder.chbSelect.setChecked(student.isChecked());
        holder.chbSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.setChecked(((CheckBox) holder.chbSelect).isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewID, textViewEmail, textViewPhoneNumber, textViewDoB;

        CheckBox chbSelect;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.tvId);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewEmail = itemView.findViewById(R.id.tvEmail);
            textViewPhoneNumber = itemView.findViewById(R.id.tvPhone);
            textViewDoB = itemView.findViewById(R.id.tvDob);
            chbSelect = itemView.findViewById(R.id.chbSelect);
        }
    }
}

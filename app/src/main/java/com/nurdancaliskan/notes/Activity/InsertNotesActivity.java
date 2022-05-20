package com.nurdancaliskan.notes.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nurdancaliskan.notes.R;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;
import com.nurdancaliskan.notes.databinding.ActivityInsertNotesBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    ActivityInsertNotesBinding binding;
    String title, subtitle, notes;
    int notesPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.pinkColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(R.drawable.ic_done);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(0);
            notesPriority =1;

        });

        binding.greenColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(R.drawable.ic_done);
            binding.yellowColors.setImageResource(0);
            notesPriority =2;

        });

        binding.yellowColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(R.drawable.ic_done);
            notesPriority =3;

        });

        binding.doneNotesBtn.setOnClickListener(v -> {

            title = binding.notesTitle.getText().toString();
            subtitle = binding.notesSubtitle.getText().toString();
            notes = binding.notesData.getText().toString();

            CreateNotes(title, subtitle, notes, notesPriority);
        });
    }

    private void CreateNotes(String title, String subtitle, String notes,int notesPriority) {

        Date currentTime = Calendar.getInstance().getTime();
        String sequence = DateFormat.getDateInstance().format(currentTime);

        Intent data = new Intent();
        data.putExtra("title",title);
        data.putExtra("subtitle",subtitle);
        data.putExtra("notes",notes);
        data.putExtra("sequence",sequence);
        data.putExtra("color",notesPriority);
        setResult(RESULT_OK, data);
        finish();
    }

}
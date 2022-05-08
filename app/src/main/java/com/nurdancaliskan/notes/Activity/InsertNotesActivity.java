package com.nurdancaliskan.notes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.appcompat.app.AppCompatActivity;

import com.nurdancaliskan.notes.R;
import com.nurdancaliskan.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    ActivityInsertNotesBinding binding;
    String title, subtitle, notes;
    String notesPriority ="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.pinkColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(R.drawable.ic_done);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(0);
            colors ="1";

        });

        binding.greenColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(R.drawable.ic_done);
            binding.yellowColors.setImageResource(0);
            colors ="2";

        });

        binding.yellowColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(R.drawable.ic_done);
            colors ="3";

        });

        binding.doneNotesBtn.setOnClickListener(v -> {

            title = binding.notesTitle.getText().toString();
            subtitle = binding.notesSubtitle.getText().toString();
            notes = binding.notesData.getText().toString();

            CreateNotes(title, subtitle, notes);
        });
    }

    private void CreateNotes(String title, String subtitle, String notes) {

        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMM d,YYYY",date.getTime());

        Intent data = new Intent();
        data.putExtra("title",title);
        data.putExtra("subtitle",subtitle);
        data.putExtra("notes",notes);
        data.putExtra("sequence",sequence.toString());
        setResult(RESULT_OK, data);
        finish();
    }

}
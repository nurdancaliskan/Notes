package com.nurdancaliskan.notes.Activity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.R;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;
import com.nurdancaliskan.notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    ActivityInsertNotesBinding binding;
    String title, subtitle, notes;
    NotesViewModel notesViewModel;
    String colors ="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

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

        Date date =new Date();
        CharSequence sequence = DateFormat.format("MMM d,YYYY",date.getTime());

        Notes notes1 = new Notes();
        notes1.notesTitle = title;
        notes1.notesSubtitle = subtitle;
        notes1.notes = notes;
        notes1.notesDate = sequence.toString();
        notesViewModel.insertNote(notes1);

        finish();
    }

}
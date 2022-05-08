package com.nurdancaliskan.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nurdancaliskan.notes.Activity.InsertNotesActivity;
import com.nurdancaliskan.notes.Adapter.NotesAdapter;
import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    private static final int ADD_NOTES_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.newNotesBtn);
        recyclerView = findViewById(R.id.notesRecycler);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertNotesActivity.class);
            startActivityForResult(intent, ADD_NOTES_REQUEST);
        });

        notesViewModel.deleteAll(); // açılışta siliyor

        notesViewModel.getAllNotes().observe(this, notes -> {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            notesAdapter = new NotesAdapter(MainActivity.this, notes);
            recyclerView.setAdapter(notesAdapter);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NOTES_REQUEST && resultCode == RESULT_OK) {
            String noteTitle = data.getStringExtra("title");
            String noteSubtitle = data.getStringExtra("subtitle");
            String noteNotes = data.getStringExtra("notes");
            String noteSequence = data.getStringExtra("sequence");

            Notes notes1 = new Notes();
            notes1.notesTitle = noteTitle;
            notes1.notesSubtitle = noteSubtitle;
            notes1.notes = noteNotes;
            notes1.notesDate = noteSequence;
            notesViewModel.insertNote(notes1);
        }
    }
}
package com.nurdancaliskan.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nurdancaliskan.notes.Activity.InsertNotesActivity;
import com.nurdancaliskan.notes.Adapter.NotesAdapter;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn =findViewById(R.id.newNotesBtn);
        recyclerView=findViewById(R.id.notesRecyler);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));

        });

        notesViewModel.getallNotes.observe(this,notes -> {
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            notesAdapter = new NotesAdapter(this,notes);
            recyclerView.setAdapter();


        });
    }
}
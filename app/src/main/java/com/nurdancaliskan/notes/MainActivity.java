package com.nurdancaliskan.notes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nurdancaliskan.notes.Activity.InsertNotesActivity;
import com.nurdancaliskan.notes.Adapter.NotesAdapter;
import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;
import com.nurdancaliskan.notes.databinding.ActivityMainBinding;
import com.nurdancaliskan.notes.databinding.ActivityUpdateNotesBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    TextView emptyTextView;
    ImageView imageView;

    private static final int ADD_NOTES_REQUEST = 1;
    static final int UPDATE_NOTES_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        binding.nurdan.setFrame(120);
        /*
          transparentStatusAndNavigation();
        hideSystemBars();
          decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

                    }
        });
         */

        imageView = findViewById(R.id.nurdan);
        newNotesBtn = findViewById(R.id.newNotesBtn);
        recyclerView = findViewById(R.id.notesRecycler);
        emptyTextView = findViewById(R.id.empty_text);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertNotesActivity.class);
            startActivityForResult(intent, ADD_NOTES_REQUEST);
        });

        notesViewModel.getAllNotes().observe(this, notes -> {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            notesAdapter = new NotesAdapter(MainActivity.this, notes);
            recyclerView.setAdapter(notesAdapter);
            if(notes.isEmpty()){
                emptyTextView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);

            }else{
                emptyTextView.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);

            }
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
            int notePriority = data.getIntExtra("color",1);

            Notes notes1 = new Notes();
            notes1.notesTitle = noteTitle;
            notes1.notesSubtitle = noteSubtitle;
            notes1.notes = noteNotes;
            notes1.notesDate = noteSequence;
            notes1.notesPriority = notePriority;
            notesViewModel.insertNote(notes1);
        }else if(requestCode == UPDATE_NOTES_REQUEST && resultCode == RESULT_OK){
            int noteId = data.getIntExtra("id",0);
            String noteTitle = data.getStringExtra("title");
            String noteSubtitle = data.getStringExtra("subtitle");
            String noteNotes = data.getStringExtra("notes");
            String noteSequence = data.getStringExtra("sequence");
            int notePriority = data.getIntExtra("color",1);

            Notes notes2 = new Notes();
            notes2.id = noteId;
            notes2.notesTitle = noteTitle;
            notes2.notesSubtitle = noteSubtitle;
            notes2.notes = noteNotes;
            notes2.notesDate = noteSequence;
            notes2.notesPriority = notePriority;
            notesViewModel.updateNotes(notes2);
        }else if (requestCode == UPDATE_NOTES_REQUEST && resultCode == RESULT_CANCELED){
            int noteId = data.getIntExtra("id",0);
            notesViewModel.deleteNotes(noteId);
        }
    }
}
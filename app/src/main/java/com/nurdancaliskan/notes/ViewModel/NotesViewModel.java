package com.nurdancaliskan.notes.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> getallNotes;


    public NotesViewModel(Application application) {
        super(application);

       repository = new NotesRepository(application);
       getallNotes = repository.getallNotes;

         }

   public void insertNote(Notes notes){
            repository.insertNotes(notes);

         }

   public void deleteNote(Notes id){
        repository.deleteNotes(id);

    }

   public void updateNote(Notes notes){
        repository.updateNotes(notes);

    }



    }




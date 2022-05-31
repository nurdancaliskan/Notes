package com.nurdancaliskan.notes.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private NotesRepository repository;
    private final LiveData<List<Notes>> AllNotes;


    public NotesViewModel(Application application) {
        super(application);
       repository = new NotesRepository(application);
       AllNotes = repository.allNotes();
         }

   public void insertNote(Notes notes){
            repository.insertNotes(notes);
         }

         public void deleteAll(){
        repository.deleteAll();
         }

    public LiveData<List<Notes>> getAllNotes(){
        return this.AllNotes;
    }

    public void updateNotes(Notes notes){repository.updateNotes(notes);}

    public void deleteNotes(int id){ repository.deleteNotes(id);}

}




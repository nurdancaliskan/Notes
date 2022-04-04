package com.nurdancaliskan.notes.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nurdancaliskan.notes.Dao.NotesDao;
import com.nurdancaliskan.notes.Database.NotesDatabase;
import com.nurdancaliskan.notes.Model.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getallNotes;

    public NotesRepository(Application application)
    {
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();
    }

   public void insertNotes (Notes notes) { NotesDao.insertNotes(notes); }

   public void deleteNotes (Notes id){ NotesDao.deleteNotes(id);}

   public void updateNotes (Notes notes) { NotesDao.updateNotes(notes);}




}

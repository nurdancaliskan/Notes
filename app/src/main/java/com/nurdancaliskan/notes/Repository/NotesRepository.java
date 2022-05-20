package com.nurdancaliskan.notes.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nurdancaliskan.notes.Dao.NotesDao;
import com.nurdancaliskan.notes.Database.NotesDatabase;
import com.nurdancaliskan.notes.Model.Notes;

import java.util.List;

public class NotesRepository {

    private NotesDao notesDao;
    private LiveData<List<Notes>> allNotes;

    public NotesRepository(Application application)
    {
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        allNotes = notesDao.getAllNotes();
    }

    public void insertNotes(Notes notes) {
        NotesDatabase.databaseWriteExecutor.execute(() -> notesDao.insertNotes(notes));
    }
    public void updateNotes(Notes notes){
        NotesDatabase.databaseWriteExecutor.execute(() -> notesDao.updateNotes(notes));
    }

    public LiveData<List<Notes>> allNotes () {
        return allNotes;
    }

    public void deleteAll() {
        NotesDatabase.databaseWriteExecutor.execute(() -> {
            notesDao.deleteAll();
        });
    }

    }

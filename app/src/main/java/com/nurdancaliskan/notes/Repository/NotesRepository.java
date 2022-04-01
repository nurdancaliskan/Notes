package com.nurdancaliskan.notes.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import androidx.room.Dao;

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

    void insertUser(Notes notes)
    {
        notesDao.insertNotes(notes);
    }

    void deleteNotes(int id)
    {
        notesDao.deleteNotes(id);
    }

    void updateNotes(Notes notes)
    {
        notesDao.updateNotes(notes);
    }




}

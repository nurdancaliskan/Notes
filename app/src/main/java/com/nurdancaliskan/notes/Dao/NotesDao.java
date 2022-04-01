package com.nurdancaliskan.notes.Dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nurdancaliskan.notes.Model.Notes;

import java.util.List;

@androidx.room.Dao

public interface NotesDao {

    @Query("SELECT * FROM Notes_Database")
    LiveData<List<Notes>> getallNotes();


    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes notes);



}

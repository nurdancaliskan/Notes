package com.nurdancaliskan.notes.Dao;


import androidx.lifecycle.LiveData;
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
    static void insertNotes(Notes... notes) {

    }

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    static void deleteNotes(Notes id) {

    }

    @Update
    static void updateNotes(Notes notes) {

    }

}

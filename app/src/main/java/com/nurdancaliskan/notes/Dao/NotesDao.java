package com.nurdancaliskan.notes.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nurdancaliskan.notes.Model.Notes;

import java.util.List;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM Notes_Database")
    LiveData<List<Notes>> getAllNotes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNotes(Notes notes);

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    default void deleteNotes(int id) {
    }

    @Query("DELETE FROM Notes_Database")
    void deleteAll();

    @Update
    void updateNotes(Notes... notes);
}

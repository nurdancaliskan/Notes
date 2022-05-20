package com.nurdancaliskan.notes.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nurdancaliskan.notes.Dao.NotesDao;
import com.nurdancaliskan.notes.Model.Notes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Notes.class},version =3)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();

    private static NotesDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static NotesDatabase getDatabaseInstance (Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NotesDatabase.class, "Notes_Database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return  INSTANCE;
    }
}


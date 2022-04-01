package com.nurdancaliskan.notes.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "Notes_Database")

public class Notes {

    @PrimaryKey (autoGenerate = true)
    public  int id;


    @ColumnInfo (name = "notes_title")
    String notesTitle;

    @ColumnInfo (name = "notesSubtitle")
    String notesSubtitle;

    @ColumnInfo (name = "notes_date")
    String notesDate;

    @ColumnInfo (name = "notePrimacy")
    String notesPrimacy;

    @ColumnInfo (name = "notes")
    String notes;


}

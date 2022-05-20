package com.nurdancaliskan.notes.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "Notes_Database")

public class Notes {

    @PrimaryKey (autoGenerate = true)
    public  int id;


    @ColumnInfo (name = "notes_title")
    public
    String notesTitle;

    @ColumnInfo (name = "notesSubtitle")
    public
    String notesSubtitle;

    @ColumnInfo (name = "notes_date")
    public
    String notesDate;

    @ColumnInfo (name = "notes")
    public
    String notes;

    @ColumnInfo (name = "notes_Priority")
    public
    int notesPriority;


}

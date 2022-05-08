package com.nurdancaliskan.notes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurdancaliskan.notes.MainActivity;
import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {

    MainActivity mainActivity;
    List<Notes> notes;

    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
    }

    @Override
    public notesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new notesViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes,parent,false));
    }


    @Override
    public void onBindViewHolder( NotesAdapter.notesViewHolder holder, int position) {

        Notes note = notes.get(position);

        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubtitle);
        holder.notesdate.setText(note.notesDate);

    }

    @Override
    public int getItemCount() {

        return notes.size();
    }

    static class notesViewHolder extends RecyclerView.ViewHolder {

        TextView title,subtitle,notesdate;

        public notesViewHolder(View itemView) {

            super(itemView);

             title=itemView.findViewById(R.id.notesTitle);
             subtitle=itemView.findViewById(R.id.notesSubtitle);
             notesdate=itemView.findViewById(R.id.notesDate);

        }
    }
}

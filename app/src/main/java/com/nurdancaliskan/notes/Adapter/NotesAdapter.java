package com.nurdancaliskan.notes.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurdancaliskan.notes.Activity.UpdateNotesActivity;
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
    public void onBindViewHolder(@NonNull NotesAdapter.notesViewHolder holder, int position) {

        Notes note = notes.get(position);

        switch (note.notesPriority) {
            case 1:
                holder.notesPriority.setBackgroundResource(R.drawable.red_shape);
                break;
            case 2:
                holder.notesPriority.setBackgroundResource(R.drawable.green_shape);
                break;
            case 3:
                holder.notesPriority.setBackgroundResource(R.drawable.yellow_shape);
                break;
        }

        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubtitle);
        holder.notesdate.setText(note.notesDate);


        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(mainActivity, UpdateNotesActivity.class);

            intent.putExtra("id",note.id);
            intent.putExtra("title",note.notesTitle);
            intent.putExtra("subtitle",note.notesSubtitle);
            intent.putExtra("priority",note.notesPriority);
            intent.putExtra("note",note.notes);

            mainActivity.startActivityForResult(intent,2);
        });

    }

    @Override
    public int getItemCount() {

        return notes.size();
    }

    static class notesViewHolder extends RecyclerView.ViewHolder {

        TextView title,subtitle,notesdate;
        View notesPriority;

        public notesViewHolder(View itemView) {

            super(itemView);

             title=itemView.findViewById(R.id.notesTitle);
             subtitle=itemView.findViewById(R.id.notesSubtitle);
             notesdate=itemView.findViewById(R.id.notesDate);
             notesPriority=itemView.findViewById(R.id.notesPriority);

        }
    }
}

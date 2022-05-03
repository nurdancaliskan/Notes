package com.nurdancaliskan.notes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nurdancaliskan.notes.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {

    @Override
    public notesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new notesViewHolder(LayoutInflater.from().inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder( NotesAdapter.notesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class notesViewHolder extends RecyclerView.ViewHolder {
        public notesViewHolder(View itemView) {
            super(itemView);
        }
    }
}

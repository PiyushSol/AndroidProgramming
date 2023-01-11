package com.example.notes;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
 public static class NotesViewHolder extends RecyclerView.ViewHolder{
     LinearLayout containerview;
     TextView textView;

     NotesViewHolder(View view){
         super(view);
         containerview = view.findViewById(R.id.note_row);
         textView = view.findViewById(R.id.note_row_text);

         containerview.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Note current =(Note) containerview.getTag();
                 Intent intent = new Intent(v.getContext(),NoteActivity.class);
                 intent.putExtra("id",current.id);
                 intent.putExtra("contents",current.contents);
                 v.getContext().startActivity(intent);
             }
         });
     }
 }

    private List<Note> notes =new ArrayList<>();

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note current = notes.get(position);
        holder.textView.setText(current.contents);
        holder.containerview.setTag(current);

    }

    @Override
    public int getItemCount() {
      return notes.size();
    }

    public void reload(){
        notes =MainActivity.database.noteDao().getAllNotes();
        notifyDataSetChanged();
    }
}


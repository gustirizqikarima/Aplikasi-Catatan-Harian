package com.example.aplikasicatatanharian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    // Konstruktor untuk NoteAdapter
    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Mendapatkan item pada posisi saat ini
        Note note = getItem(position);

        // Memeriksa apakah convertView null, jika ya, inflate layout baru
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_cell, parent, false);
        }

        // Menemukan dan mengatur TextView dalam convertView
        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView desc = convertView.findViewById(R.id.cellDesc);

        // Mengatur teks untuk TextView dari objek Note
        if (note != null) {
            title.setText(note.getTitle());
            desc.setText(note.getDescription());
        }

        return convertView;
    }
}

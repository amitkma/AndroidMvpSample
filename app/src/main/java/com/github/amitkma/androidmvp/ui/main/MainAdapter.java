package com.github.amitkma.androidmvp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.amitkma.androidmvp.R;
import com.github.amitkma.androidmvp.data.model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 2/6/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.NoteViewHolder> {

    private Context mContext;
    private List<Note> mNoteList = new ArrayList<>();

    public MainAdapter(Context context){
        mContext = context;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_note, parent, false);
        final NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        noteViewHolder.mNoteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Note note = mNoteList.get(noteViewHolder.getAdapterPosition());
                ((MainActivity) mContext).remove(note);
                return true;
            }
        });
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.mNoteIdTextView.setText(String.format("Note. %d", note.getId()));
        holder.mNoteTextView.setText(note.getNote());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public void updateData(List<Note> noteList){
        this.mNoteList = noteList;
        notifyDataSetChanged();
    }
    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView mNoteIdTextView;
        private TextView mNoteTextView;
        private View mNoteView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            mNoteView = itemView;
            mNoteTextView = (TextView) itemView.findViewById(R.id.noteTextView);
            mNoteIdTextView = (TextView) itemView.findViewById(R.id.noteIdTextView);
        }
    }
}

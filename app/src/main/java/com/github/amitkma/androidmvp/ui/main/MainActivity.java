package com.github.amitkma.androidmvp.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.amitkma.androidmvp.MvpApplication;
import com.github.amitkma.androidmvp.R;
import com.github.amitkma.androidmvp.data.model.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    private MainContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;
    private RecyclerView mNoteRecyclerView;
    private MainAdapter mMainAdapter;

    private EditText mNoteEditText;
    private Button mNoteAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MainPresenterImpl(this, MvpApplication.get(this).getDataManager());
        mNoteEditText = (EditText) findViewById(R.id.noteEditText);
        mNoteAddButton = (Button) findViewById(R.id.addNoteButton);
        mNoteAddButton.setOnClickListener(this);
        mNoteRecyclerView = (RecyclerView) findViewById(R.id.noteRecyclerView);
        mNoteRecyclerView.setHasFixedSize(true);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMainAdapter = new MainAdapter(this);
        mNoteRecyclerView.setAdapter(mMainAdapter);

        mPresenter.getAllNotes();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading");
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void updateView(List<Note> items) {
        mMainAdapter.updateData(items);
    }

    public void remove(Note note) {
        mPresenter.removeNote(note);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addNoteButton:
                mPresenter.addNote(mNoteEditText.getText().toString().trim());
                mNoteEditText.setText("");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionClearAll:
                mPresenter.clearAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.nurdancaliskan.notes.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nurdancaliskan.notes.Model.Notes;
import com.nurdancaliskan.notes.R;
import com.nurdancaliskan.notes.ViewModel.NotesViewModel;
import com.nurdancaliskan.notes.databinding.ActivityUpdateNotesBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateNotesActivity extends AppCompatActivity {

    ActivityUpdateNotesBinding binding;
    int notesPriority,sid,spriority;
    String stitle, ssubtitle, snotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sid = getIntent().getIntExtra("id",0);
        stitle = getIntent().getStringExtra("title");
        ssubtitle = getIntent().getStringExtra("subtitle");
        snotes = getIntent().getStringExtra("note");
        spriority = getIntent().getIntExtra("priority",1);

        binding.deleteNotesBtn.setOnClickListener(V -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(UpdateNotesActivity.this);
            View view = LayoutInflater.from(UpdateNotesActivity.this).
                    inflate(R.layout.delete_botom_sheet,(LinearLayout)findViewById(R.id.bottomsheet));
            bottomSheetDialog.setContentView(view);

            TextView yes,no;
            yes =view.findViewById(R.id.delete_yes);
            no =view.findViewById(R.id.delete_no);

            yes.setOnClickListener(v -> {
                UpdateNotes(sid,stitle, ssubtitle, snotes, spriority,true);
                bottomSheetDialog.dismiss();
                finish();
            });

            no.setOnClickListener(v -> {
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.show();
        });



        binding.upTitle.setText(stitle);
        binding.upSubtitle.setText(ssubtitle);
        binding.upNotes.setText(snotes);



        binding.pinkColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(R.drawable.ic_done);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(0);
            notesPriority =1;

        });

        binding.greenColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(R.drawable.ic_done);
            binding.yellowColors.setImageResource(0);
            notesPriority =2;

        });

        binding.yellowColors.setOnClickListener(V -> {
            binding.pinkColors.setImageResource(0);
            binding.greenColors.setImageResource(0);
            binding.yellowColors.setImageResource(R.drawable.ic_done);
            notesPriority =3;

        });

        binding.updateNotesBtn.setOnClickListener(v -> {

            int id = sid;
            String title = binding.upTitle.getText().toString();
            String subtitle = binding.upSubtitle.getText().toString();
            String notes = binding.upNotes.getText().toString();

            UpdateNotes(id,title, subtitle, notes, notesPriority,false);
        });


    }

    private void UpdateNotes(int id,String title, String subtitle, String notes, int notesPriority,boolean delete) {

        Date currentTime = Calendar.getInstance().getTime();
        String sequence = DateFormat.getDateInstance().format(currentTime);


        Intent data = new Intent();
        data.putExtra("id",id);
        data.putExtra("title",title);
        data.putExtra("subtitle",subtitle);
        data.putExtra("notes",notes);
        data.putExtra("sequence",sequence);
        data.putExtra("color",notesPriority);
        if(delete){
            Toast.makeText(this, "Note Deleted", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED,data);
        }else{
            Toast.makeText(this, "Note Updated", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, data);
        }
        finish();
    }
}

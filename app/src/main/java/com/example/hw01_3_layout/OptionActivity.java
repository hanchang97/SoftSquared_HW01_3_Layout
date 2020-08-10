package com.example.hw01_3_layout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class OptionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        System.out.println("option onCreate");

        TextView backToOption = findViewById(R.id.back_to_option);  // ' <설정 '  누르면 더보기 화면으로 돌아간다
        backToOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("option onPause");

            SharedPreferences pref  = getSharedPreferences("pref", 0);
            SharedPreferences.Editor editor = pref.edit();
            CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkbox1);
            CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkbox2);
            CheckBox checkbox3 = (CheckBox)findViewById(R.id.checkbox3);
            CheckBox checkbox4 = (CheckBox)findViewById(R.id.checkbox4);
            CheckBox checkbox5 = (CheckBox)findViewById(R.id.checkbox5);

            editor.putBoolean("checkbox1",checkbox1.isChecked());
            editor.putBoolean("checkbox2",checkbox2.isChecked());
            editor.putBoolean("checkbox3",checkbox3.isChecked());
            editor.putBoolean("checkbox4",checkbox4.isChecked());
            editor.putBoolean("checkbox5",checkbox5.isChecked());

            editor.commit();

        }

        @Override
        public void onResume() {
            super.onResume();
            System.out.println("option onResume");

            SharedPreferences pref  = getSharedPreferences("pref", 0);
            CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkbox1);
            CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkbox2);
            CheckBox checkbox3 = (CheckBox)findViewById(R.id.checkbox3);
            CheckBox checkbox4 = (CheckBox)findViewById(R.id.checkbox4);
            CheckBox checkbox5 = (CheckBox)findViewById(R.id.checkbox5);

            Boolean chk1 = pref.getBoolean("checkbox1", false);
            Boolean chk2 = pref.getBoolean("checkbox2", false);
            Boolean chk3 = pref.getBoolean("checkbox3", false);
            Boolean chk4 = pref.getBoolean("checkbox4", false);
            Boolean chk5 = pref.getBoolean("checkbox5", false);

            checkbox1.setChecked(chk1);
            checkbox2.setChecked(chk2);
            checkbox3.setChecked(chk3);
            checkbox4.setChecked(chk4);
            checkbox5.setChecked(chk5);
        }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("option onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("option onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("option onDestroy");
    }

}

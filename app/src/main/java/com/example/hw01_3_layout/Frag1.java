package com.example.hw01_3_layout;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {


    private View view;


    @Nullable
    @Override    //Fragment는 onCreateView로!
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.fragment1, container, false);

            System.out.println("frag5_onCreateView");

        ImageView btn_open = view.findViewById(R.id.btn_option);
        btn_open.setOnClickListener(new View.OnClickListener() {   // 설정 버튼 누를 시 설정창 액티비티로 이동
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OptionActivity.class);
                startActivity(intent);
            }
        });

            return view;
    }


}

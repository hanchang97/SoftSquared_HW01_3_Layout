package com.example.hw01_3_layout;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Frag_home extends Fragment {


    private View view;



    @Nullable
    @Override    //Fragment는 onCreateView로!
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.fragment_home, container, false);  //fragment는

            System.out.println("frag1_onCreateView");


        Button btn = (Button)view.findViewById(R.id.btn);   //텍스트 일부 색 및 스타일 변경
        SpannableStringBuilder ssb1 = new SpannableStringBuilder(btn.getText());
        ssb1.setSpan(new ForegroundColorSpan(Color.parseColor("#02D136")),0,5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ssb1.setSpan(new StyleSpan(Typeface.BOLD), 14,15, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        btn.setText(ssb1);



            return view;

    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("frag1_onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("frag1_onStop");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("frag1_onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("frag1_onDestory");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("frag1_onDetach");
    }
}

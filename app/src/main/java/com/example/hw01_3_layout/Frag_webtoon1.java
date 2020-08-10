package com.example.hw01_3_layout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_webtoon1 extends Fragment {


    private View view;
    LinearLayout preview_layout1;   //해당 웹툰 회차별 썸네일은 웹홈페이지에서 화면확대 125% 상태에서 캡쳐했었음
    LinearLayout preview_layout2;
    LinearLayout preview_layout3;
    boolean preview = true;

    @Nullable
    @Override    //Fragment는 onCreateView로!
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.fragment_webtoon1, container, false);  // 프래그먼트에서는 onCreateView 에서 Layout을 inflater하여 View 작업을 한다

            System.out.println("frag_webtoon1_onCreateView");

        TextView watch_trailer = view.findViewById(R.id.watch_trailer);
        watch_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Webtoon1TrailerActivity.class);
                startActivity(intent);
            }
        });

        final TextView preview_txt = view.findViewById(R.id.preview_txt);    // 텍스트 일부 색상 변경하기
        SpannableStringBuilder ssb2 = new SpannableStringBuilder(preview_txt.getText());
        ssb2.setSpan(new ForegroundColorSpan(Color.parseColor("#02D136")),0,2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        preview_txt.setText(ssb2);


        ImageView preview_icon = view.findViewById(R.id.preview_icon);
        preview_layout1 = (LinearLayout) view.findViewById(R.id.preview_layout1);
        preview_layout2 = (LinearLayout) view.findViewById(R.id.preview_layout2);
        preview_layout3 = (LinearLayout) view.findViewById(R.id.preview_layout3);

        preview_icon.setOnClickListener(new View.OnClickListener() {  // 클릭 함수 안에서 LinearLayout 참조 변수를 선언했더니 오류가 발생했었음
            @Override
            public void onClick(View view) {


                if(preview){
                preview_layout1.setVisibility(View.VISIBLE);
                preview_layout2.setVisibility(View.VISIBLE);
                preview_layout3.setVisibility(View.VISIBLE);

                preview = false;
                }
                else{
                    preview_layout1.setVisibility(View.GONE);
                    preview_layout2.setVisibility(View.GONE);
                    preview_layout3.setVisibility(View.GONE);

                    preview = true;
                }
            }
        });



            return view;

    }
}

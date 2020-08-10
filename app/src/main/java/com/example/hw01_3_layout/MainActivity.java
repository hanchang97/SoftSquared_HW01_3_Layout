package com.example.hw01_3_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private Button btn;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag_home frag_home;
    private Frag_webtoon1 frag_webtoon1;
    public boolean backToHome = false;
    AlertDialog alertDialog;
    Button btn_close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("main onCreate");


        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {  //하단바 항목별 실행

                switch(menuItem.getItemId()){
                    case R.id.nav_1:
                        setFrag(0);
                        break;
                    case R.id.nav_2:
                        setFrag(1);
                        backToHome = true;
                        break;
                    case R.id.nav_3:
                        setFrag(2);
                        backToHome = true;
                        break;
                    case R.id.nav_4:
                        setFrag(3);
                        backToHome = true;
                        break;
                    case R.id.nav_5:
                        setFrag(4);
                        backToHome = true;
                        break;
                }
                return true; //선택됨을 리턴
            }
        });

        frag1 = new Frag1(); //프래그먼트 객체 생성
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag_home = new Frag_home();
        frag_webtoon1 = new Frag_webtoon1();

        setFrag(0);  //처음 진입시 fragment_home을 띄워줘야함


        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom, null);  //커스텀 다이얼로그

        AlertDialog.Builder builder = new AlertDialog.Builder(this); //어플 최초 실행 시 에만 광고가 나오도록 하기 위해 onCreate에 작성
        builder.setView(dialogView);

        alertDialog = builder.create();
        alertDialog.show();


        btn_close = dialogView.findViewById(R.id.btn_close);  //닫기 버튼



    }

    public void setFrag(int n){

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();   // 실제적인 프래그먼트 교체 행위

        switch(n){
            case 0:
                ft.replace(R.id.mainframe, frag_home);
                ft.commit();  //저장의 느낌?
                break;
            case 1:
                ft.replace(R.id.mainframe, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.mainframe, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.mainframe, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.mainframe, frag1);
                ft.commit();
                break;
            case 5:
                ft.replace(R.id.mainframe, frag_webtoon1);
                ft.commit();
        }

    }

    public void webtoon1Click(View view){  // 웹툰 선택 시 화면 전환
        setFrag(5);
        backToHome=true;
    }

    public void backBtn(View view){  // 특정 웹툰 선택 후 왼쪽 상단의 뒤로가기 터치했을 때

        onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("main onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("main onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("main onStart");

        btn_close.setOnClickListener(new View.OnClickListener() {     // 리스너 등록
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();  //다이얼로그 종료
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("main onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("main onStop");


        btn_close.setOnClickListener(null);  //리스너 해제   메모리 누수 문제 발생할 수 있어 리스너를 해제 해준다

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("main onDestroy");
    }


    @Override
    public void onBackPressed(){   // home을 제외한 fragment에서 뒤로가기 누르면 home fragment로 갈 수 있게 설정

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

       if(backToHome){
                    ft.replace(R.id.mainframe, frag_home);
                    ft.commit();
                    bottomNavigationView.getMenu().getItem(0).setChecked(true);  // 체크상태 자바 코드로 컨트롤
                    backToHome = false;
        }
        else
            super.onBackPressed();  // home fragment 에서 뒤로가기 누르면 앱 종료
        }
    }

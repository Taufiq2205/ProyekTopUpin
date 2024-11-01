package com.polije.proyektopupin.Firstpage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.polije.proyektopupin.Login.LoginActivity;
import com.polije.proyektopupin.R;

public class IntroSliderActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyViewPagerAdapter myViewPagerAdapter;
    LinearLayout dotslayout;
    TextView[] dots;
    int[] layouts;
    Button btnSkip, btnNext;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro_slider);

        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }

        // mengecek launch akticity
//        prefManager = new PrefManager(this);
//        if (!prefManager.IsFirstTimeLaunch()){
//            launchHomeScreen();
//            finish();
//        }

        //membuat trandparan notif
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

        //Hooks
        viewPager = findViewById(R.id.view_pager);
        dotslayout = findViewById(R.id.layoutDots);
        btnSkip = findViewById(R.id.btn_skip);
        btnNext = findViewById(R.id.btn_next);

        // layout xml slide 1 - 4
        layouts = new int[] {
                R.layout.intro1,
                R.layout.intro2,
                R.layout.intro3,
                R.layout.intro4
        };

        //tombol lingkaran
        addBottomDots(0);

        //membuat notif transparan
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menecek intro 4 jika home sudah tampil
                int current = getItem(+1);
                if (current < layouts.length){
                    //pindah ke intro selanjutnya
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });
    }

    private void addBottomDots(int currentPage){
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotslayout.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotslayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
//        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(IntroSliderActivity.this, LoginActivity.class));
        finish();
    }

    //view pager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // mengubah tombol next ke got it
            if (position == layouts.length - 1) {
                // last page make button text to got it
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    // making notif bar transparant
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    // view pager adapter
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter(){
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts[position], container,false);
        container.addView(view);

        return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
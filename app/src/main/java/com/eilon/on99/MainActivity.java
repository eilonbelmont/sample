package com.eilon.on99;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(this.<Toolbar>findViewById(R.id.toolbar));
        setupRV();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(MainActivity.this, MainActivity.class));
//            }
//        }, 1000);
    }

    private void setupRV() {
        RecyclerView rv = findViewById(R.id.rv_news);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Hello");
        }
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new SimpleAdapter(list);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            final View v = findViewById(R.id.view);
            v.getHeight();
            ValueAnimator animator = ValueAnimator.ofInt(0, v.getHeight());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    v.setTranslationY((int)animation.getAnimatedValue());
                }
            });
            // int = view.height
            // animator(from 0 to height)
            // update view.translationY
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

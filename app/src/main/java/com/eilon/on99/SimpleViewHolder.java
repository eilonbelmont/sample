package com.eilon.on99;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by eilon on 10/6/2018.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private View view;
    private View circle;
    private TextView tv;

    public SimpleViewHolder(View view) {
        super(view);
        this.view = view;
        circle = view.findViewById(R.id.circle);
        tv = view.findViewById(R.id.content);
    }

    public void bind(String s) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.getBackground().mutate().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
            }
        });
        tv.setText(s);
    }
}

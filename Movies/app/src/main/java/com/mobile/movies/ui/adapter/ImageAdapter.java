package com.mobile.movies.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mobile.movies.R;

/**
 * Created by Cristiane on 02/05/2017.
 */

public class ImageAdapter  extends BaseAdapter {
    private Context mContext;
    private float width;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        width = (dm.density * dm.widthPixels)/6;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView posterView;
        final ImageView removeButton;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
        } else {

        }

        removeButton = (ImageView) convertView.findViewById(R.id.remove_gridview_item);
        removeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        removeButton.setBackgroundColor(Color.parseColor("#1e90ff"));
                        // TODO
                        // call method to remove movie from favorites
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        removeButton.setBackgroundColor(Color.parseColor("#99000000"));
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        removeButton.setBackgroundColor(Color.parseColor("#99000000"));
                        break;
                    }
                }
                return true;
            }
        });

        posterView = (ImageView) convertView.findViewById(R.id.poster_gridview_item);
        posterView.setLayoutParams(new RelativeLayout.LayoutParams((int)width,355)); // for 3 columns
        posterView.setImageResource(mThumbIds[position]);
        return convertView;
    }

    // references to the images
    private Integer[] mThumbIds = {
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_hunger_games,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers,
            R.mipmap.poster_avengers, R.mipmap.poster_avengers
    };

}

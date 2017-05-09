package com.mobile.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.movies.R;
import com.mobile.movies.model.vo.Movie;

import java.util.ArrayList;

/**
 * Created by Cristiane on 30/04/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Movie> mDataset;
    static Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtYear;
        public TextView txtGenre;
        public TextView txtCast;
        public TextView txtRuntime;
        public ImageView ivArrow;
        public ImageView ivStar;
        public ImageView ivPoster;

        public ViewHolder(View v) {
            super(v);
            txtName = (TextView) v.findViewById(R.id.item_name);
            txtYear = (TextView) v.findViewById(R.id.item_year);
            txtGenre = (TextView) v.findViewById(R.id.item_genre);
            txtCast = (TextView) v.findViewById(R.id.item_cast);
            txtRuntime = (TextView) v.findViewById(R.id.item_runtime);
            ivArrow = (ImageView) v.findViewById(R.id.item_arrow);
            ivStar = (ImageView) v.findViewById(R.id.item_star);
            ivPoster = (ImageView) v.findViewById(R.id.item_poster);

            // Set custom fonts in the list item
            /*Typeface tfLight = Typeface.createFromAsset(mContext.getAssets(), "fonts/Montserrat-Light.otf");
            Typeface tfSemiBold = Typeface.createFromAsset(mContext.getAssets(), "fonts/Montserrat-SemiBold.otf");
            txtGenre.setTypeface(tfLight);
            txtYear.setTypeface(tfLight);
            txtTitle.setTypeface(tfSemiBold);*/
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(ArrayList<Movie> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //final String name = mDataset.get(position);
        holder.txtName.setText(mDataset.get(position).getBrazilianTitle());
        holder.txtYear.setText(""+mDataset.get(position).getYear());
        // TODO
        // get genre name
        holder.txtGenre.setText(""+mDataset.get(position).getGenre());
        holder.txtCast.setText("Com "+mDataset.get(position).getCast());
        holder.txtRuntime.setText(""+mDataset.get(position).getRuntime()+" min");
        holder.ivStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // mark movie as favorite here
            }
        });
        holder.ivStar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if (holder.ivStar.getDrawable().getConstantState().equals(mContext.getResources().getDrawable(R.mipmap.star_full).getConstantState())) {
                            holder.ivStar.setImageResource(R.mipmap.star_empty);
                            // TODO
                            // call method to remove movie from favorites
                        } else if (holder.ivStar.getDrawable().getConstantState().equals(mContext.getResources().getDrawable(R.mipmap.star_empty).getConstantState())) {
                            holder.ivStar.setImageResource(R.mipmap.star_full);
                            // TODO
                            // call method to add movie to favorites
                        }
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        //holder.ivStar.setBackgroundColor(Color.parseColor("#99000000"));
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        //holder.ivStar.setBackgroundColor(Color.parseColor("#000000"));
                        break;
                    }
                }
                return true;
            }
        });
        holder.ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // call movie activity here
                //Intent i = new Intent(mContext, MovieActivity.class);
                //mContext.startActivity(i);
            }
        });
        // TODO
        // set movie poster here
        holder.ivPoster.setImageResource(R.mipmap.poster_avengers);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

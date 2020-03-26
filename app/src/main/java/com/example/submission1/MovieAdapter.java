package com.example.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtJudul;
        private TextView txtDesc;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtJudul = view.findViewById(R.id.tv_judul);
            txtDesc = view.findViewById(R.id.tv_desc);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movie movie) {
            txtJudul.setText(movie.getJudul());
            txtDesc.setText(movie.getDesc());
            imgPoster.setImageResource(movie.getPoster());
        }
    }
}

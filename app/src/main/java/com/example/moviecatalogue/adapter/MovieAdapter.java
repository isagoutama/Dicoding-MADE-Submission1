package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        this.movies = new ArrayList<>();
    }

    public ArrayList<Movie> getHeroes() {
        return movies;
    }

    public void setHeroes(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        TextView textTitle = convertView.findViewById(R.id.txt_movie_title);
        TextView textDescription = convertView.findViewById(R.id.txt_description);
        ImageView imgMovie = convertView.findViewById(R.id.img_movie_poster);

        Movie movie = (Movie) getItem(position);
        textTitle.setText(movie.getTitle());
        textDescription.setText(movie.getDescription());
        imgMovie.setImageResource(movie.getPhoto());
        return convertView;
    }
}

package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moviecatalogue.adapter.MovieAdapter;
import com.example.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataScore;
    private String[] dataRelease;
    private TypedArray dataPoster;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listMovie = findViewById(R.id.list_movie);
        movieAdapter = new MovieAdapter(this);
        listMovie.setAdapter(movieAdapter);

        prepare();
        addItem();

        listMovie.setOnItemClickListener(this);

    }

    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setRelease(dataRelease[i]);
            movie.setScore(dataScore[i]);
            movies.add(movie);
        }

        movieAdapter.setHeroes(movies);
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataPoster = getResources().obtainTypedArray(R.array.data_image);
        dataScore = getResources().getStringArray(R.array.data_score);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataDescription = getResources().getStringArray(R.array.data_description);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        Intent moveToDetail = new Intent(this, DetailMovieActivity.class);
        moveToDetail.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(position));
        startActivity(moveToDetail);
    }
}

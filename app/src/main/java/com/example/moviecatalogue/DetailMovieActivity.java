package com.example.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView detailTitle, detailDescription, detailscore, detailRelease;
    private ImageView detailPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        detailTitle = findViewById(R.id.title_detail);
        detailDescription = findViewById(R.id.description_detail);
        detailscore = findViewById(R.id.score_detail);
        detailRelease = findViewById(R.id.release_detail);
        detailPoster = findViewById(R.id.img_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        detailTitle.setText(movie.getTitle());
        detailDescription.setText(movie.getDescription());
        detailPoster.setImageResource(movie.getPhoto());
        detailRelease.setText(movie.getRelease());
        detailscore.setText(String.valueOf(movie.getScore())+"%");
    }
}

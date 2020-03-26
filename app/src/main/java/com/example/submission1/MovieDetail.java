package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvJudul;
    private TextView tvDesc;
    private TextView tvTanggal;
    private TextView tvCast;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvJudul = findViewById(R.id.tv_judul_detail);
        tvDesc = findViewById(R.id.tv_desc_detail);
        tvTanggal = findViewById(R.id.tv_tanggal);
        imgPoster = findViewById(R.id.img_poster_detail);
        tvCast = findViewById(R.id.tv_cast);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        setMovieDetail(movie);
    }

    private void setMovieDetail(Movie movieDetail){
        int poster = movieDetail.getPoster();
        String judul = movieDetail.getJudul();
        String desc = movieDetail.getDesc();
        String tanggal = movieDetail.getTanggal();
        String cast = movieDetail.getCast();

        setTitle("Detail Film");
        tvJudul.setText(judul);
        tvDesc.setText(desc);
        tvTanggal.setText(tanggal);
        imgPoster.setImageResource(poster);
        tvCast.setText(cast);
    }
}

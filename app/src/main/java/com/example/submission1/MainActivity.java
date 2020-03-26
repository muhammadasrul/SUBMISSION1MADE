package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private String[] dataJudul;
    private String[] dataDesc;
    private String[] dataRilis;
    private String[] dataTopCast;
    private TypedArray dataPoster;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Daftar Film");

        ListView listView = findViewById(R.id.lv_movie);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                goToSelectedMovie(movies.get(i));
            }
        });
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataTopCast = getResources().getStringArray(R.array.data_top_cast);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setJudul(dataJudul[i]);
            movie.setDesc(dataDesc[i]);
            movie.setTanggal(dataRilis[i]);
            movie.setCast(dataTopCast[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

    private void goToSelectedMovie(Movie movie) {
        Intent intent = new Intent(MainActivity.this, MovieDetail.class);
        intent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
        Toast.makeText(MainActivity.this, movie.getJudul(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}

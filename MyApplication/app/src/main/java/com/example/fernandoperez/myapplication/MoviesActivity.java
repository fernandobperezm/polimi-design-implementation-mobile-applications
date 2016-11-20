package com.example.fernandoperez.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.example.fernandoperez.myapplication.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    private void setupMoviesView() {
//        // Building model.
//        List<String> movies = Arrays.asList("Blue Velvet", "Kill Bill","Interstellar");
//
//        // Getting the list view.
//        ListView moviesList = (ListView) findViewById(R.id.movies_list);
//
//        // The use of android.R lets you to use default examples.
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, movies);
//
//        // Fitting the adapter inside the list view.
//        moviesList.setAdapter(adapter);
//    }

//    private void setupMoviesView() {
//        // movies needs to be final for the instatiation.
//        final List<Movie> movies = Movie.getMovies();
//        ListView movieListView = (ListView)  findViewById(R.id.movies_list);
//
//        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1, movies);
//
//        movieListView.setAdapter(adapter);
//
//        // "this" is catched here because inside the class isn't a class.
//        final MoviesActivity self = this;
//
//        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            // This is an instantiation and a declaration of a new class.
//            @Override
//            public void onItemClick(AdapterView<?> parent,
//                                    View view, int position, long id) {
//
//                // We Want to retrieve the edit text when the user presses the Ok Button.
//                EditText editText = (EditText) findViewById(R.id.user_string);
//                String result = movies.get(position).toString();
//
//                // Send the message (intent) to the other class.
//                // "this" is an instance of this class, not an activity.
//                Intent intent = new Intent(self,ResultsActivity.class);
//                // Add the message to the other class.
//                intent.putExtra(Commons.TEXT_EXTRA, result);
//                startActivity(intent);
//            }
//        });
//
//
//    }

    private void setupMoviesView() {

        final List<Movie> movies = Collections
                .synchronizedList(new ArrayList<Movie>());

        final TypedArray movieIds=getResources()
                .obtainTypedArray(R.array.movie_imdb_ids);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieRestService movieRestService = retrofit
                .create(MovieRestService.class);

        for (int i = 0; i < movieIds.length(); i++){
            // Internet calls must be done in background.
//            try {
//                movieRestService.getMovie(movieIds.getString(i))
//                        .execute();
//            } catch (IOException e){
//                e.printStackTrace();
//            }

            //This way we can do that call.


            movieRestService.getMovie(movieIds.getString(i))
                    .enqueue(new Callback<Movie>() {
                        @Override
                        public void onResponse(Call<Movie> call, Response<Movie> response) {
                            Movie movie = response.body();
                            movies.add(movie);
                            if (movies.size() == movieIds.length()){
                                setupListView(movies);
                            }
                        }

                        @Override
                        public void onFailure(Call<Movie> call, Throwable t) {

                        }
                    });
        }
    }

    public void setupListView(List<Movie> movies){

        ListView movieListView = (ListView)  findViewById(R.id.movies_list);

        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1, movies);

        movieListView.setAdapter(adapter);
    }
}

package fernandoperez.moviesdiary.activity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import fernandoperez.moviesdiary.R;
import fernandoperez.moviesdiary.model.Movie;
import fernandoperez.moviesdiary.utils.Commons;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fillMovies();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fillMovies() {
        // Having all movies.
        final List<Movie> movies = Movie.getAllMovies();

        // Getting the list view and setting movies to it.
        ListView listView = (ListView) findViewById(R.id.activity_movies_listview);

        // Creating an adapter and inserting the movies to it in order to be displayable.
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(
                this,
                android.R.layout.simple_list_item_1,
                movies);

        // The listview is fulfilled with the adapter info.
        listView.setAdapter(adapter);

        final MoviesActivity self = this; // The context is not visible inside onItemClick.

        // Make the movies clickable.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Getting the movie.
                String selectedMovie = movies.get(position).toString();

                Intent intent = new Intent(self, ResultsActivity.class);
                intent.putExtra(Commons.USER_MESSAGE, selectedMovie);

                startActivity(intent);
            }
        });
    }
}

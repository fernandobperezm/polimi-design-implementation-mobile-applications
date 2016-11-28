package fernandoperez.moviesdiary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fernandoperez.moviesdiary.R;
import fernandoperez.moviesdiary.model.Movie;



/**
 * Created by fernandoperez on 11/28/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter (Context context, List<Movie> movieList) {
        super(context, 0, movieList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        MovieViewHolder movieViewHolder;

        if (convertView == null) { // If the view doesn't exist.
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.movie_row, null);

            movieViewHolder = new MovieViewHolder(convertView);
            convertView.setTag(movieViewHolder);
        } else {
            movieViewHolder = (MovieViewHolder) convertView.getTag();
        }

        movieViewHolder.directorTextView.setText(movie.getDirector());
        movieViewHolder.titleTextView.setText(movie.getTitle());

        return convertView;
    }

    static class MovieViewHolder {
        TextView titleTextView;
        TextView directorTextView;

        public MovieViewHolder(View view) {
            titleTextView = (TextView) view.findViewById(R.id.movie_title_textview);
            directorTextView = (TextView) view.findViewById(R.id.movie_director_textview);
        }
    }
}

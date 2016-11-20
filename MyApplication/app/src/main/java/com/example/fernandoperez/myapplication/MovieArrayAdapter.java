package com.example.fernandoperez.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fernandoperez.myapplication.model.Movie;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by fernandoperez on 10/27/16.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{
    public MovieArrayAdapter(Context context, List<Movie> movieList) {
        super(context, 0, movieList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Option 1. We create a new row every time. This has a slow performance.
//        Movie movie = getItem(position);
//
//        LayoutInflater layoutInflater = (LayoutInflater) getContext()
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View row = layoutInflater.inflate(R.layout.movie_row, null);
//
//        TextView titleTextView = (TextView) row.findViewById(R.id.movie_title_textview);
//        titleTextView.setText(movie.getTitle());
//
//        TextView directorTextView = (TextView) row.findViewById(R.id.movie_director_textview);
//        titleTextView.setText(movie.getDirector());


//        // Option2. The first time, the convertView es null, after that, we don't inflate it anymore.
//        Movie movie = getItem(position);
//
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) getContext()
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            convertView = layoutInflater.inflate(R.layout.movie_row, null);
//        }
//
//
//
//        TextView titleTextView = (TextView) convertView
//                .findViewById(R.id.movie_title_textview);
//        titleTextView.setText(movie.getTitle());
//
//        TextView directorTextView = (TextView) convertView
//                .findViewById(R.id.movie_director_textview);
//        titleTextView.setText(movie.getDirector());

        // Option.3 Same as option 2 but using a viewHolder.
        Movie movie = getItem(position);
        MovieViewHolder movieViewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.movie_row, null);

            movieViewHolder = new MovieViewHolder(convertView);
            convertView.setTag(movieViewHolder);
        } else {
            movieViewHolder = (MovieViewHolder) convertView.getTag();
        }

        movieViewHolder.titleTextView.setText(movie.getTitle());
        movieViewHolder.directorTextView.setText(movie.getDirector());

        return convertView;
    }

    static class MovieViewHolder {
        TextView titleTextView;
        TextView directorTextView;

        public MovieViewHolder(View view) {
            TextView titleTextView = (TextView) view
                    .findViewById(R.id.movie_title_textview);

            TextView directorTextView = (TextView) view
                    .findViewById(R.id.movie_director_textview);
        }
    }



}

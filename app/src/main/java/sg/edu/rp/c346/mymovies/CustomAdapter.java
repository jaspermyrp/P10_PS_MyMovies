package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> moviesList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        moviesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivRatings = rowView.findViewById(R.id.ivRating);
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDescription = rowView.findViewById(R.id.tvDescription);


        Movie currentMovie = moviesList.get(position);
        String makeDescription = currentMovie.getYear() + "-" +currentMovie.getGenre();

        tvTitle.setText(currentMovie.getTitle());
        tvDescription.setText(makeDescription);

        String getRated = currentMovie.getRated();
        if (getRated.equalsIgnoreCase("g")) {
            ivRatings.setImageResource(R.drawable.rating_g);
        } else if (getRated.equalsIgnoreCase("pg")) {
            ivRatings.setImageResource(R.drawable.rating_pg);
        } else if (getRated.equalsIgnoreCase("pg13")) {
            ivRatings.setImageResource(R.drawable.rating_pg13);
        } else if (getRated.equalsIgnoreCase("nc16")) {
            ivRatings.setImageResource(R.drawable.rating_nc16);
        } else if (getRated.equalsIgnoreCase("m18")) {
            ivRatings.setImageResource(R.drawable.rating_m18);
        } else {
            // R21 //
            ivRatings.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}

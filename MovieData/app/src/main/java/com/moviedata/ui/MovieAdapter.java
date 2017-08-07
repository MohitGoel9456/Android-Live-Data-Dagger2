package com.moviedata.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moviedata.R;
import com.moviedata.entities.Results;
import com.moviedata.viewmodel.MoviesDataViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MGoel on 02-08-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<Results> results;
    private MovieDetailsFragment movieDetailsFragment;

    public MovieAdapter(Context mContext,MovieDetailsFragment movieDetailsFragment) {
        context = mContext;
        results = new ArrayList<>();
        this.movieDetailsFragment = movieDetailsFragment;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvOriginalName.setText(results.get(position).getOriginal_name());
        holder.tvOverview.setText(results.get(position).getOverview());
    }

    public void getMovieResults(List<Results> list) {
        results.clear();
        results.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOriginalName, tvOverview;

        public ViewHolder(View itemView) {
            super(itemView);
            tvOriginalName = itemView.findViewById(R.id.tv_original_name);
            tvOverview = itemView.findViewById(R.id.tv_overview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieDetailsFragment.replaceFragment(new PopularityFragment());
                }
            });
        }
    }
}

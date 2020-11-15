package id.putraprima.mvvmrecyclerview.screens.movielist;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.putraprima.mvvmrecyclerview.databinding.ItemMovieBinding;
import id.putraprima.mvvmrecyclerview.models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;
    private OnItemMovieListener itemMovieListener;

    public MovieAdapter() {
    }

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public MovieAdapter(OnItemMovieListener itemMovieListener) {
        this.itemMovieListener = itemMovieListener;
    }

    public MovieAdapter(List<Movie> movieList, OnItemMovieListener itemMovieListener) {
        this.movieList = movieList;
        this.itemMovieListener = itemMovieListener;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding itemMovieBinding = ItemMovieBinding.inflate(layoutInflater,parent,false);
        return new MovieViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie,itemMovieListener);
    }

    @Override
    public int getItemCount() {
        if(movieList!=null){
            return movieList.size();
        }else{
            return 0;
        }
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding binding;


        public MovieViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie, OnItemMovieListener itemMovieListener){
            binding.setMovie(movie);
            binding.setClickListener(itemMovieListener);
            binding.executePendingBindings();
        }
    }
}


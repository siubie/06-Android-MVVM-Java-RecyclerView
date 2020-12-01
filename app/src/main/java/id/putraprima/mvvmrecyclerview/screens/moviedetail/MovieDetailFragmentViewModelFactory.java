package id.putraprima.mvvmrecyclerview.screens.moviedetail;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmrecyclerview.models.Movie;
import id.putraprima.mvvmrecyclerview.screens.movielist.ListMovieFragmentViewModel;

public class MovieDetailFragmentViewModelFactory implements ViewModelProvider.Factory {
    private Movie movie;

    public MovieDetailFragmentViewModelFactory(Movie movie) {
        this.movie = movie;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MovieDetailFragmentViewModel.class)){
            return (T) new MovieDetailFragmentViewModel(movie);
        }
        throw new IllegalArgumentException("Wrong View Model Class");
    }
}

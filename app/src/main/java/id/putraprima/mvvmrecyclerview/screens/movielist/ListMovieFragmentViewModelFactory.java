package id.putraprima.mvvmrecyclerview.screens.movielist;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class ListMovieFragmentViewModelFactory implements ViewModelProvider.Factory {
    private List<Movie> listMovie;

    public ListMovieFragmentViewModelFactory(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ListMovieFragmentViewModel.class)){
            return (T) new ListMovieFragmentViewModel(listMovie);
        }
        throw new IllegalArgumentException("Viewmodel Yang Diminta MainActivityViewModel");
    }
}
package id.putraprima.mvvmrecyclerview.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class MovieViewModelFactory implements ViewModelProvider.Factory{
    private List<Movie> listMovie;

    public MovieViewModelFactory(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MovieViewModel.class)){
            return (T) new MovieViewModel(listMovie);
        }
        throw new IllegalArgumentException("Viewmodel Yang Diminta MainActivityViewModel");
    }
}

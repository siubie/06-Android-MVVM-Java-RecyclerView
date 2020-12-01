package id.putraprima.mvvmrecyclerview.screens.moviedetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class MovieDetailFragmentViewModel extends ViewModel {
    private MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();

    public MovieDetailFragmentViewModel(Movie movie) {
        this.movieMutableLiveData.setValue(movie);
    }

    public LiveData<Movie> movieLiveData(){
        return this.movieMutableLiveData;
    }
}

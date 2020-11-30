package id.putraprima.mvvmrecyclerview.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> listMovieMutableLiveData = new MutableLiveData<List<Movie>>();
    private MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();
    private List<Movie> movieList = new ArrayList<>();

    public MovieViewModel(List<Movie> movieList) {
        this.movieList = movieList;
        this.listMovieMutableLiveData.setValue(movieList);
    }

    public LiveData<List<Movie>> listMovieLiveData(){
        return this.listMovieMutableLiveData;
    }

    public void onMovieClicked(Movie movie){
        movieMutableLiveData.setValue(movie);
    }

    public LiveData<Movie> movieLiveData(){
        return movieMutableLiveData;
    }

    public void addOneItem(){
        movieList.add(new Movie("Judul Baru","Deskripsi Item Baru",false));
        this.listMovieMutableLiveData.setValue(movieList);
    }
}
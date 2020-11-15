package id.putraprima.mvvmrecyclerview.screens.movielist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class ListMovieFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> listMovieMutableLiveData = new MutableLiveData<List<Movie>>();
    private List<Movie> listMovie = null;

    public ListMovieFragmentViewModel(List<Movie> listMovie) {
        this.listMovie=listMovie;
        this.listMovieMutableLiveData.setValue(listMovie);
    }


    public LiveData<List<Movie>> listMovieLiveData (){
        return listMovieMutableLiveData;
    }

    public void addOneItem(){
        this.listMovie.add(new Movie("Judul Baru","Deskripsi Item Baru",false));
        this.listMovieMutableLiveData.setValue(listMovie);
    }

    private MutableLiveData<Movie> _navigateToDetail = new MutableLiveData<>();

    public LiveData<Movie> navigateToDetail(){
        return _navigateToDetail;
    }

    public void onMovieClicked(Movie movie){
        _navigateToDetail.setValue(movie);
    }

    public void onMovieDetailNavigated(){
        _navigateToDetail.setValue(null);
    }

}

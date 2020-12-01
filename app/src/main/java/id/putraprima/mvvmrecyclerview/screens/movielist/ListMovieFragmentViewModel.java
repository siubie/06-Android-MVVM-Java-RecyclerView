package id.putraprima.mvvmrecyclerview.screens.movielist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;

public class ListMovieFragmentViewModel extends ViewModel {
   private MutableLiveData<List<Movie>> listMovieMutableLiveData = new MutableLiveData<>();
   private MutableLiveData<Movie> movieMutableLiveData = new MutableLiveData<>();

   public ListMovieFragmentViewModel(List<Movie> listMovie) {
      this.listMovieMutableLiveData.setValue(listMovie);
   }

   public LiveData<List<Movie>> listMovieLiveData(){
       return listMovieMutableLiveData;
   }

   public void onMovieClicked(Movie movie){
       this.movieMutableLiveData.setValue(movie);
   }

   public LiveData<Movie> movieLiveData(){
      return this.movieMutableLiveData;
   }

   public void addOneItem(){
      List<Movie> listMovie = listMovieMutableLiveData.getValue();
      assert listMovie != null;
      listMovie.add(new Movie("Judul Baru","deskripsi",false));
      this.listMovieMutableLiveData.setValue(listMovie);
   }
}


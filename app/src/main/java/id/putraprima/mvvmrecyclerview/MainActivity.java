package id.putraprima.mvvmrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mvvmrecyclerview.models.Movie;
import id.putraprima.mvvmrecyclerview.viewmodels.MovieViewModel;
import id.putraprima.mvvmrecyclerview.viewmodels.MovieViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Naga Bonar", "Filem Perjuangan Naga Bonar Melawan Penjajah Belanda", false));
        movieList.add(new Movie("Naga Bonar Jadi Dua", "Filem Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng", false));
        MovieViewModelFactory movieViewModelFactory = new MovieViewModelFactory(movieList);
        movieViewModel = new ViewModelProvider(this,movieViewModelFactory).get(MovieViewModel.class);
    }
}
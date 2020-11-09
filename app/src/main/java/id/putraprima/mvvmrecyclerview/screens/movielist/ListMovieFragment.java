package id.putraprima.mvvmrecyclerview.screens.movielist;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mvvmrecyclerview.R;
import id.putraprima.mvvmrecyclerview.databinding.FragmentListMovieBinding;
import id.putraprima.mvvmrecyclerview.models.Movie;

public class ListMovieFragment extends Fragment {

    private FragmentListMovieBinding binding;

    public ListMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_movie, container, false);
        setupRvMovie();
        return binding.getRoot();
    }

    private void setupRvMovie() {
        RecyclerView recyclerView = binding.rvMovie;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Naga Bonar", "Filem Perjuangan Naga Bonar Melawan Penjajah Belanda", false));
        movieList.add(new Movie("Naga Bonar Jadi Dua", "Filem Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng", false));
        MovieAdapter adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);
    }
}
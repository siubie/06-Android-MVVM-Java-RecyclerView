package id.putraprima.mvvmrecyclerview.screens.movielist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mvvmrecyclerview.R;
import id.putraprima.mvvmrecyclerview.databinding.FragmentListMovieBinding;
import id.putraprima.mvvmrecyclerview.models.Movie;

public class ListMovieFragment extends Fragment {

    private FragmentListMovieBinding binding;
    private ListMovieFragmentViewModel viewModel;

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

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Naga Bonar", "Filem Perjuangan Naga Bonar Melawan Penjajah Belanda", false));
        movieList.add(new Movie("Naga Bonar Jadi Dua", "Filem Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng", false));
        ListMovieFragmentViewModelFactory listMovieFragmentViewModelFactory = new ListMovieFragmentViewModelFactory(movieList);
        viewModel = new ViewModelProvider(this,listMovieFragmentViewModelFactory).get(ListMovieFragmentViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_movie, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRvMovie();
    }

    private void setupRvMovie() {
        RecyclerView recyclerView = binding.rvMovie;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MovieAdapter adapter = new MovieAdapter(new OnItemMovieListener() {
            @Override
            public void onMovieClicked(Movie movie) {
                Toast.makeText(getContext(),"Movie"+movie.getMovieTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        viewModel.listMovieLiveData().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setMovieList(movies);
            }
        });
    }

}
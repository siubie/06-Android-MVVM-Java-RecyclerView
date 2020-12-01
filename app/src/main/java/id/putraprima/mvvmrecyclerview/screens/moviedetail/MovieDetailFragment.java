package id.putraprima.mvvmrecyclerview.screens.moviedetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmrecyclerview.R;
import id.putraprima.mvvmrecyclerview.databinding.FragmentMovieDetailBinding;
import id.putraprima.mvvmrecyclerview.models.Movie;
import id.putraprima.mvvmrecyclerview.screens.movielist.ListMovieFragmentViewModel;
import id.putraprima.mvvmrecyclerview.screens.movielist.ListMovieFragmentViewModelFactory;

public class MovieDetailFragment extends Fragment {

    private FragmentMovieDetailBinding binding;
    private MovieDetailFragmentViewModel viewModel;

    public MovieDetailFragment() {
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

        assert getArguments() != null;
        Movie movie =  MovieDetailFragmentArgs.fromBundle(getArguments()).getMovie();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_detail, container, false);
        MovieDetailFragmentViewModelFactory movieDetailFragmentViewModelFactory = new MovieDetailFragmentViewModelFactory(movie);
        viewModel = new ViewModelProvider(this,movieDetailFragmentViewModelFactory).get(MovieDetailFragmentViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
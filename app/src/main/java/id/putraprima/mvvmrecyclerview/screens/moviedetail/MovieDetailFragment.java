package id.putraprima.mvvmrecyclerview.screens.moviedetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmrecyclerview.R;
import id.putraprima.mvvmrecyclerview.databinding.FragmentMovieDetailBinding;
import id.putraprima.mvvmrecyclerview.models.Movie;
import id.putraprima.mvvmrecyclerview.viewmodels.MovieViewModel;

public class MovieDetailFragment extends Fragment {

    private FragmentMovieDetailBinding binding;
    private MovieViewModel viewModel;

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

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_detail, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MovieViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
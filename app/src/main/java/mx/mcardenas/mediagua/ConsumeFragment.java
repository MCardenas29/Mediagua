package mx.mcardenas.mediagua;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsumeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsumeFragment extends Fragment {

    public ConsumeFragment() {
        // Required empty public constructor
    }

    public static ConsumeFragment newInstance() {
        ConsumeFragment fragment = new ConsumeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity activity = (MainActivity) getActivity();
        activity.toolbarViewModel.setTitle(getString(R.string.consumption));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_consume, container, false);
    }
}
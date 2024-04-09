package mx.mcardenas.mediagua.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import mx.mcardenas.mediagua.R;
import mx.mcardenas.mediagua.activities.MainActivity;
import mx.mcardenas.mediagua.adapters.ExpensesAdapter;
import mx.mcardenas.mediagua.databinding.FragmentBillBinding;
import mx.mcardenas.mediagua.models.ExpenseModel;
import mx.mcardenas.mediagua.viewmodels.BillViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillFragment extends Fragment {
    FragmentBillBinding binding;
    ObjectAnimator rotateAnimation, scrollAnimation;
    boolean isStopCockOpen = false;


    public BillFragment() {
        // Required empty public constructor
    }

    public static BillFragment newInstance() {
        BillFragment fragment = new BillFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rotateAnimation = new ObjectAnimator();
        rotateAnimation.setPropertyName("rotation");
        rotateAnimation.setFloatValues(0f, -90f);

        scrollAnimation = new ObjectAnimator();
        scrollAnimation.setPropertyName("scrollY");
    }

    private void stopCockAnimate(View v) {
        if (isStopCockOpen) {
            rotateAnimation.reverse();
            scrollAnimation.reverse();
        } else {
            rotateAnimation.start();
            scrollAnimation.start();
        }
        isStopCockOpen = !isStopCockOpen;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBillBinding.inflate(inflater, container, false);
        binding.setBillViewModel(new BillViewModel());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rotateAnimation.setTarget(binding.handle);
        scrollAnimation.setTarget(binding.water);

        int image_height = binding.water.getDrawable().getIntrinsicHeight();
        binding.water.setScrollY(-image_height);
        scrollAnimation.setIntValues(-image_height, 10);

        binding.stopcockSwitch.setOnClickListener(this::stopCockAnimate);
        ArrayList<ExpenseModel> list = new ArrayList<>();
        list.add(new ExpenseModel("Elel", 200f, 120, 431));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        list.add(new ExpenseModel("Pepe", 20f, 512, 511));
        binding.expensesRecycle.setAdapter(new ExpensesAdapter(list));
        binding.expensesRecycle.setHasFixedSize(true);

        BottomSheetBehavior<FrameLayout> behaviour = BottomSheetBehavior.from(binding.standardBottomSheet);
        behaviour.setHideable(false);
        behaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);
        behaviour.setPeekHeight(170, true);
        binding.bottomHandler.setOnClickListener(v -> {
            behaviour.setState(behaviour.getState() == BottomSheetBehavior.STATE_COLLAPSED ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity activity = (MainActivity) getActivity();
        activity.toolbarViewModel.setTitle(getString(R.string.bill));
    }

}
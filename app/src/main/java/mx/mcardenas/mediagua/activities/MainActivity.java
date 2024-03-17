package mx.mcardenas.mediagua.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

import mx.mcardenas.mediagua.R;
import mx.mcardenas.mediagua.databinding.ActivityMainBinding;
import mx.mcardenas.mediagua.viewmodels.ToolbarViewModel;

public class MainActivity extends AppCompatActivity {
    public ToolbarViewModel toolbarViewModel;
    private ActivityMainBinding binding;
    private BadgeDrawable iconBadge;

    @SuppressLint("UnsafeOptInUsageError")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        toolbarViewModel = new ToolbarViewModel(getString(R.string.bill));
        binding.setToolbar(toolbarViewModel);
        setContentView(binding.getRoot());

        NavController navController = NavHostFragment
                .findNavController(binding.fragmentContainer.getFragment());
        NavigationUI.setupWithNavController(binding.navigationView, navController);
        binding.appToolbar.setNavigationOnClickListener(v -> binding.drawerLayout.open());
        // TODO: Implement the config and about section in the menu

        // Create badge
        iconBadge = BadgeDrawable.create(this);
        iconBadge.setNumber(toolbarViewModel.getNotifCount());
        BadgeUtils.attachBadgeDrawable(iconBadge, binding.appToolbar, R.id.notifications);
    }


}
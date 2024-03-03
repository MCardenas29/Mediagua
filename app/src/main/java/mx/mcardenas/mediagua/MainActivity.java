package mx.mcardenas.mediagua;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import mx.mcardenas.mediagua.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavController navController = NavHostFragment.findNavController(binding.navContainer.getFragment());
        NavigationUI.setupWithNavController(binding.mainNavigation, navController);

        binding.topbar.setNavigationOnClickListener(this::openNavigation);
    }

    private void openNavigation(View view) {
        binding.drawerLayout.open();
    }
}
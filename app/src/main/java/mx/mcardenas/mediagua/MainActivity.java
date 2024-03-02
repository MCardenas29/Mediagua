package mx.mcardenas.mediagua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.FileInputStream;
import java.util.Properties;

import io.particle.android.sdk.cloud.BuildConfig;
import mx.mcardenas.mediagua.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
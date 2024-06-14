package mx.mcardenas.mediagua.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import mx.mcardenas.mediagua.MediaguaDatabase
import mx.mcardenas.mediagua.components.Loader
import mx.mcardenas.mediagua.ui.theme.AppTheme
import mx.mcardenas.mediagua.ui.theme.AppTypography
import mx.mcardenas.mediagua.viewmodels.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Content() }
    }

    private fun openWelcome() {
        val intent = Intent(baseContext, WelcomeActivity::class.java)
        startActivity(intent)
        Log.d("UI", "CDF")
    }

    @Composable
    fun Content() {
        val viewModel: MainViewModel by viewModels()
        val count by viewModel.userQuantity.observeAsState(-1)

        if (count == 0) openWelcome()
        Log.d("UI", "SCARLET")

        AppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Loader(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    statement = count <= 0
                ) {
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text(
                            text = "Holaaa " + viewModel.userQuantity,
                            style = AppTypography.displayMedium
                        )
                    } // Column
                } // Loader
            } // Scaffold
        } // AppTheme
    }

    @Preview
    @Composable
    fun Preview() {
        Content()
    }

}


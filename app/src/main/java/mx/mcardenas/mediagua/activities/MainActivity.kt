package mx.mcardenas.mediagua.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import mx.mcardenas.mediagua.MediaguaDB
import mx.mcardenas.mediagua.ui.theme.AppTheme
import mx.mcardenas.mediagua.ui.theme.AppTypography
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var db: MediaguaDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent { Content() }
    }

    private fun openWelcome() {
        val intent = Intent(baseContext, WelcomeActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun Content() {
        AppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Text(text = "Holaaa", style = AppTypography.displayMedium)
                } // Column
            } // Scaffold
        } // AppTheme
    }

    @Preview
    @Composable
    fun Preview() {
        Content()
    }

}


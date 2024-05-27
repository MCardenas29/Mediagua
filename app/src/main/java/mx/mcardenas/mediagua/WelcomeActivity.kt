package mx.mcardenas.mediagua

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import mx.mcardenas.mediagua.ui.theme.AppTheme
import mx.mcardenas.mediagua.ui.theme.AppTypography

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text(text = "Bienvenuto", style = AppTypography.displayMedium)
                    }
                }
            }
        }
    }
}
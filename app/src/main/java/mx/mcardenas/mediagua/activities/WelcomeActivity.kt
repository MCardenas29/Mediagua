package mx.mcardenas.mediagua.activities

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.mcardenas.mediagua.ui.theme.AppTheme
import mx.mcardenas.mediagua.views.WelcomeScreen
import kotlin.math.roundToInt

class WelcomeActivity : AppCompatActivity() {
    private val backButton = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        onBackPressedDispatcher.addCallback(this, backButton)
        setContent { Content() }
    }

    @Composable
    fun Content() {
        val navController = rememberNavController()
        val routeNames = arrayOf("index", "register")
        var currentProgress by remember { mutableFloatStateOf(0f) }

        AppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(vertical = 40.dp, horizontal = 25.dp)
                        .padding(innerPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NavHost(
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        startDestination = routeNames[currentProgress.roundToInt()]
                    ) {
                        composable(routeNames[0]) { WelcomeScreen() }
                        composable(routeNames[1]) { Text("Hola") }
                    }
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        progress = { currentProgress / routeNames.size })
                    Button(onClick = { currentProgress++ }) {
                        Text(text = "Siguiente")
                    }
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
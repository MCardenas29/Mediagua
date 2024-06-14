package mx.mcardenas.mediagua.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.mcardenas.mediagua.R
import mx.mcardenas.mediagua.ui.theme.AppTypography
import mx.mcardenas.mediagua.ui.theme.primaryLight

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(90.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo"
        )
        Text(
            text = "Bienvenido",
            style = AppTypography.displayMedium,
            color = primaryLight
        )
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(text = "Monitorea y controla tu consumo de agua de manera eficiente")
        }
    }
}
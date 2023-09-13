package fr.upjv.monprojetkotlin.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,

    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Tony TIRYAKI")
        Button(
            content = {
                Text("go to list screen")
            },
            onClick = { onButtonClick() }
        )
        Button(
            content = {
                Text("go to chuck norris")
            },
            onClick = { onButton2Click() }
        )

    }
}

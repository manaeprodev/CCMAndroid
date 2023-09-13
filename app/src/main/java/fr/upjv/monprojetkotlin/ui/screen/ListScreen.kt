package fr.upjv.monprojetkotlin.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.upjv.monprojetkotlin.R
import fr.upjv.monprojetkotlin.ui.model.ItemUi
import fr.upjv.monprojetkotlin.ui.model.ItemUi.Item
import fr.upjv.monprojetkotlin.ui.viewmodel.AndroidVersionViewModel

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    val viewModel: AndroidVersionViewModel = viewModel()
    val list = viewModel.androidVersionList.collectAsState().value

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    )
    {
        items(
            count = list.size,
        ) {
            when (val currentItem = list[it]) {
                is ItemUi.Header -> Text(
                    text = "Name = ${currentItem.title}",
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.mint), shape = CircleShape)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    color = colorResource(id = R.color.night_blue),
                    textAlign = TextAlign.Center
                )

                is Item -> Text(
                    text = "Number ${currentItem.versionNumber}",
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.light_lime), shape = CircleShape)
                        .padding(4.dp),
                    color = Color.Black,
                )

                is ItemUi.Footer -> Text(
                    text = "${currentItem.number} total items",
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.turquoise), shape = CircleShape)
                        .padding(6.dp),
                    color = Color.Gray,
                )
            }
        }
    }


}

package fr.upjv.monprojetkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.upjv.monprojetkotlin.ItemUi.MyAndroidObject
import fr.upjv.monprojetkotlin.ui.theme.MonProjetKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonProjetKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyList()
                }
            }
        }
    }
}

@Composable
fun MyList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        val listOfResult = mutableListOf<ItemUi>()
        populateMyList() // listOf(MyAndroidObject)
            .groupBy { myAndroidObject ->
                myAndroidObject.versionName
            } // map <String, List<MyAndroidObject>>
            .forEach {
                listOfResult.add(
                    ItemUi.Header(
                        title = it.key,// versionName
                    )
                )
                listOfResult.addAll(
                    it.value // List of android version number for the given name

                )
                listOfResult.add(
                    ItemUi.Footer(
                        number = it.value.size
                    )
                )
            }


        items(
            count = listOfResult.size,
        ) {
            when (val currentItem = listOfResult[it]) {
                is ItemUi.Header -> Text(
                    text = "Name = ${currentItem.title}"
                )


                is MyAndroidObject -> Text(
                    text = "Number ${currentItem.versionNumber}"
                )

                is ItemUi.Footer -> Text(
                    text = "${currentItem.number} total items"
                )
            }
        }
    }

}

sealed interface ItemUi {


    data class MyAndroidObject(
        val versionName: String,
        val versionNumber: String,
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

    data class Footer(
        val number: Int,
    ) : ItemUi
}


private fun populateMyList(): List<MyAndroidObject> {
    return listOf<MyAndroidObject>(
        MyAndroidObject(versionName = "HoneyComb", versionNumber = "3.0"),
        MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0"),
        MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.1"),
        MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.2"),
        MyAndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.3"),
        MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.1"),
        MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.2"),
        MyAndroidObject(versionName = "Jelly Bean", versionNumber = "4.3"),
        MyAndroidObject(versionName = "Kitkat", versionNumber = "4.4"),
        MyAndroidObject(versionName = "Lollipop", versionNumber = "5.0"),
        MyAndroidObject(versionName = "Lollipop", versionNumber = "5.1"),
        MyAndroidObject(versionName = "Marshmallow", versionNumber = "6.0"),
        MyAndroidObject(versionName = "Nougat", versionNumber = "7.0"),
        MyAndroidObject(versionName = "Oreo", versionNumber = "8.0"),
        MyAndroidObject(versionName = "Oreo", versionNumber = "8.1"),
    )
}

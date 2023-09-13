package fr.upjv.monprojetkotlin.data.repository

import fr.upjv.monprojetkotlin.data.model.AndroidObject
import fr.upjv.monprojetkotlin.ui.model.ItemUi

class AndroidVersionRepository {

    fun providerListOfAndroidObject(): List<AndroidObject> {
        return listOf(
            AndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0"),
            AndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.1"),
            AndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.2"),
            AndroidObject(versionName = "Ice Cream Sandwich", versionNumber = "4.0.3"),
            AndroidObject(versionName = "Jelly Bean", versionNumber = "4.1"),
            AndroidObject(versionName = "Jelly Bean", versionNumber = "4.2"),
            AndroidObject(versionName = "Jelly Bean", versionNumber = "4.3"),
            AndroidObject(versionName = "Kitkat", versionNumber = "4.4"),
            AndroidObject(versionName = "Lollipop", versionNumber = "5.0"),
            AndroidObject(versionName = "Lollipop", versionNumber = "5.1"),
            AndroidObject(versionName = "Marshmallow", versionNumber = "6.0"),
            AndroidObject(versionName = "Nougat", versionNumber = "7.0"),
            AndroidObject(versionName = "Oreo", versionNumber = "8.0"),
            AndroidObject(versionName = "Oreo", versionNumber = "8.1"),
        )
    }
}

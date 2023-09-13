package fr.upjv.monprojetkotlin.ui.model

import fr.upjv.monprojetkotlin.data.model.AndroidObject

sealed interface ItemUi {


    data class Item(
        val versionNumber: String,
    ) : ItemUi

    data class Header(
        val title: String,
    ) : ItemUi

    data class Footer(
        val number: Int,
    ) : ItemUi
}

fun List<AndroidObject>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            versionNumber = currentAndroidObject.versionNumber,
        )
    }
}
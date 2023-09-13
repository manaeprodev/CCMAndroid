package fr.upjv.monprojetkotlin.ui.model

import fr.upjv.monprojetkotlin.data.model.ChuckNorrisObject

data class ChuckItemUi(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisObject>.toUi() : List<ChuckItemUi> {
    return map { item ->
        ChuckItemUi(
            quote = item.title,
            iconUrl = item.url,
        )
    }
}

package fr.upjv.monprojetkotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.monprojetkotlin.data.repository.AndroidVersionRepository
import fr.upjv.monprojetkotlin.ui.model.ItemUi
import fr.upjv.monprojetkotlin.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel() {


    // Variable mutable en privée signifie que personne peut modifier le contenu à part le ViewModel
// lui même. C'est un pattern important à respecter
    private val _androidVersionList = MutableStateFlow<List<ItemUi>>(emptyList())
    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val androidVersionList: StateFlow<List<ItemUi>> get() = _androidVersionList.asStateFlow()

    // Instance du repository
    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // On execute dans un petit thread dedié à Input/Output le fait de génèrer la liste
            _androidVersionList.emit(populateMyList())
        }
    }

    private fun populateMyList(): List<ItemUi> {
        val result = mutableListOf<ItemUi>()
        androidVersionRepository.providerListOfAndroidObject().groupBy { myAndroidObject ->
            myAndroidObject.versionName
        } // map <String, List<MyAndroidObject>>
            .forEach {
                result.add(
                    ItemUi.Header(
                        title = it.key,// versionName
                    )
                )
                result.addAll(it.value.toUi()) // List of android version number for the given name
                result.add(
                    ItemUi.Footer(
                        number = it.value.size
                    )
                )
            }
        return result
    }


}

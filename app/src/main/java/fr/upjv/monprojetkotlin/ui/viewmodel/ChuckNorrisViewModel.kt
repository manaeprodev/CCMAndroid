package fr.upjv.monprojetkotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.monprojetkotlin.data.repository.ChuckNorrisQuoteRepository
import fr.upjv.monprojetkotlin.ui.model.ChuckItemUi
import fr.upjv.monprojetkotlin.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {
    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    private val _quotes: Flow<List<ChuckItemUi>>
    get() = chuckNorrisQuoteRepository.selectAll().map { list ->
        list.toUi()
    }
    val quote = _quotes
    fun insertNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.fetchData()
        }
    }
    fun deleteAllQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.deleteAll()
        }
    }
}

package fr.upjv.monprojetkotlin.data.repository

import fr.upjv.monprojetkotlin.architecture.CustomApplication
import fr.upjv.monprojetkotlin.architecture.RetrofitBuilder
import fr.upjv.monprojetkotlin.data.model.ChuckNorrisObject
import fr.upjv.monprojetkotlin.data.model.toDomain
import fr.upjv.monprojetkotlin.data.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.ChuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toDomain()
        }
    }
}

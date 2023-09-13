package fr.upjv.monprojetkotlin.data.remote

import fr.upjv.monprojetkotlin.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {


    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}

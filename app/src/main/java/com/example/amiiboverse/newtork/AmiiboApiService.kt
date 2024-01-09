package com.example.amiiboverse.newtork

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://amiiboapi.com/api/"

//Moshi object that retrofit will be using to parse JSON
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit object with moshi converter with my moshi object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AmiiboApiService {

    @GET("amiibo/")
    suspend fun getAmiibos(): Amiibos
}

//public api object that expose the retrofit service
object AmiiboApi {
    val retrofitService: AmiiboApiService by lazy { retrofit.create(AmiiboApiService::class.java) }
}
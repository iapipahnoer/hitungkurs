package org.d3if2095.hitungkurs.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if2095.hitungkurs.model.Kurs
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "iqbalapipahnoer/hitungkurs/master/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface KursApiService {
    @GET("kurs.json")
    suspend fun getKurs(): List<Kurs>
}
object KursApi {
    val service: KursApiService by lazy {
        retrofit.create(KursApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
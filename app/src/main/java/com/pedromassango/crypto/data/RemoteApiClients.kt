package com.pedromassango.crypto.data

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

object RemoteApiClients{

    private val coroutineAdapter = CoroutineCallAdapterFactory()
    private val gsonConverter = GsonConverterFactory.create(GsonBuilder()
        .setLenient()
        .create())
    private val okHttClient = OkHttpClient.Builder()
        .readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .build()

    /**
     * Builder to access the [https://blockchain.info/] info
     */
     private val blockchainBuilder = Retrofit.Builder()
         .baseUrl("https://blockchain.info/")
         .addConverterFactory(gsonConverter)
         .addCallAdapterFactory(coroutineAdapter)
         .client(okHttClient)
         .build()

    /**
     * Builder to access the [https://marketdata.wavesplatform.com/] info
     */
    private val marketDataBuilder = Retrofit.Builder()
         .baseUrl("https://marketdata.wavesplatform.com/api/")
         .addConverterFactory(gsonConverter)
         .addCallAdapterFactory(coroutineAdapter)
         .client(okHttClient)
         .build()

    /**
     * Builder to access the [https://marketdata.wavesplatform.com/] info
     */
    private val marketNodeBuilder = Retrofit.Builder()
         .baseUrl("https://nodes.wavesplatform.com")
         .addConverterFactory(gsonConverter)
         .addCallAdapterFactory(coroutineAdapter)
         .client(okHttClient)
         .build()

    val blockchainService = blockchainBuilder.create(BlockchainService::class.java)
    val marketDataService = marketDataBuilder.create(MarketDataService::class.java)
    val marketNodeService = marketNodeBuilder.create(MarketNodeService::class.java)
}

/**
 * Interface to access the [https://blockchain.info/] services
 */
interface BlockchainService{

    /**
     * Convert any giving currency to Bitcoin
     *
     * @param currency the currency's name to convert to bitcoin
     * @param valueToConvert the value to convert
     */
    @POST("tobtc")
    fun exchangeToBtc(
        @Query("currency") currency: String,
        @Query("value") valueToConvert: String
    ): Deferred<Response<Double>>

    /**
     * Get the bitcoin state info
     * TODO: getting: com.google.gson.JsonSyntaxException:
     * TODO: java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
     */
    @Headers("Content-Type: application/json")
    @GET("stats")
    fun blockchainStats(): Deferred<Response<BlockchainStats>>
}

/**
 * Interface to access the [https://marketdata.wavesplatform.com/] services
 */
interface MarketDataService{

    /**
     * Get all symbols
     */
    @GET("symbols")
    fun getSymbols(): Deferred<Response<List<Symbol>>>
}

/**
 * Interface to access the not services
 */
interface MarketNodeService{

    /**
     * Get symbol details by assetId
     *
     * @param assetId the id to load details from
     */
    @GET("assets/details/{assetId}")
    fun getDetailsByAssetId(assetId: String): Deferred<Response<Symbol>>
}
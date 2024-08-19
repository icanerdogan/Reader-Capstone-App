package com.ibrahimcanerdogan.readercapstoneapp.data.network

import com.ibrahimcanerdogan.readercapstoneapp.data.model.Book
import com.ibrahimcanerdogan.readercapstoneapp.data.model.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface APIService {

    @GET("volumes")
    suspend fun getAllBooks(@Query("q") query: String): Book

    @GET("volumes/{bookId}")
    suspend fun getBookInfo(@Path("bookId") bookId: String): Item


}
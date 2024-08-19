package com.ibrahimcanerdogan.readercapstoneapp.dependencyinjection

import com.google.firebase.firestore.FirebaseFirestore
import com.ibrahimcanerdogan.readercapstoneapp.data.network.APIService
import com.ibrahimcanerdogan.readercapstoneapp.domain.repository.FireRepository
import com.ibrahimcanerdogan.readercapstoneapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideFireBookRepository() = FireRepository(
        queryBook = FirebaseFirestore.getInstance().collection("books")
    )

    @Singleton
    @Provides
    fun provideBookApi(): APIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

}
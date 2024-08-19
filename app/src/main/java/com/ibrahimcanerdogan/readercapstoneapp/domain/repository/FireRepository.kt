package com.ibrahimcanerdogan.readercapstoneapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.ibrahimcanerdogan.readercapstoneapp.data.model.MBook
import com.ibrahimcanerdogan.readercapstoneapp.util.SourceState
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireRepository @Inject constructor(
    private val queryBook: Query
) {
    suspend fun getAllBooksFromDatabase(): SourceState<List<MBook>, Boolean, Exception> {
        val dataOrException = SourceState<List<MBook>, Boolean, Exception>()

        try {
            dataOrException.stateLoading = true
            dataOrException.stateData =  queryBook.get().await().documents.map { documentSnapshot ->
                documentSnapshot.toObject(MBook::class.java)!!
            }
            if (!dataOrException.stateData.isNullOrEmpty()) dataOrException.stateLoading = false


        }catch (exception: FirebaseFirestoreException){
            dataOrException.stateException = exception
        }
        return dataOrException

    }
}
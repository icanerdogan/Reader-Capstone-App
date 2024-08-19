package com.ibrahimcanerdogan.readercapstoneapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.ibrahimcanerdogan.readercapstoneapp.data.model.Item
import com.ibrahimcanerdogan.readercapstoneapp.domain.repository.BookRepository
import com.ibrahimcanerdogan.readercapstoneapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel(){
    suspend fun getBookInfo(bookId: String): Resource<Item> {
        return repository.getBookInfo(bookId)
    }
}
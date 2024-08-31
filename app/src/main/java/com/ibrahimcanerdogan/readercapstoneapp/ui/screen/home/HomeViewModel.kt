package com.ibrahimcanerdogan.readercapstoneapp.ui.screen.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.readercapstoneapp.data.model.MBook
import com.ibrahimcanerdogan.readercapstoneapp.domain.repository.FireRepository
import com.ibrahimcanerdogan.readercapstoneapp.util.SourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FireRepository
): ViewModel() {
    val data: MutableState<SourceState<List<MBook>, Boolean, Exception>> = mutableStateOf(
        SourceState(listOf(), true,Exception(""))
    )

    init {
        getAllBooksFromDatabase()
    }

    private fun getAllBooksFromDatabase() {
        viewModelScope.launch {
            data.value.stateLoading = true
            data.value = repository.getAllBooksFromDatabase()
            if (!data.value.stateData.isNullOrEmpty()) data.value.stateLoading = false
        }
        Log.d("GET", "getAllBooksFromDatabase: ${data.value.stateData?.toList().toString()}")
    }


}
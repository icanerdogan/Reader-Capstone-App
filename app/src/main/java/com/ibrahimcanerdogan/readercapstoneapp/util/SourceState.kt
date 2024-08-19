package com.ibrahimcanerdogan.readercapstoneapp.util

data class SourceState<T, Boolean, E : Exception?>(
    var stateData: T? = null,
    var stateLoading: Boolean? = null,
    var stateException: E? = null
)
package uz.davron.exammvvmm.core.util

data class ResultWrapper<S>(
    val data :S? = null,
    val error:String? = null
)
package uz.davron.exammvvmm.core.repository


import uz.davron.exammvvmm.core.model.now.FilmsNowPlayingResponse
import uz.davron.exammvvmm.core.model.popular.FilmsPopularResponse
import uz.davron.exammvvmm.core.network.ApiClient
import uz.davron.exammvvmm.core.util.API_KEY
import uz.davron.exammvvmm.core.util.ResultWrapper


class FilmsRepository {

    private val serviceNow = ApiClient.getFilmsNowPlaying()
    private val servicePopular = ApiClient.getFilmsNowPlaying()

    suspend fun getNowFilms(): ResultWrapper<FilmsNowPlayingResponse> {

        val response = serviceNow.getNowPlaying(API_KEY)

        if (response.isSuccessful){
            response.body()?.let { return ResultWrapper(it) }
        }

        return ResultWrapper(error = "Error")
    }


    suspend fun getPopularFilms(): ResultWrapper<FilmsPopularResponse> {
        val response = servicePopular.getPopular(API_KEY)

        if (response.isSuccessful){
            response.body()?.let { return ResultWrapper(it) }
        }
        return ResultWrapper(error = "Error")
    }

}
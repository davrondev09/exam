package uz.davron.exammvvmm.core.network.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.davron.exammvvmm.core.model.now.FilmsNowPlayingResponse
import uz.davron.exammvvmm.core.model.popular.FilmsPopularResponse

interface ProjectService {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") apiKey:String) :Response<FilmsNowPlayingResponse>

    @GET("/3/movie/popular")
    suspend fun getPopular(@Query("api_key") apiKey:String) :Response<FilmsPopularResponse>

}
package uz.davron.exammvvmm.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.davron.exammvvmm.core.network.service.ProjectService

object ApiClient {

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFilmsNowPlaying(): ProjectService {
        return createRetrofit().create(ProjectService::class.java)
    }

}
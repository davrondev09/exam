package uz.davron.exammvvmm.ui.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.davron.exammvvmm.core.model.now.FilmsNowPlayingResponse
import uz.davron.exammvvmm.core.model.popular.FilmsPopularResponse
import uz.davron.exammvvmm.core.repository.FilmsRepository

class HomeScreenVM : ViewModel() {

    private val repository = FilmsRepository()

    val filmsNowLiveData: MutableLiveData<FilmsNowPlayingResponse?> = MutableLiveData()
    val filmsPopularLiveData: MutableLiveData<FilmsPopularResponse?> = MutableLiveData()
    val errorLiveData: MutableLiveData<String?> = MutableLiveData()

    fun getFilmsData() {

        viewModelScope.launch {
            val resultNow = repository.getNowFilms()
            val resultPopular = repository.getPopularFilms()

            if (resultNow != null) {
                filmsNowLiveData.value = resultNow.data!!
            } else {
                errorLiveData.value = resultNow.error
            }
            if (resultPopular!= null){
                filmsPopularLiveData.value = resultPopular.data!!
            }
        }

    }

}
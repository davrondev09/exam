package uz.davron.exammvvmm.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.davron.exammvvmm.R
import uz.davron.exammvvmm.core.adapter.MultiAdapter
import uz.davron.exammvvmm.core.model.base.BaseModel
import uz.davron.exammvvmm.databinding.ScreenHomeBinding
import uz.davron.exammvvmm.ui.home.vm.HomeScreenVM


class HomeScreen : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val homeVM: HomeScreenVM by viewModels()
    private val multiData = ArrayList<BaseModel>()
    private var one = false
    private var two = false
    private val adapter by lazy { MultiAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeVM.getFilmsData()
        observer()
        setAdapter()

    }

    private fun setAdapter() {
        multiData.clear()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun observer() {

        homeVM.filmsNowLiveData.observe(requireActivity()) {
            multiData.add(it!!)
            one = true
            if (one && two){
                this.adapter.setData(multiData)
            }
        }
        homeVM.filmsPopularLiveData.observe(requireActivity()){
            multiData.add(it!!)
            two = true
            if (one && two){
                this.adapter.setData(multiData)
            }
        }




    }


}
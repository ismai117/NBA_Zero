package com.nbastats.nba_zero.playerviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbastats.nba_zero.model.PlayerProfileModel
import com.nbastats.nba_zero.network.ApiClient
import com.nbastats.nba_zero.network.PlayerService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {
    val apiHost = "nba-player-individual-stats.p.rapidapi.com";
    val apiKey = "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5";



    lateinit var mutablelivedata: MutableLiveData<PlayerProfileModel>


    init {
        mutablelivedata = MutableLiveData()
    }


    fun getMutableLiveData(): MutableLiveData<PlayerProfileModel> {
        return mutablelivedata
    }



     fun makeApiCall(){

       viewModelScope.launch (Dispatchers.IO){


           val retrofitInstance = ApiClient.RetrofitInstance().create(PlayerService::class.java)
           val response = retrofitInstance.playerProfile(host = apiHost, key = apiKey, name = "lebron_james")
           mutablelivedata.postValue(response)

       }

    }

}

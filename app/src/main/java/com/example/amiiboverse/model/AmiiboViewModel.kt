package com.example.amiiboverse.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amiiboverse.newtork.AmiiboApi
import com.example.amiiboverse.newtork.Amiibos
import com.example.amiiboverse.newtork.Character
import kotlinx.coroutines.launch
import java.lang.Exception

enum class AmiiboApiStatus{LOADING,ERROR, DONE}

class AmiiboViewModel: ViewModel() {
    private val _status = MutableLiveData<AmiiboApiStatus>()
    val status: LiveData<AmiiboApiStatus> = _status

    private val _amiibos = MutableLiveData<Amiibos>()
    val amiibos: LiveData<Amiibos> = _amiibos

    private val _amiibo = MutableLiveData<Character>()
    val amiibo: LiveData<Character> = _amiibo

    init {
        getAmiibosList()
    }

    private fun getAmiibosList() {
        viewModelScope.launch {
            _status.value = AmiiboApiStatus.LOADING
            try {
                _status.value = AmiiboApiStatus.DONE
                _amiibos.value = AmiiboApi.retrofitService.getAmiibos()
            } catch (e: Exception) {
                _status.value = AmiiboApiStatus.ERROR
                Log.e("TAG", "Excepcion: ${e.message}")
            }
        }
    }

    fun onAmiiboClicked(character: Character) {
        _amiibo.value = character
    }
}
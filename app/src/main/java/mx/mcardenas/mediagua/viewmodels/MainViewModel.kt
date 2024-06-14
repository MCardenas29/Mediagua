package mx.mcardenas.mediagua.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.mcardenas.mediagua.MediaguaDatabase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var database: MediaguaDatabase
) : ViewModel() {
    lateinit var userQuantity: LiveData<Int>;

    init {
        viewModelScope.launch {
            userQuantity = database.userDao().countUsers()
        }
    }
}
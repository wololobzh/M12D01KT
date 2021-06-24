package fr.eni.randomchuck.random_joke

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fr.eni.randomchuck.model.Joke
import fr.eni.randomchuck.network.ChuckApi
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom

class RandomjokeViewModel(application: Application): AndroidViewModel(application)
{
    val joke = MutableLiveData<Joke>()
    val status = MutableLiveData<String>()

    fun randomPersonne() {

        viewModelScope.launch {
            try {
                var result = ChuckApi.retrofitService.randomFact()
                status.value = "OK"
                joke.value = result
            } catch (e: Exception) {
                status.value = "KO : ${e.message}"
            }
        }
    }
}
package fr.eni.randomchuck.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.eni.randomchuck.random_joke.RandomjokeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {


    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomjokeViewModel::class.java)) {
            return RandomjokeViewModel(
                application
            ) as T
        }
        throw IllegalArgumentException("ViewModel inconnu")
    }
}
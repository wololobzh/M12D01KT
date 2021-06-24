package fr.eni.randomchuck.random_joke

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import fr.eni.randomchuck.R
import fr.eni.randomchuck.databinding.FragmentRandomJokeBinding
import fr.eni.randomchuck.model.Joke
import fr.eni.randomchuck.network.ChuckService
import fr.eni.randomchuck.network.ChuckService.Companion.retrofit
import fr.eni.randomchuck.utils.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomJokeFragment : Fragment() {

    private lateinit var binding: FragmentRandomJokeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_random_joke,container,false)

        val application = requireNotNull(this.activity).application

        val randomjokeViewModel = ViewModelProvider(this, ViewModelFactory(application)).get(RandomjokeViewModel::class.java)

        binding.randomJokeViewModel = randomjokeViewModel

        binding.setLifecycleOwner (this)

        return binding.root
    }
}
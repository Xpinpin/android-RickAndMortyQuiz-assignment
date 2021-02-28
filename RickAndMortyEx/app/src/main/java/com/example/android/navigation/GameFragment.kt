
package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding : FragmentGameBinding

    private lateinit var viewModel : GameViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_game,
                container,
                false
        )

        Log.i("GameFragment", "called ViewModelProvider")

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner



        return binding.root
    }


}

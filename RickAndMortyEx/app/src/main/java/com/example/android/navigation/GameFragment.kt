
package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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


        // Observer for the Game finished event
        viewModel.eventGameFinished.observe(viewLifecycleOwner, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })


        return binding.root
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {


        binding.nextButton.setOnClickListener{view : View ->

            view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
        setHasOptionsMenu(true)

        viewModel.onGameFinishComplete()
    }

}


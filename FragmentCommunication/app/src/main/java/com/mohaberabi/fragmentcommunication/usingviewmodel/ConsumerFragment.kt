package com.mohaberabi.fragmentcommunication.usingviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mohaberabi.fragmentcommunication.databinding.FragmentConsumerBinding
import kotlinx.coroutines.launch

class ConsumerFragment : Fragment() {


    private val sharedViewModel by activityViewModels<SharedViewModel>()
    private lateinit var binding: FragmentConsumerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConsumerBinding.inflate(
            inflater,
            container,
            false,
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.state.collect {
                binding.textViewName.text = it.name
                binding.textViewEmail.text = it.email
            }
        }
        binding.button.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}
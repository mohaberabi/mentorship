package com.mohaberabi.fragmentcommunication.usingviewmodel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mohaberabi.fragmentcommunication.R
import com.mohaberabi.fragmentcommunication.databinding.FragmentProducerBinding
import com.mohaberabi.fragmentcommunication.usingactivity.ThemeChangerActivity
import kotlinx.coroutines.launch

class ProducerFragment : Fragment() {


    private lateinit var binding: FragmentProducerBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProducerBinding.inflate(
            inflater,
            container,
            false,
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.state.collect {
                binding.editText1.clearAndSet(it.name)
                binding.editText2.clearAndSet(it.email)

            }
        }

    }


    private fun initViews() {
        with(binding) {
            editText1.addTextChangedListener {
                sharedViewModel.onAction(
                    SharedActions.NameChanged(
                        it.toString()
                    )
                )
            }
            editText2.addTextChangedListener {
                sharedViewModel.onAction(
                    SharedActions.EmailChanged(
                        it.toString()
                    )
                )
            }
            buttonNavigate.setOnClickListener {
                findNavController().navigate(R.id.action_producerFragment_to_consumerFragment)

            }
            activityLauncher.setOnClickListener {
                Intent(
                    context, ThemeChangerActivity::class.java,
                ).also {
                    startActivity(it)
                }
            }
        }


    }


}

private fun EditText.clearAndSet(value: String) {
    if (text.toString() != value) {
        setText(value)
    }
}
package com.mohaberabi.fragmentcommunication.usingactivity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohaberabi.fragmentcommunication.R
import com.mohaberabi.fragmentcommunication.databinding.FragmentThemeChangerBinding


class ThemeChangerFragment : Fragment() {

    private lateinit var themeChangerAction: ThemeChangerAction
    private lateinit var binding: FragmentThemeChangerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeChangerBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_themeChangerFragment_to_themeShowerFragment)

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        themeChangerAction = context as ThemeChangerAction
    }

    fun changeTheme(isDark: Boolean) {
        themeChangerAction.changeTheme(isDark)
        binding.checkbox.isChecked = isDark
    }

}
package com.mohaberabi.fragmentcommunication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohaberabi.fragmentcommunication.databinding.FragmentThemeShowerBinding
import com.mohaberabi.fragmentcommunication.usingactivity.ThemeChangerAction


class ThemeShowerFragment : Fragment() {

    private lateinit var themeChangerAction: ThemeChangerAction

    private lateinit var binding: FragmentThemeShowerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentThemeShowerBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        themeChangerAction = context as ThemeChangerAction
    }


    fun setTheme(isDark: Boolean) {
        themeChangerAction.changeTheme(isDark)
        binding.checkbox.isChecked = isDark
    }

}
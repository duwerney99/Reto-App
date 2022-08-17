package com.example.movies.presentation.authentication.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.movies.databinding.FragmentLoginBinding
import com.example.movies.domain.model.UserModel
import com.example.movies.presentation.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.userData.observe(this, Observer(::getUserValid))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            viewModel.loginUser(

                binding.iEditexU.text.toString(),
                binding.iEditextP.text.toString()
            )
        }
        binding.tvRegistro.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistroFragment()
            findNavController().navigate(action)
        }
    }

    private fun getUserValid(user: UserModel) {
        if (user.user.isNotEmpty()) {
            val intent = Intent(context, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(context, "No existe el usuario", Toast.LENGTH_LONG).show()
        }
    }
}

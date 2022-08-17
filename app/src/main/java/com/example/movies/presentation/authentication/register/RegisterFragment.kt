package com.example.movies.presentation.authentication.register

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        registerViewModel.userInfo.observe(this, Observer(::insertUser))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.ivToolbar.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertUser()

    }

    private fun insertUser() {
        binding.btnAccept.setOnClickListener {
            val replyIntent = Intent()
            if (binding.iEditexU.text.toString().isNotEmpty() && !TextUtils.isEmpty(binding.iEditextE.text) &&
                !TextUtils.isEmpty(binding.iEditextP.text)){
                registerViewModel.insertUser(UserEntity(0, binding.iEditexU.text.toString(),
                    binding.iEditextE.text.toString(), binding.iEditextP.text.toString()))
                activity?.onBackPressed()
            }
            println("Process finish")
        }
    }
}
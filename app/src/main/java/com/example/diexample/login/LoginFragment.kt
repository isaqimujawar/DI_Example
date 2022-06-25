package com.example.diexample.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.diexample.R
import com.example.diexample.databinding.FragmentLoginBinding
import com.example.diexample.login.model.IUserRepository
import com.example.diexample.login.model.UserRepository
import com.example.diexample.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var viewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    //@Inject lateinit var viewModel: LoginViewModel
    @Inject lateinit var userRepository: IUserRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setUserRepository(userRepository)      // Field Injection (or Setter Injection)
        viewModel.saveUser("Dwayne Johnson", "therock@gmail.com")

        binding.tvGreet.text = viewModel.getGreetings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.diexample.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diexample.R
import com.example.diexample.databinding.FragmentLoginBinding
import com.example.diexample.login.model.LoginRetrofitService
import com.example.diexample.login.model.UserLocalDataSource
import com.example.diexample.login.model.UserRemoteDataSource
import com.example.diexample.login.model.UserRepository
import com.example.diexample.login.viewmodel.LoginViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)

        // First, create retrofit which is the dependency of UserRemoteDataSource
        val retrofit = LoginRetrofitService()

        // Then, satisfy the dependencies of UserRepository
        val localDataSource = UserLocalDataSource()
        val remoteDataSource = UserRemoteDataSource(retrofit)

        // Now you can create an instance of UserRepository that LoginViewModel needs
        val userRepository = UserRepository(localDataSource, remoteDataSource)

        // Lastly, create an instance of LoginViewModel with userRepository
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setUserRepository(userRepository)
        binding.tvGreet.text = viewModel.getGreetings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
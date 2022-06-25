package com.example.diexample.login

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diexample.MyApplication
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

        // Get the AppContainer instance from the Application
        val appContainer = (activity?.application as MyApplication).appContainer

        // Lastly, create an instance of LoginViewModel with userRepository
        viewModel = ViewModelProvider(this).get(LoginViewModel(appContainer.userRepository)::class.java)
        //viewModel.setUserRepository(appContainer.userRepository)      // Field Injection (or Setter Injection)
        binding.tvGreet.text = viewModel.getGreetings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
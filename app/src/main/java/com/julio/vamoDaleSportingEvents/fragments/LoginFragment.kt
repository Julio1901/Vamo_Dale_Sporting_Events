package com.julio.vamoDaleSportingEvents.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.julio.vamoDaleSportingEvents.databinding.FragmentLoginBinding

//TODO: Check in OnStartActivity if user is already authenticated
//TODO: Check why google account info has null
class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val POSITIVE_RESPONSE_SIGN_IN_REQUEST = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root




        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonEnter : Button = binding.btnEnter
        val buttonSignInWithGoogleAccount : Button = binding.btnLoginWithGoogle

        val googleSignInOptions  = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val googleSignClient = GoogleSignIn.getClient(this.requireActivity(), googleSignInOptions)
        val signInIntent = googleSignClient.signInIntent



        buttonEnter.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginToHome()
            findNavController().navigate(action)

        }

        buttonSignInWithGoogleAccount.setOnClickListener {
            startActivityForResult(signInIntent, POSITIVE_RESPONSE_SIGN_IN_REQUEST)
        }




    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this.requireActivity())

        //updateUI()


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == POSITIVE_RESPONSE_SIGN_IN_REQUEST){

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            //testResult(task)

            val action = LoginFragmentDirections.actionLoginToHome()
            findNavController().navigate(action)

        }


    }


    fun testResult (completedTask : Task<GoogleSignInAccount> ){

        val account = completedTask.getResult(ApiException::class.java)

        val test = account.displayName

        if (test != null){

            Log.e("test account" , test)
        }else{
            Log.e("test account", "está nullo")

        }



    }

}
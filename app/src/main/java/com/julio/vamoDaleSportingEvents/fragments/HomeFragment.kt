package com.julio.vamoDaleSportingEvents.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.julio.vamoDaleSportingEvents.R


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSignOut : Button = view.findViewById(R.id.btn_sign_out)


        btnSignOut.setOnClickListener {

        signOut()
            val action = HomeFragmentDirections.actionHomeToLoginScreen()
            findNavController().navigate(action)
        }



    }


    private fun signOut(){

        val googleSignInOptions  = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val googleSignClient = GoogleSignIn.getClient(this.requireActivity(), googleSignInOptions)
        googleSignClient.signOut()


    }

}
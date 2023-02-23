package com.example.sweetrock

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sweetrock.databinding.FragmentSignInBinding

class SignIn : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.signupBtn?.setOnClickListener { view ->
            val username = binding.editTextTextPersonName.editText?.text.toString()
            val password = binding.editTextTextPassword.editText?.text.toString()

            val regexText = Regex("^[a-zA-Z0-9_-]{3,12}\$")
            val regexPassword =
                Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_.])(?=\\S+\$).{8,}\$")


            if (username.matches(regexText) && password.matches(regexPassword) && username != "" && password != "") {
                Toast.makeText(context, "You have signed up!", Toast.LENGTH_SHORT).show()
                _binding?.signupBtn?.text = "Signed in as $username"
                _binding?.editTextTextPersonName?.editText?.isEnabled = false
                _binding?.editTextTextPassword?.editText?.isEnabled = false
            } else {
                val builderError = AlertDialog.Builder(context)

                // Set the message show for the Alert time
                builderError.setMessage(getString(R.string.error_body))

                // Set Alert Title
                builderError.setTitle("Error!")

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builderError.setCancelable(false)

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builderError.setPositiveButton("Okay") { dialog, which ->
                    run { dialog.cancel() }
                }
                builderError.create().show()
            }
        }
    }

}
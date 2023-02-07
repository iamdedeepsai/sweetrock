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
        _binding?.signupBtn?.setOnClickListener { view ->
            val builder = AlertDialog.Builder(context)

            // Set the message show for the Alert time
            builder.setMessage("Do you want to exit ?")

            // Set Alert Title
            builder.setTitle("Alert !")

            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(false)

            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setPositiveButton("Sign up!") {
                // When the user click yes button then app will close
                    dialog, which ->
                run {
                    Toast.makeText(context, "You have signed up!", Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                }
            }

            // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setNegativeButton("Cancel") {
                // If user click no then dialog box is canceled.
                    dialog, which ->
                run {
                    Toast.makeText(context, "Cancelled sign up", Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                }
            }

            // Create the Alert dialog
            val alertDialog = builder.create()
            // Show the Alert Dialog box
            alertDialog.show()
        }

        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

}
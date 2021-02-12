package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class UserFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonStart = view.findViewById<Button>(R.id.btnStart)
        buttonStart.setOnClickListener {
            val player1 = view.findViewById<EditText>(R.id.etPlayer1).text.toString()
            val player2 = view.findViewById<EditText>(R.id.etPlayer2).text.toString()
            if (player1.isBlank() || player2.isBlank()) {
                Toast.makeText(context, "Empty Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Log.d("Hey", "$player1   $player2")
            val action = UserFragmentDirections.actionUserFragmentToGameFragment(player1, player2)
            findNavController().navigate(action)
        }
    }
}
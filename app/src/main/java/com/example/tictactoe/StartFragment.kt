package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonStart = view.findViewById<Button>(R.id.btnStart)
        buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_userFragment)
        }

        val buttonRecords = view.findViewById<Button>(R.id.btnRecords)
        buttonRecords.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_recordsFragment)
        }
    }
}
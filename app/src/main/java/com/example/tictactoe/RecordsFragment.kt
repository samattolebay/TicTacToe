package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class RecordsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_records, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = RecordsAdapter(Repository.getPlayers())
        val records = view.findViewById<RecyclerView>(R.id.rvRecords)
        records.adapter = adapter

        val buttonMain = view.findViewById<Button>(R.id.btnMain)
        buttonMain.setOnClickListener {
            findNavController().navigate(RecordsFragmentDirections.actionRecordsFragmentToStartFragment())
        }
    }

}
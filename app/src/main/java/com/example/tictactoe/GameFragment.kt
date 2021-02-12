package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class GameFragment : Fragment() {
    private val game = Game()
    private var turn = true // true - first player's turn, false - second player's turn
    private val args: GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonRecords = view.findViewById<Button>(R.id.btnRecords)
        buttonRecords.visibility = View.GONE
        buttonRecords.setOnClickListener {
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToRecordsFragment())
        }

        val textPlayers = view.findViewById<TextView>(R.id.tvPlayers)
        textPlayers.text = "${args.player1} VS ${args.player2}"

        val box1 = view.findViewById<Box>(R.id.view1)
        box1.setOnClickListener {
            if (setImage(0)) {
                box1.findViewById<ImageView>(R.id.image1).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box2 = view.findViewById<Box>(R.id.view2)
        box2.setOnClickListener {
            if (setImage(1)) {
                box2.findViewById<ImageView>(R.id.image2).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box3 = view.findViewById<Box>(R.id.view3)
        box3.setOnClickListener {
            if (setImage(2)) {
                box3.findViewById<ImageView>(R.id.image3).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box4 = view.findViewById<Box>(R.id.view4)
        box4.setOnClickListener {
            if (setImage(3)) {
                box4.findViewById<ImageView>(R.id.image4).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box5 = view.findViewById<Box>(R.id.view5)
        box5.setOnClickListener {
            if (setImage(4)) {
                box5.findViewById<ImageView>(R.id.image5).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box6 = view.findViewById<Box>(R.id.view6)
        box6.setOnClickListener {
            if (setImage(5)) {
                box6.findViewById<ImageView>(R.id.image6).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box7 = view.findViewById<Box>(R.id.view7)
        box7.setOnClickListener {
            if (setImage(6)) {
                box7.findViewById<ImageView>(R.id.image7).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box8 = view.findViewById<Box>(R.id.view8)
        box8.setOnClickListener {
            if (setImage(7)) {
                box8.findViewById<ImageView>(R.id.image8).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
        val box9 = view.findViewById<Box>(R.id.view9)
        box9.setOnClickListener {
            if (setImage(8)) {
                box9.findViewById<ImageView>(R.id.image9).apply {
                    if (turn) setImageResource(R.drawable.ic_cross) else setImageResource(R.drawable.ic_zero)
                }
                Log.d("Hey", "Here")
                checkGame()
            }
        }
    }

    private fun checkGame() {
        turn = !turn
        if (game.isFinished()) {
            Toast.makeText(
                context,
                "Player ${if (game.winner == 1) args.player1 else args.player2} win",
                Toast.LENGTH_SHORT
            ).show()
            val winningCells = game.getWinningCells()
            Log.d("Hey", "${winningCells[0]}  ${winningCells[1]}  ${winningCells[2]}")
            val id1 = view?.resources?.getIdentifier(
                "view" + winningCells[0],
                "id",
                "com.example.tictactoe"
            )
            val id2 = view?.resources?.getIdentifier(
                "view" + winningCells[1],
                "id",
                "com.example.tictactoe"
            )
            val id3 = view?.resources?.getIdentifier(
                "view" + winningCells[2],
                "id",
                "com.example.tictactoe"
            )
            val v1 = id1?.let { view?.findViewById<Box>(it) }
            view?.resources?.let {
                v1?.setBackgroundColor(it.getColor(R.color.teal_200))
            }
            val v2 = id2?.let { view?.findViewById<Box>(it) }
            view?.resources?.let {
                v2?.setBackgroundColor(it.getColor(R.color.teal_200))
            }
            val v3 = id3?.let { view?.findViewById<Box>(it) }
            view?.resources?.let {
                v3?.setBackgroundColor(it.getColor(R.color.teal_200))
            }
            Repository.updatePlayerStatistics(args.player1, game.winner == 1)
            Repository.updatePlayerStatistics(args.player2, game.winner == 2)
            view?.findViewById<Button>(R.id.btnRecords)!!.visibility = View.VISIBLE
        }
    }

    private fun setImage(i: Int): Boolean {
        Log.d("Hey", "Setting $i and $turn")
        return game.setBox(i, turn)
    }


}
package com.example.tictactoe

import android.util.Log

class Game {
    private val board = arrayOf(
        arrayOf(10, 20, 30),
        arrayOf(40, 50, 60),
        arrayOf(70, 80, 90)
    )
    private val winningCells = mutableListOf(0, 0, 0)
    var winner = 0

    fun setBox(i: Int, turn: Boolean): Boolean {
        if (winner != 0) return false
        val x = i / 3
        val y = i % 3
        return if (board[x][y] >= 10) {
            board[x][y] = if (turn) 1 else 2
            Log.d("Hey", "Position $x, $y is now $turn")
            true
        } else false
    }

    fun isFinished(): Boolean {
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            winner = board[0][0]
            winningCells[0] = 1
            winningCells[1] = 2
            winningCells[2] = 3
        }
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            winner = board[1][0]
            winningCells[0] = 4
            winningCells[1] = 5
            winningCells[2] = 6
        }
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            winner = board[2][0]
            winningCells[0] = 7
            winningCells[1] = 8
            winningCells[2] = 9
        }
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            winner = board[0][0]
            winningCells[0] = 1
            winningCells[1] = 4
            winningCells[2] = 7
        }
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            winner = board[0][1]
            winningCells[0] = 2
            winningCells[1] = 5
            winningCells[2] = 8
        }
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            winner = board[0][2]
            winningCells[0] = 3
            winningCells[1] = 6
            winningCells[2] = 9
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0]
            winningCells[0] = 1
            winningCells[1] = 5
            winningCells[2] = 9
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2]
            winningCells[0] = 3
            winningCells[1] = 5
            winningCells[2] = 7
        }
        return winner != 0
    }

    fun getWinningCells(): List<Int> = winningCells
}

package com.example.tictactoe

object Repository {
    private val records = mutableMapOf(
        "Samat" to Player("Samat", 4, 2),
        "Ayan" to Player("Ayan", 0, 6),
        "Dimaw" to Player("Dimaw", 5, 1)
    )

    fun getPlayers() = records.values.toList()
    fun updatePlayerStatistics(name: String, win: Boolean) {
        if (!records.containsKey(name)) {
            records[name] = Player(name, 0, 0)
        }
        if (win) {
            records[name]?.win = (records[name]?.win ?: 0) + 1
        } else {
            records[name]?.lose = (records[name]?.lose ?: 0) + 1
        }
    }
}
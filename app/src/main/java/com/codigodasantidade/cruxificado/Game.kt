package com.codigodasantidade.cruxificado

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Classe que será responsavel pelo jogo.
class Game : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

    }

}
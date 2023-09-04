package com.codigodasantidade.crucificado

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.codigodasantidade.cruxificado.R

class MainActivity : Activity() {

    private lateinit var _Jesus: Button
    private lateinit var _Maria: Button
    private lateinit var _Santos: Button
    private lateinit var _Santas: Button
    private lateinit var _Santidade: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando os botões
        _Jesus = findViewById(R.id.jesus)
        _Maria = findViewById(R.id.maria)
        _Santos = findViewById(R.id.santos)
        _Santas = findViewById(R.id.santas)
        _Santidade = findViewById(R.id.comunidade)


    }

    override fun onStart() {
        super.onStart()

        // Inicializando um Intent para mudar de tela.
        val intent = Intent(this, Game::class.java)
        _Jesus.setOnClickListener{

            intent.putExtra("tema", "Jesus")
            startActivity(intent)
        }
        _Maria.setOnClickListener {
            intent.putExtra("tema", "Maria")
            startActivity(intent)
        }
        _Santos.setOnClickListener {
            intent.putExtra("tema", "Santos")
            startActivity(intent)
        }
        _Santas.setOnClickListener {
            intent.putExtra("tema", "Santas")
            startActivity(intent)
        }

        val intent_2 = Intent(this, CodigoSantidade::class.java)

        _Santidade.setOnClickListener {

            startActivity(intent_2)
        }
    }


}
package com.codigodasantidade.crucificado

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.codigodasantidade.cruxificado.R

class Game : Activity() {

    private var palavraParaAdivinhar = "OLA"
    private var palavraAdivinhada = CharArray(palavraParaAdivinhar.length)
    private var tentativas = 6

    private lateinit var palavraTextView: TextView
    private lateinit var tentativasTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        palavraTextView = findViewById(R.id.palavraTextView)
        tentativasTextView = findViewById(R.id.tentativasTextView)

        // Inicialize palavraAdivinhada com underscores
        for (i in palavraParaAdivinhar.indices) {
            palavraAdivinhada[i] = '_'
        }

        atualizarExibicaoPalavra()

        // Lidar com cliques nos botões (A-Z)
        for (i in 'A'..'Z') {
            val idBotao = resources.getIdentifier("botao_$i", "id", packageName)
            val botao = findViewById<Button>(idBotao)
            botao.setOnClickListener {
                lidarComAdivinhacao(i)
            }
        }
    }

    private fun lidarComAdivinhacao(letra: Char) {
        if (tentativas > 0) {
            var adivinhacaoCorreta = false

            for (i in palavraParaAdivinhar.indices) {
                if (palavraParaAdivinhar[i] == letra) {
                    palavraAdivinhada[i] = letra
                    adivinhacaoCorreta = true
                }
            }

            if (!adivinhacaoCorreta) {
                tentativas--
            }

            atualizarExibicaoPalavra()
            atualizarExibicaoTentativas()

            if (String(palavraAdivinhada) == palavraParaAdivinhar) {
                // Jogador vence
                // Implemente a lógica de vitória aqui
            } else if (tentativas == 0) {
                // Jogador perde
                // Implemente a lógica de derrota aqui
            }
        }
    }

    private fun atualizarExibicaoPalavra() {
        palavraTextView.text = palavraAdivinhada.joinToString(" ")
    }

    private fun atualizarExibicaoTentativas() {
        tentativasTextView.text = "Tentativas Restantes: $tentativas"
    }
}

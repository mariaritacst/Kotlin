package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    //Define o layout da nossa página
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
        //Cria a variável e atribui um valor a ela
            val i = intent
        //Cria uma intent que provavelmente será usada para iniciar um pedido
            val j = Intent(this,PedidoActivity::class.java)
            j.putExtras(i)
        //Inicia a atividade PedidoActivity
            startActivity(j)
        },2000)

    }
}

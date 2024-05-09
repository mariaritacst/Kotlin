package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//Tela principal do aplicativo do restaurante
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
//Mostra o layout na tela principal
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//Define a variável
        val username = intent.extras?.getString("username")

//Cria a condição SE, que irá dar olá para o usuário
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }
//Vai fechar o aplicativo quando clicarmos no botão
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

//Marca ou desmarca a seleção do cliente dos itens do menu
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

//Quando a gente marca ele mostra o valor e a quantidade de itens selecionados
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}

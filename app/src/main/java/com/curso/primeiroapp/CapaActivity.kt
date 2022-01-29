package com.curso.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        val btn: Button = findViewById(R.id.capa_btnVoltar)

        btn.setOnClickListener{
            finish()
        }
    }
}
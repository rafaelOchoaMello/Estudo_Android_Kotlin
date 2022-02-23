package com.curso.primeiroapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        val btnSave: Button = findViewById(R.id.btnSharedSaveName)
        val editName: EditText = findViewById(R.id.sharedEditNome)
        val result: TextView = findViewById(R.id.sharedTextResultado)
        val SHARED_PREF: String = "SharedPreference"

        val preferences: SharedPreferences =
            getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

        //Verifica se já o conteúdo desejado no sharedPreferences
        if(preferences.contains("name")){
            result.text = preferences.getString("name", "NO NAME FOUND")
        }

        btnSave.setOnClickListener {
            if (editName.text.toString().isNotEmpty()) {
                val editor: SharedPreferences.Editor = preferences.edit()
                val tempName = editName.text.toString()

                editor.putString("name", tempName)
                editor.commit()

                result.text = tempName
            }
        }


    }
}
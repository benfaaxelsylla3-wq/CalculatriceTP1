package com.example.calculatricetp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération des composants de l'interface
        val nombre1 = findViewById<EditText>(R.id.nombre1)
        val nombre2 = findViewById<EditText>(R.id.nombre2)
        val resultat = findViewById<TextView>(R.id.txtResultat)

        val addition = findViewById<Button>(R.id.btnAddition)
        val soustraction = findViewById<Button>(R.id.btnSoustraction)
        val multiplication = findViewById<Button>(R.id.btnMultiplication)
        val division = findViewById<Button>(R.id.btnDivision)
        val puissance = findViewById<Button>(R.id.btnPuissance)

        // Fonction de calcul
        fun calculer(operation: String) {
            val a = nombre1.text.toString().toDoubleOrNull()
            val b = nombre2.text.toString().toDoubleOrNull()

            if (a == null || b == null) {
                Toast.makeText(
                    this,
                    "Veuillez saisir deux nombres valides",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            if (operation == "/" && b == 0.0) {
                Toast.makeText(
                    this,
                    "Erreur : division par zéro",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val valeur = when (operation) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> a / b
                "^" -> Math.pow(a, b)
                else -> return
            }

            resultat.text = "Résultat : $valeur"
        }

        // Écouteurs des quatre boutons
        addition.setOnClickListener {
            calculer("+")
        }

        soustraction.setOnClickListener {
            calculer("-")
        }

        multiplication.setOnClickListener {
            calculer("*")
        }

        division.setOnClickListener {
            calculer("/")
        }

        puissance.setOnClickListener {
            calculer("^")
        }
    }
}
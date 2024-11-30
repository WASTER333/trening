package com.example.trening3

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private val listaTreningow = mutableListOf<Trening>()
    private lateinit var adapter: TreningAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TreningAdapter(listaTreningow)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val editDystans = findViewById<EditText>(R.id.editDystans)
        val editCzas = findViewById<EditText>(R.id.editCzas)
        val editKalorie = findViewById<EditText>(R.id.editKalorie)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val buttonDodaj = findViewById<Button>(R.id.buttonDodaj)

        buttonDodaj.setOnClickListener {
            val rodzaj = when (radioGroup.checkedRadioButtonId) {
                R.id.radioSpacer -> "Spacer"
                R.id.radioBieg -> "Bieg"
                R.id.radioTreningSilowy -> "Trening siłowy"
                else -> "Nieznany"
            }
            val dystans = editDystans.text.toString().toFloatOrNull() ?: 0f
            val czas = editCzas.text.toString().toIntOrNull() ?: 0
            val kalorie = editKalorie.text.toString().toIntOrNull() ?: 0
            val intensywnosc = when (seekBar.progress) {
                in 0..3 -> "Niska"
                in 4..7 -> "Średnia"
                else -> "Wysoka"
            }

            val trening = Trening(rodzaj, dystans, czas, kalorie, intensywnosc)
            listaTreningow.add(trening)
            adapter.notifyDataSetChanged()
        }
    }


}

package com.example.atelier2part2


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val buttonPopup: Button = findViewById(R.id.button_popup)
        buttonPopup.setOnClickListener {
            showPopupMenu(it)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showPopupMenu(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.popup_menu, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.option1 -> {
                    Toast.makeText(this, "Option 1 sélectionnée", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option2 -> {
                    Toast.makeText(this, "Option 2 sélectionnée", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> {
                Toast.makeText(this, "Recherche sélectionnée", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_exit -> {
                Toast.makeText(this, "Quitter sélectionné", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_rouge -> {
                findViewById<View>(android.R.id.content).setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
                Toast.makeText(this, "Couleur Rouge sélectionnée", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_bleu -> {
                // Change la couleur de fond en bleu
                findViewById<View>(android.R.id.content).setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark))
                Toast.makeText(this, "Couleur Bleu sélectionnée", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}

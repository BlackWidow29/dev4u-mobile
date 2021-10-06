package br.com.dev4u

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*


class SegundaActivity: AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {


                override fun onQueryTextChange(newText: String): Boolean {

                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {

                    return false
                }

            })
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        when{
            id == R.id.action_buscar -> Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()
            id == R.id.action_atualizar -> Toast.makeText(context, "Botão de atualizar", Toast.LENGTH_LONG).show()
            id == R.id.action_config -> Toast.makeText(context, "Botão de configurações", Toast.LENGTH_LONG).show()
            id == R.id.action_adicionar -> {
                var itent = Intent (this, CadastroActivity::class.java)
                startActivity(itent)
            }
            id == android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

}
package com.example.intentclase

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentclase.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Llamar a BOTON EN activity_main RENOMBRADO COMO btnLlamar
        binding.btnDial.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"))
            startActivity(intent)
        }

        binding.btnWeb.setOnClickListener{
            val webIntent = Intent(Intent.ACTION_WEB_SEARCH)
            webIntent.putExtra(SearchManager.QUERY,"android")
            startActivity(webIntent)
        }
        binding.btnView.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")))
        }

        binding.btnActivityResult.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent,0)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0){
            when(resultCode){
                RESULT_OK ->
                    Toast.makeText(this,"Ha pulsado Ok",Toast.LENGTH_LONG).show()
                RESULT_CANCELED ->
                    Snackbar.make(binding.root,"Ha cancelado", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
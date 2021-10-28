package com.example.intentclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentclase.databinding.ActivityMain2Binding
import com.example.intentclase.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener{
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.btnCancel.setOnClickListener{
            setResult(RESULT_CANCELED,intent)
            finish()
        }
    }
}
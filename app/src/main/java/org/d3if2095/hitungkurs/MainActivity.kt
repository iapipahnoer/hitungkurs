package org.d3if2095.hitungkurs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if2095.hitungkurs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungKurs() }
    }
    private fun hitungKurs() {
        val berat = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(berat)) {
            Toast.makeText(this, R.string.nilaikurs_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val kurs = berat.toFloat() * 14300;
        binding.textView4.setText("Hasil Nilai Kurs  : Rp." + kurs);
    }
}
package org.d3if2095.hitungkurs.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3if2095.hitungkurs.R
import org.d3if2095.hitungkurs.databinding.FragmentHitungBinding

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { hitungKurs() }
        binding.infoButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_infoFragment
            )
        }

    }

    private fun hitungKurs() {
        val jumlah = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(jumlah)) {
            Toast.makeText(context, R.string.nilaikurs_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val kurs = jumlah.toFloat() * 14300;
        binding.textView4.setText("Hasil Nilai Kurs  : Rp." + kurs);
        binding.infoButton.visibility = View.VISIBLE
    }
}
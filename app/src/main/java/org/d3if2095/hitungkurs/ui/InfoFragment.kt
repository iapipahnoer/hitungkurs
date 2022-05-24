package org.d3if2095.hitungkurs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if2095.hitungkurs.R
import org.d3if2095.hitungkurs.databinding.FragmentInfokursBinding

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfokursBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentInfokursBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView.setImageResource(R.drawable.info)
        binding.textView.text = getString(R.string.infokurs)
    }
}
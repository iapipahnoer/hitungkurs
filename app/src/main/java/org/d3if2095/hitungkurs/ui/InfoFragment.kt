package org.d3if2095.hitungkurs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
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
        val imgUrl = "https://raw.githubusercontent.com/iqbalapipahnoer/hitungkurs/master/static-api/infokurs.png"
        getActivity()?.let {
            Glide.with(it)
                .load(imgUrl)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.imageView)
        }
        binding.textView.text = getString(R.string.infokurs)
    }
}
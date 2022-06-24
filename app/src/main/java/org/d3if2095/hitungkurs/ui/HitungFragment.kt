package org.d3if2095.hitungkurs.ui

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import org.d3if2095.hitungkurs.MainActivity
import org.d3if2095.hitungkurs.R
import org.d3if2095.hitungkurs.databinding.FragmentHitungBinding
import org.d3if2095.hitungkurs.network.UpdateWorker
import java.util.concurrent.TimeUnit

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { hitungKurs() }
        binding.infoButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_infoFragment
            )
        }
        binding.shareButton.setOnClickListener { shareData() }

        scheduleUpdater(requireActivity().application)

    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,binding.editTextNumber.text)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            MainActivity.CHANNEL_ID,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hitungKurs() {
        val jumlah = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(jumlah)) {
            Toast.makeText(context, R.string.nilaikurs_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val kurs = jumlah.toFloat() * 14300;
        binding.textView4.setText("Hasil Nilai Kurs  : Rp." + kurs);
        binding.buttonGroup.visibility = View.VISIBLE
    }
}
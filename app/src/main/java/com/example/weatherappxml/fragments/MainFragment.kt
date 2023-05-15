package com.example.weatherappxml.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.example.weatherappxml.R
import com.example.weatherappxml.adapters.VpAdapter
import com.example.weatherappxml.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Логика переключеня часы/день
    private fun init() = with(binding){
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        val tList = listOf(getString(R.string.hours), getString(R.string.days))
        TabLayoutMediator(tabLayout, vp){
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    // Вывод диалога на разрешение о включение гео
    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission(){
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION))
            permissionListener()
        pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}

package com.example.mykotlinapplication.features

import android.content.Context
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.FragmentCalculateBinding
import com.example.mykotlinapplication.features.calculate.CalculateContract
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), CalculateContract.View {

//    @Inject
//    internal lateinit var presenter: CalculateContract.Presenter

    @VisibleForTesting
    internal lateinit var binding: FragmentCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

   override fun setResult(input: String) {
        binding.results.text = input
    }

    override fun clearResult(input: String) {
        binding.results.text = input
        binding.workings.text = input
    }

    override fun setWorkings(input: String) {
        binding.workings.text = input
    }
}



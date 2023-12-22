package com.example.mykotlinapplication.features

import android.content.Intent
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.FragmentCalculateBinding
import com.example.mykotlinapplication.databinding.FragmentSplashBinding
import com.example.mykotlinapplication.features.calculate.CalculateContract
import com.example.mykotlinapplication.features.splash.SplashContract
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity(), SplashContract.View {

    @VisibleForTesting
    internal lateinit var binding: FragmentSplashBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
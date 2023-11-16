package com.example.mykotlinapplication.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.calculate.CalculateContract
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity(), CalculateContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}



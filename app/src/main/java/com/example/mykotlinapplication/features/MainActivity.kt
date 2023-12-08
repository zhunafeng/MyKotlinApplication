package com.example.mykotlinapplication.features

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




//class MainActivity : AppCompatActivity(), CalculateContract.View {
//    //    @Inject
////    internal lateinit var presenter: CalculateContract.Presenter
//
//    @VisibleForTesting
//    internal lateinit var binding: FragmentCalculateBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    override fun setResult(input: String) {
//        binding.results.text = input
//    }
//
//    override fun clearResult(input: String) {
//        binding.results.text = input
//        binding.workings.text = input
//    }
//
//    override fun setWorkings(input: String) {
//        binding.workings.text = input
//    }
//
//    override fun setWorkingsBack(input: String) {
//        binding.workings.text = input
//    }
//
//    override fun setWorkingsDec(input: String) {
//        binding.workings.text = "$input."
//    }
//}

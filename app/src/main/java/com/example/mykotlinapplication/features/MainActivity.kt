package com.example.mykotlinapplication.features

import android.os.Bundle
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.calculate.CalculateContract
import dagger.android.AndroidInjection

class MainActivity : BaseActivity(), CalculateContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}

//package com.example.mykotlinapplication
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import com.example.mykotlinapplication.databinding.ActivityMainBinding
//
//var result: String = ""
//class MainActivity : AppCompatActivity()  {
//
//    private lateinit var binding: ActivityMainBinding
//    private var canAddOperation = false
//    private var canAddDecimal = true
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        supportActionBar?.hide()
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        /*
//        view binding removes the need for findViewById() and assigning to a variable
//        to access the buttons. Instead we can access directly through binding. Removes most
//        of the code from before.
//         */
//
//    }
//    fun numberAction(view: View) {
//        if (view is Button) { if (view.text == ".") {
//            if(canAddDecimal) {
//                binding.workings.append(view.text)
//                canAddDecimal = false
//            }
//
//        }
//        else
//            binding.workings.append(view.text)
//            canAddOperation = true
//
//        }
//
//    }
//    fun operationAction(view: View) {
//        if (view is Button && canAddOperation) {
//            binding.workings.append(view.text)
//            canAddOperation = false
//            canAddDecimal = true
//
//
//        }
//    }
//    fun allClearAction(view: View) {
//        binding.workings.text = ""
//        binding.results.text = ""
//    }
//    fun backSpaceAction(view: View) {
//        val length = binding.workings.length()
//        if (length > 0) {
//            binding.workings.text = binding.workings.text.subSequence(0, length - 1)
//        }
//    }
//    fun equalsAction(view: View) {
//        binding.results.text = calculateResults()
//    }
//
//    private fun calculateResults(): String {
//        val digitsOperators = digitsOperators()
//        if (digitsOperators.isEmpty()) return ""
//
//        val timesDivision = timesDivisionCalculate(digitsOperators)
//        if (timesDivision.isEmpty()) return ""
//
//        val result = addSubtractCalculate(timesDivision)
//
//        return result.toString()
//    }
//
//    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
//        var result = passedList[0] as Float
//        for (i in passedList.indices) {
//            if (passedList[i] is Char && i != passedList.lastIndex) {
//                val operator = passedList[i]
//                val nextDigit = passedList[i + 1] as Float
//
//                if (operator == '+')
//                    result += nextDigit
//                if (operator == '-')
//                    result -= nextDigit
//            }
//        }
//
//        return result
//
//    }
//
//    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
//        var list = passedList
//        while (list.contains('x') || list.contains('/')) {
//            list = calculateTimesDiv(list)
//        }
//        return list
//    }
//
//    private fun calculateTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
//        val newList = mutableListOf<Any>()
//        var restartIndex = passedList.size
//
//        for (i in passedList.indices) {
//            if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {
//                val operator = passedList[i]
//                val prevDigit = passedList[i - 1] as Float
//                val nextDigit = passedList[i + 1] as Float
//                when(operator) {
//                    'x' -> {
//                        newList.add(prevDigit * nextDigit)
//                        restartIndex = i + 1
//                    }
//                    '/' -> {
//                        newList.add(prevDigit / nextDigit)
//                        restartIndex = i + 1
//                    }
//                    else -> {
//                        newList.add(prevDigit)
//                        newList.add(operator)
//                    }
//                }
//            }
//            if (i > restartIndex) {
//                newList.add(passedList[i])
//            }
//        }
//        return newList
//    }
//
//    private fun digitsOperators(): MutableList<Any> {
//        val list = mutableListOf<Any>()
//        var currentDigit = ""
//
//        for (character in binding.workings.text) {
//            if (character.isDigit() || character == '.') {
//                currentDigit += character
//            }
//            else {
//                list.add(currentDigit.toFloat())
//                currentDigit = ""
//                list.add(character)
//            }
//        }
//        if (currentDigit != "") {
//            list.add(currentDigit.toFloat())
//
//        }
//        return list
//    }
//}



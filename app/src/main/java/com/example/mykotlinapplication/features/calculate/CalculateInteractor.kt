package com.example.mykotlinapplication.features.calculate

import android.os.Bundle
import com.example.mykotlinapplication.base.ObjectDelegate
import com.example.mykotlinapplication.utils.transformerToFloat
import javax.inject.Inject

/**
 * Calculate VIPER Interactor Implementation
 */
class CalculateInteractor
    @Inject
    constructor() : CalculateContract.InteractorInput {
        internal val outputDelegate = ObjectDelegate<CalculateContract.InteractorOutput>()
        internal val output by outputDelegate

        private var canAddDecimal = true
        private var canAddOperation = false
        private var canAddNumber = false

        // region viper lifecycle

        override fun attachOutput(output: CalculateContract.InteractorOutput) {
            outputDelegate.attach(output)
        }

        override fun detachOutput() {
            // coroutineScope.cancelJobs()
            outputDelegate.detach()
        }

        override fun loadData(savedState: Bundle?) {
            // TODO implement this. Call output with results of a data load or load existing state
        }

        override fun savePendingState(outState: Bundle) {
            // TODO save interactor state to bundle and output success if required
        }

        override fun calculateResult(input: String) {
            output.loadDataResult(calculateResults(input))
        }

        override fun backSpaceAction(input: String) {
            var backResult = input
            val length = input.length
            if (length > 0) {
                var result = input.subSequence(0, length - 1).toString()
                output.loadDataBackSpaced(result)
            }
        }

        override fun numberToInput(input: String) {
            output.loadDataWorkings(input)
            canAddOperation = true
        }

        override fun operationToInput(input: String) {
            if (canAddOperation) {
                output.loadDataWorkings(input)
                canAddOperation = false
                canAddDecimal = true
            }
        }

        override fun addDecimal(input: String) {
            if (canAddDecimal) {
                output.loadDecimalWorkings(input)
                canAddDecimal = false
            }
            if (input == "") {
                output.loadDecimalWorkings(input)
                canAddDecimal = false
            }
        }

        override fun clearResult(input: String) {
            output.clearDataResult(allClearAction(input))
        }

        private fun calculateResults(input: String): String {
            val digitsOperators = digitsOperators(input)
            if (digitsOperators.isEmpty()) return ""

            val timesDivision = timesDivisionCalculate(digitsOperators)
            if (timesDivision.isEmpty()) return ""

            val result = addSubtractCalculate(timesDivision)

            return result.toString()
        }

        private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
            var result = passedList[0] as Float
            for (i in passedList.indices) {
                if (passedList[i] is Char && i != passedList.lastIndex) {
                    val operator = passedList[i]
                    val nextDigit = passedList[i + 1] as Float

                    if (operator == '+') {
                        result += nextDigit
                    }
                    if (operator == '-') {
                        result -= nextDigit
                    }
                }
            }

            return result
        }

        private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
            var list = passedList
            while (list.contains('x') || list.contains('/')) {
                list = calculateTimesDiv(list)
            }
            return list
        }

        private fun calculateTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
            val newList = mutableListOf<Any>()
            var restartIndex = passedList.size

            for (i in passedList.indices) {
                if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {
                    val operator = passedList[i]
                    val prevDigit = passedList[i - 1] as Float
                    val nextDigit = passedList[i + 1] as Float
                    when (operator) {
                        'x' -> {
                            newList.add(prevDigit * nextDigit)
                            restartIndex = i + 1
                        }

                        '/' -> {
                            newList.add(prevDigit / nextDigit)
                            restartIndex = i + 1
                        }

                        else -> {
                            newList.add(prevDigit)
                            newList.add(operator)
                        }
                    }
                }
                if (i > restartIndex) {
                    newList.add(passedList[i])
                }
            }
            return newList
        }

        private fun digitsOperators(input: String): MutableList<Any> {
            val list = mutableListOf<Any>()
            var currentDigit = ""

            for (character in input) {
                if (character.isDigit() || character == '.') {
                    currentDigit += character
                } else {
                    list.add(currentDigit.transformerToFloat())
                    currentDigit = ""
                    list.add(character)
                }
            }
            if (currentDigit != "") {
                list.add(currentDigit.transformerToFloat())
            }
            return list
        }

        private fun allClearAction(input: String): String {
            var clearResult = input
            clearResult = ""

            return clearResult
        }
    }

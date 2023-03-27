package com.john_halaka.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonPlus = findViewById<Button>(R.id.button_plus)
        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)


        val buttonEquals = findViewById<Button>(R.id.button_equals)
        val buttonDecimal = findViewById<Button>(R.id.button_decimal)
        val buttonDeleteLast = findViewById<Button>(R.id.button_delete_last)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        var hasDecimal = false

        val textViewResult = findViewById<TextView>(R.id.text_view_result)
        textViewResult.text = ""
        val editText = findViewById<EditText>(R.id.edit_text)

        fun onNumberClick(view: View) {
            if (view is Button)
                editText.append(view.text)
        }

        fun onOperationClick(view: View) {
            if (view is Button) {
                if (editText.text.isNotEmpty()) {
                    val lastChar = editText.text.last()
                    if (lastChar.isDigit()) {
                        editText.append(view.text)
                        hasDecimal = false
                    } else {
                        Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        button0.setOnClickListener(::onNumberClick)
        button1.setOnClickListener(::onNumberClick)
        button2.setOnClickListener(::onNumberClick)
        button3.setOnClickListener(::onNumberClick)
        button4.setOnClickListener(::onNumberClick)
        button5.setOnClickListener(::onNumberClick)
        button6.setOnClickListener(::onNumberClick)
        button7.setOnClickListener(::onNumberClick)
        button8.setOnClickListener(::onNumberClick)
        button9.setOnClickListener(::onNumberClick)
        buttonPlus.setOnClickListener(::onOperationClick)
        buttonMinus.setOnClickListener(::onOperationClick)
        buttonMultiply.setOnClickListener(::onOperationClick)
        buttonDivide.setOnClickListener(::onOperationClick)

        buttonEquals.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                val lastChar = editText.text.last()
                if (lastChar.isDigit()) {
                    val result = ExpressionBuilder(editText.text.toString()).build().evaluate()
                    val formattedResult = DecimalFormat("#.##########").format(result)
                    textViewResult.text = formattedResult
                    hasDecimal = if (formattedResult.contains('.')) {
                        editText.setText(formattedResult)
                        true
                    } else {
                        editText.setText(formattedResult)
                        false
                    }
                } else {
                    Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                }
            }
        }
        buttonDecimal.setOnClickListener {
           if (!hasDecimal)
            editText.append(".")
            hasDecimal = true
        }

        buttonDeleteLast.setOnClickListener {
            val text = editText.text.toString()
            if (text.isNotEmpty())
                editText.setText(text.dropLast(1))
        }
        buttonClear.setOnClickListener {
            editText.text.clear()
            textViewResult.text=""
            hasDecimal = false
        }
    }
}
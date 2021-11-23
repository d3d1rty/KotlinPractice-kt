// Richard Davis
// CSCI 4010
// Assignment 2

package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRunCode.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        binding.textviewOutput.setText("")
        // for (i in 1..100) {
        //  binding.textviewOutput.append("${i}\n")
        // }
        displayJoke()

        displayName("Richard Davis")
        displayName("Bad Bunny")

        macAndCheese(-4, 6)
        macAndCheese(2, 3)
    }

    fun displayJoke() {
        var badjoke = """
            |BEST JOKE EVER
            |
            |Knock knock
            |Who's there?
            |Boo
            |Boo who?
            |Open up or I'll give you a reason to cry!
            |---------------------------------
        """.trimMargin()
        binding.textviewOutput.append(badjoke + "\n")
    }

    fun displayName(name: String) {
        var counter : Int = 0
        while (counter < name.length) {
            binding.textviewOutput.append(name.get(counter).toString() + "\n")
            counter++
        }
        binding.textviewOutput.append("---------------------------------\n")
    }

    fun macAndCheese(a : Int, b : Int) {
        if (a < 2 || b < 2) {
            binding.textviewOutput.append("WARNING: One or both arguments are less than 2\n")
            binding.textviewOutput.append("---------------------------------\n")
            return
        }

        for (i in 1..200) {
            if (i % a == 0 && i % b == 0) binding.textviewOutput.append("Mac and Cheese\n")
            else if (i % a == 0) binding.textviewOutput.append("Mac\n")
            else if (i % b == 0) binding.textviewOutput.append("Cheese\n")
            else binding.textviewOutput.append("${i}\n")
        }
    }
}
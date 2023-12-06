package com.example.dualdiceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitBtn: Button = findViewById(R.id.exit)
        val rollBtn: Button = findViewById(R.id.rollButton)

        rollBtn.setOnClickListener {

            val congText: TextView = findViewById(R.id.cong)

            if (rollDice1() == rollDice2()) {
                congText.text = "Congrats both dice have equal outcomes!"
            } else {
                congText.text = ""
            }
            val toastMsg = Toast.makeText(this, "Dices Rolled!", Toast.LENGTH_SHORT).show()

        }

        exitBtn.setOnClickListener {
            exitProcess(0)
            val toast = Toast.makeText(this, "Exiting Application!!", Toast.LENGTH_LONG)
        }

        rollDice1()
        rollDice2()
    }

    private fun rollDice2(): Int {
        val diceObj = Dice(6)
        val randomNum = diceObj.roll()

        val diceImage: ImageView = findViewById(R.id.diceImage1)

        when(randomNum){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        return randomNum
    }

    private fun rollDice1(): Int {
        val diceObj = Dice(6)
        val randomNum = diceObj.roll()

        val diceImage: ImageView = findViewById(R.id.diceImage2)

        when(randomNum){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        return randomNum
    }


}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageView
import java.util.*

const val EMPTY_DICE = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // execute layout on activity main

        // Create Button obj. Reference id# roll_btn
        val rollButton: Button = findViewById(R.id.roll_btn)

        // change text during execution
        rollButton.text = getString(R.string.text_letsRoll)

        // const ImageView that has reference to layout dice_image.
        // This var attribute will be alter for different displaying pursposes.
        // The id itself it const
        val diceImage: ImageView = findViewById(R.id.dice_image)

        // Image src initialize to empty dice
        setDiceImageViewResource(EMPTY_DICE, diceImage)

        // Event Listener
        // update the image base on the number return when the dice is roll.
        rollButton.setOnClickListener {
            setDiceImageViewResource( rollDice(), diceImage)
        }
    }

    // Function that returns an integer number one to size when the dice roll event is executed.
    private fun rollDice() : Int {
        // create ramdom int (1- 6)
        val randomInt : Int = Random().nextInt(6) + 1

        return randomInt
    }

    // Function that sets the image resource to the acceptable integer values
    // dicePos: 1- 6 set their respective dice_Pos anyhting elses return empty_dice
    private fun setDiceImageViewResource(dicePos : Int ,image : ImageView) {
        // Kotlin Switch statment// Kotlin Switch statment
        val drawableResource = when(dicePos) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        image.setImageResource(drawableResource)
    }
}

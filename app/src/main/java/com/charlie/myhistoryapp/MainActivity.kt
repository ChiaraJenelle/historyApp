package com.charlie.myhistoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton: Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //initialise
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultsTextView)


        searchButton.setOnClickListener {
            Log.d("MainActivity", "Search button clicked")
            //create a variable of age to get name from user
            val age = ageInput.text.toString().toIntOrNull()
            Log.d("MainActivity", "Age entered: $age")

            //if name is not null and age in the range between
            if (age != null && age in 20..100) {
                Log.d("MainActivity", "Age is valid")

                //when age 55 display King Henry The Eight else when is .. and so on
                val historicalFigure = when (age) {
                    55 -> "King Henry The Eight. Henry VIII was King of England from 22 April 1509 until his death in 1547. Henry is known for his six marriages and his efforts to have his first marriage annulled"
                    81 -> "Queen Victoria. Victoria was Queen of the United Kingdom of Great Britain and Ireland from 20 June 1837 until her death in 1901. Her reign of 63 years and 216 days, which was longer than those of any of her predecessors, is known as the Victorian era."
                    69 -> "Queen Elizabeth The First. Elizabeth I - the last Tudor monarch - was born at Greenwich on 7 September 1533, the daughter of Henry VIII and his second wife, Anne Boleyn. Her early life was full of uncertainties, and her chances of succeeding to the throne seemed very slight once her half-brother Edward was born in 1537."
                    49 -> "Queen Anne. Anne was Queen of Great Britain and Ireland following the ratification of the Acts of Union on 1 May 1707, which merged the kingdoms of Scotland and England. Before this, she was Queen of England, Scotland, and Ireland from 8 March 1702."
                    51 -> "Napoleon Bonaparte The Second. Napoleon Bonaparte, later known by his regnal name Napoleon I, was a French emperor and military commander who rose to prominence during the French Revolution and led successful campaigns during the Revolutionary Wars."
                    67 -> "Leonardo Da Vinci. Leonardo di ser Piero da Vinci was an Italian polymath of the High Renaissance who was active as a painter, draughtsman, engineer, scientist, theorist, sculptor, and architect."
                    77 -> "Galileo Galilei. Galileo di Vincenzo Bonaiuti de' Galilei, commonly referred to as Galileo Galilei or simply Galileo, was an Italian astronomer, physicist and engineer, sometimes described as a polymath. He was born in the city of Pisa, then part of the Duchy of Florence."
                    56 -> "Ludwig Van Beethoven. Ludwig van Beethoven was a German composer and pianist. He is one of the most revered figures in the history of Western music; his works rank among the most performed of the classical music repertoire and span the transition from the Classical period to the Romantic era in classical music."
                    54 -> "Christopher Columbus. Christopher Columbus was an Italian explorer and navigator from the Republic of Genoa who completed four Spanish-based voyages across the Atlantic Ocean sponsored by the Catholic Monarchs, opening the way for the widespread European exploration and European colonization of the Americas."
                    57 -> "Julius Caesar. Gaius Julius Caesar was a Roman general and statesman. A member of the First Triumvirate, Caesar led the Roman armies in the Gallic Wars before defeating his political rival Pompey in a civil war, and subsequently became dictator from 49 BC until his assassination in 44 BC."
                    else -> null
                }

                val message =
                    if (historicalFigure != null) "the historical figures name $historicalFigure."
                    else "no historical figure found with the entered age."
                resultTextView.text = message
            } else {
                Log.d("MainActivity", "Invalid age or format")
                resultTextView.text =
                    "invalid age or format. please enter whole number between the ages of 20 to 100"
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}



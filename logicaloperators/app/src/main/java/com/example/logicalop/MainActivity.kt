package com.example.logicalop

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //declare variables

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var cbStaff: CheckBox
    private lateinit var cbITStudent: CheckBox
    private lateinit var cbBanned: CheckBox
    private lateinit var btnCheck: Button
    private lateinit var tvResults: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //link the variables to the file UI  components using their ID's
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        cbStaff = findViewById(R.id.cbStaff)
        cbITStudent = findViewById(R.id.cbBanned)
        btnCheck = findViewById(R.id.btnCheck)
        tvResults = findViewById(R.id.tvResults)

        //button to run the code when it is pressed
        btnCheck.setOnClickListener {

            //get the user's name from the editText
            val name = edtName.text.toString()

            //convert the age entered into a number (int)
            val age = edtAge.text.toString().toInt()


            //check if checkboxes are selected (true or false)
            val IsITstudent = cbITStudent.isChecked
            val isStaff = cbStaff.isChecked
            val isBanned = cbBanned.isChecked

            if (((age >= 18 && IsITstudent) || isStaff) && !isBanned) {

                //if the condition above is true
                tvResults.text = "congratulations $name! You qualify for the student tech discount."
            } else {


                //if the condition above is false
                tvResults.text = "Sorry $name, you do not qualify for the discount"
            }

            /*
        logical condition explanation

            step 1:(age >= 18 && isItStudent)
            >= means greater than or equal to
            && means AND (both conditions must be true)

            so this checks if the user is 18 or older and is an IT student

            step 2:
            || means OR (only one condition needs to be true)

            This means the erson can qualify if they are a staff member even if they are not an IT student

            step 3: && !isBanned
            ! means NOT (it reverses the value)
            !isBanned means the person must NOT be banned

            Example
            isBanned = false
            !false = true
         */






            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
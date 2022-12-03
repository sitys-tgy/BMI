package com.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.tarc.bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //Module level variable
    //lateinit = late initialize
    //val = value vs var = variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate = display the UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Root = top of a tree structure -> Layout
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //Local variable
        binding.buttonReset.setOnClickListener{
            binding.textViewBMI.text = String.format("%s", getString(R.string.app_name))
            binding.imageViewBMI.setImageResource(R.drawable.empty)
            binding.editTextWeight.text.clear()
            binding.editTextHeight.text.clear()
        }

        binding.buttonCalculate.setOnClickListener {
            if(binding.editTextHeight.text.isEmpty()){
                binding.editTextHeight.setError(
                    getString(R.string.value_required))
                return@setOnClickListener
            }

            if(binding.editTextWeight.text.isEmpty()){
                binding.editTextHeight.setError(
                    getString(R.string.value_required))
                return@setOnClickListener
            }
            val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            val bmi = weight / (height/100).pow(2)
            if(bmi < 18.5){
               //Underweight
                //BMI: 18.20 (underweight)
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.underweight))
                binding.imageViewBMI.setImageResource(R.drawable.under)
            }

            else if(bmi in 18.5..24.9){
                //Normal
                //BMI: 18.20 (underweight)
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.normal))
                binding.imageViewBMI.setImageResource(R.drawable.normal)
            }

            else{
                //Overweight
                //BMI: 18.20 (underweight)
                binding.textViewBMI.text = String.format("%s:%.2f (%s)", getString(R.string.app_name), bmi, getString(R.string.overweight))
                binding.imageViewBMI.setImageResource(R.drawable.over)
            }
        }
    }
}

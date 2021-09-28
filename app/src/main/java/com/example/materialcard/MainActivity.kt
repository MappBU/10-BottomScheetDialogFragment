package com.example.materialcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.materialcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Тап по кнопке Play через интерфейс
        binding?.Button?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        val details = Details()

        val parameters = Bundle()

        // Передаю во фрагмент Техт вью из Маин активити разметки
        parameters.putString("tittleMovie", binding?.titleMovie?.text?.toString())
        parameters.putString("longMovie", binding?.longMovie?.text?.toString())
        parameters.putString("actorsMovie", binding?.actorsMovie?.text?.toString())

        details.arguments = parameters

        // Показывает Bottom Scheet Dialog Fragment
        details.show(supportFragmentManager, "details")

    }

}
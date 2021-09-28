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

        binding?.Button?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        val details = Details()

        val parameters = Bundle()

        parameters.putString("tittleMovie", binding?.titleMovie?.text?.toString())
        parameters.putString("longMovie", binding?.longMovie?.text?.toString())
        parameters.putString("actorsMovie", binding?.actorsMovie?.text?.toString())

        details.arguments = parameters

        details.show(supportFragmentManager, "details")

    }

}
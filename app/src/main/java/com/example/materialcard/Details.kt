package com.example.materialcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.materialcard.databinding.DetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Details : BottomSheetDialogFragment(), View.OnClickListener {

    private var binding: DetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.details, container, false)

        binding?.titleMovieDetails?.text = arguments?.getString("tittleMovie").toString()
        binding?.longMovieDetails?.text = arguments?.getString("longMovie").toString()
        binding?.actorsMovieDetails?.text = arguments?.getString("actorsMovie").toString()

        when(binding?.titleMovieDetails?.text){
            getString(R.string.badBoys) -> binding?.imageMovieDetails?.setImageResource(R.drawable.bad_boys_pic)
        }

        binding?.exitIcon?.setOnClickListener(this)

        return binding?.root
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.exitIcon -> dismiss()
        }
    }


}

package com.example.materialcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.materialcard.databinding.DetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// Наследуемся от BottomSheetDialogFragment (Чтоб понимал как рисуем разметку)
class Details : BottomSheetDialogFragment(), View.OnClickListener {

    private var binding: DetailsBinding? = null

    // Стандартный метод Фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.details, container, false)

        // Принимаем Переданные с Активити данные во фрагмент
        binding?.titleMovieDetails?.text = arguments?.getString("tittleMovie").toString()
        binding?.longMovieDetails?.text = arguments?.getString("longMovie").toString()
        binding?.actorsMovieDetails?.text = arguments?.getString("actorsMovie").toString()

        // Если во фрагменте титут фильм, то подгружаем нужную картинку
        when(binding?.titleMovieDetails?.text){
            getString(R.string.badBoys) -> binding?.imageMovieDetails?.setImageResource(R.drawable.bad_boys_pic)
        }

        // Кнопка закрытия
        binding?.exitIcon?.setOnClickListener(this)

        // Стандартный метод стандартного фрагмента Активити
        return binding?.root
    }

    // Реализуем кнопку выхода
    // dismiss() - закрывает Боттом Сшит
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.exitIcon -> dismiss()
        }
    }


}

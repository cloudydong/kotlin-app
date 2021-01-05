package com.example.kotlinapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var option = -1
    private lateinit var navController: NavController
    private var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?:-1
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.btnHome.setOnClickListener(this)
        setResult(option)
    }

    private fun setResult(option: Int) {
        when(option) {
            1 ->{
                binding.textView.text = "1. Learn Tensorflow"
                binding.imageView.text = "Then you can become a Business Analyst, Data Engineer or Data System Developer, Data Analyst, Data Scientist"
            }
            2 ->{
                binding.textView.text = "2. Learn Android App"
                binding.imageView.text = "Then you can become a Android Developer"
            }
            3 ->{
                binding.textView.text = "3. Learn Golang"
                binding.imageView.text = "Then you can become a Backend Server Developer"
            }
            4 ->{
                binding.textView.text = "4. Learn Spring WebSever"
                binding.imageView.text = "Then you can become a Backend Server Developer"
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_home -> {
                navController.navigate(R.id.action_resultFragment_to_mainFragment)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
package com.gezioteam.gezio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class HomeFragment : Fragment() {

    private var isFavorite = false
    private var isFavorite1 = false
    private var isFavorite2 = false
    private var isFavorite3 = false
    private var isFavorite4 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val favs = view.findViewById<CheckBox>(R.id.imageView15)
        favs.setOnClickListener {
            isFavorite = !isFavorite

            val toastMessage = if (isFavorite) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        val favs1 = view.findViewById<CheckBox>(R.id.imageView6)
        favs1.setOnClickListener {
            isFavorite1 = !isFavorite1

            val toastMessage = if (isFavorite1) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        val favs2 = view.findViewById<CheckBox>(R.id.imageView26)
        favs2.setOnClickListener {
            isFavorite2 = !isFavorite2

            val toastMessage = if (isFavorite2) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }

        val favs3 = view.findViewById<CheckBox>(R.id.imageView30)
        favs3.setOnClickListener {
            isFavorite3 = !isFavorite3

            val toastMessage = if (isFavorite3) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }

        val favs4 = view.findViewById<CheckBox>(R.id.imageView23)
        favs4.setOnClickListener {
            isFavorite4 = !isFavorite4

            val toastMessage = if (isFavorite4) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        return view
    }
}

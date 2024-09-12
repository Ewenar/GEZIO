package com.gezioteam.gezio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager


class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SearchData>()
    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        addDataToList()
        adapter = SearchAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<SearchData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(SearchData("Athena", R.drawable.athena))
        mList.add(SearchData("Emre Aydın", R.drawable.emre))
        mList.add(SearchData("Gripin", R.drawable.gripin2))
        mList.add(SearchData("Lana Del Rey", R.drawable.lana))
        mList.add(SearchData("Metallica", R.drawable.metallica2))
        mList.add(SearchData("Mor ve Ötesi", R.drawable.morveotesi))
        mList.add(SearchData("Sena Şener", R.drawable.sena2))
        mList.add(SearchData("Sezen Aksu", R.drawable.sezenaksu))
        mList.add(SearchData("Şebnem Ferah", R.drawable.sebnem))
        mList.add(SearchData("Tarkan", R.drawable.tarkan))
        mList.add(SearchData("Teoman", R.drawable.teoman2))
        mList.add(SearchData("The Weeknd", R.drawable.weekend))
        mList.add(SearchData("Yakışıklı Güvenlik", R.drawable.yakisikli))








    }

}
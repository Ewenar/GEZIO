package com.gezioteam.gezio


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class LocationActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LocationData>()
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        addDataToList()
        adapter = LocationAdapter(mList)
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
        val fabBack: FloatingActionButton = findViewById(R.id.fab1)
        fabBack.setOnClickListener {
            val intent = Intent(this@LocationActivity, MainActivity::class.java)
            startActivity(intent)
        }


    }


    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<LocationData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(LocationData("Ankara", R.drawable.ankara_srch))
        mList.add(LocationData("İstanbul", R.drawable.istanbul_srch))
        mList.add(LocationData("İzmir", R.drawable.izmir_srch))
        mList.add(LocationData("Eskişehir", R.drawable.eskisehir_srch))
        mList.add(LocationData("Antalya", R.drawable.antalya_srch))
        mList.add(LocationData("Muğla", R.drawable.mugla_srch))
    }



}
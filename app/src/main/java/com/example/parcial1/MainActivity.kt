package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity(), EngineerAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val filterButton = findViewById<TextView>(R.id.textViewFilter)
        val viewAllButton = findViewById<TextView>(R.id.textViewViewAll)

        filterButton.setOnClickListener {
            searchView.setIconified(false)
        }

        viewAllButton.setOnClickListener {
            if (searchView.isIconified) {
            } else {
                val engineerList = getEngineerList()
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = EngineerAdapter(engineerList, this)
            }
        }

        val engineerList = getEngineerList()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EngineerAdapter(engineerList, this)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = engineerList.filter { engineer ->
                    engineer.name.contains(newText ?: "", ignoreCase = true)
                }
                recyclerView.adapter = EngineerAdapter(filteredList, this@MainActivity)
                return true
            }
        })
    }

    override fun onItemClick(engineer: Engineer) {
        val intent = Intent(this, EngineerDetailActivity::class.java)
        intent.putExtra("engineer", engineer)
        startActivity(intent)
    }

    private fun getEngineerList(): List<Engineer> {
        return listOf(
            Engineer(
                "Ing. Juan Pérez",
                "Civil Engineer",
                R.drawable.engineer,
                "Specialist in structural engineering",
                "+123456789",
                "juan@gmail.com",
                "15",
                "50"
            ),
            Engineer(
                "Ing. Ana López",
                "Software Engineer",
                R.drawable.engineer2,
                "Specialist in mobile development",
                "+234567890",
                "ana@yahoo.com",
                "10",
                "30"
            ),
            Engineer(
                "Ing. Carlos Gómez",
                "Mechanical Engineer",
                R.drawable.engineer3,
                "Specialist in automotive design",
                "+345678901",
                "carlos@outlook.com",
                "10",
                "40"
            ),
            Engineer(
                "Ing. Marta Díaz",
                "Electrical Engineer",
                R.drawable.engineer4,
                "Specialist in power systems",
                "+456789012",
                "marta@live.com",
                "12",
                "35"
            ),
            Engineer(
                "Ing. Luis Martínez",
                "Industrial Engineer",
                R.drawable.engineer5,
                "Specialist in process optimization",
                "+567890123",
                "luis@icloud.com",
                "18",
                "45"
            )
        )
    }
}

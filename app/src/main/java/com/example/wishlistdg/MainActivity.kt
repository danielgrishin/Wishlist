package com.example.wishlistdg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv=findViewById<RecyclerView>(R.id.rvItemList)

        val itemEnter = findViewById<Button>(R.id.buttonEnter)
        val itemName = findViewById<EditText>(R.id.etItemNameInput)
        val itemPrice = findViewById<EditText>(R.id.etItemPriceInput)
        val itemURL = findViewById<EditText>(R.id.etItemURLInput)

        val items: MutableList<Item> = ArrayList()
        var adapter = ItemAdapter(items)
        itemsRv.adapter=adapter
        itemsRv.layoutManager= LinearLayoutManager(this)

        itemEnter.setOnClickListener {
            val item = Item(itemName.text.toString(), "$"+itemPrice.text.toString(), itemURL.text.toString())
            (items as MutableList).add(item)
            adapter.notifyDataSetChanged()
        }

    }
}
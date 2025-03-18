package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = ContactListAdapter()
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDeitalActivity::class.java)

            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)

            startActivity(intent)

        }

    }
}

private val contacts = listOf(
    Contact(
        name = "William",
        phone = "(55) 47 912348759",
        icon = R.drawable.sample9

    ),
    Contact(
        name = "Tess",
        phone = "(55) 47 912346689",
        icon = R.drawable.sample11

    ),
    Contact(
        name = "Clayla",
        phone = "(55) 47 913348751",
        icon = R.drawable.sample3

    ),
    Contact(
        name = "Diogo",
        phone = "(55) 47 945748238",
        icon = R.drawable.sample10

    ),
    Contact(
        name = "Gerson",
        phone = "(55) 47 997456748",
        icon = R.drawable.sample8

    ),
    Contact(
        name = "Weslley",
        phone = "(55) 47 994758898",
        icon = R.drawable.sample2

    ),
    Contact(
        name = "Silvana",
        phone = "(55) 47 987454129",
        icon = R.drawable.sample16

    ),
    Contact(
        name = "Fabiano",
        phone = "(55) 47 988775781",
        icon = R.drawable.sample12

    ),
    Contact(
        name = "Bryan",
        phone = "(55) 47 945113454",
        icon = R.drawable.sample14

    ),
    Contact(
        name = "Flávia",
        phone = "(55) 47 922456668",
        icon = R.drawable.sample4

    ),
    Contact(
        name = "Daniele",
        phone = "(55) 47 992235448",
        icon = R.drawable.sample7

    ),
    Contact(
        name = "Elizabeth",
        phone = "(55) 47 995478452",
        icon = R.drawable.sample5

    ),
    Contact(
        name = "Stefani",
        phone = "(55) 47 954723142",
        icon = R.drawable.sample15

    ),
    Contact(
        name = "Victoria",
        phone = "(55) 47 987451156",
        icon = R.drawable.sample1

    ),
    Contact(
        name = "Sophia",
        phone = "(55) 47 936547818",
        icon = R.drawable.sample13

    ),
    Contact(
        name = "Natalina",
        phone = "(55) 47 945124421",
        icon = R.drawable.sample4

    ),
)
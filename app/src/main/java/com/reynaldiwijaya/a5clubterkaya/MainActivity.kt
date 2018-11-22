package com.reynaldiwijaya.a5clubterkaya

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaClub = resources.getStringArray(R.array.club_name)
        val detailCLub = resources.getStringArray(R.array.club_detail)
        val gambarClub = resources.obtainTypedArray(R.array.gambarClub)
        val gambarClubDetail = resources.obtainTypedArray(R.array.gambarClubDetail)

        for (i in namaClub.indices){
            items.add(Item(namaClub[i], detailCLub[i], gambarClub.getResourceId(i, 0), gambarClubDetail.getResourceId(i, 0)))
        }

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = AdapterClub(this, items){
            startActivity<DetailActivity>("namaClub" to it.nama, "detailClub" to it.detail ,"gambarDetail" to it.gambardetail)
        }
    }
}

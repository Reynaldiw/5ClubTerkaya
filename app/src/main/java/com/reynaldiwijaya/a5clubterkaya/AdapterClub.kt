package com.reynaldiwijaya.a5clubterkaya

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AdapterClub (val context: Context, val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<AdapterClub.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_club, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items[position], listener)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder (view)  {
        val namaClub = view.txtClubName
        val gambarClub = view.imgClub

        fun bindItem (item: Item, listener: (Item) -> Unit) {
            namaClub.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarClub)
            itemView.onClick {
                listener(item)
            }
        }
    }
}
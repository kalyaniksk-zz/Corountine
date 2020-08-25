package com.assignment.Coroutine.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.Coroutine.Model.Rows
import com.assignment.Coroutine.R
import kotlinx.android.synthetic.main.item_row_country.view.*

class CountryAdapter (val countryDetails: ArrayList<Rows>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_row_country, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return countryDetails.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.bindItems(countryDetails.get(position))
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(countryDetails: Rows) {
            if(countryDetails.title != null && countryDetails.description != null) {
                itemView.container.textViewTitle.text = countryDetails.title
                itemView.container.textViewdescrpition.text = countryDetails.description
            }else{
                itemView.container.visibility = View.GONE
            }
        }
    }

}
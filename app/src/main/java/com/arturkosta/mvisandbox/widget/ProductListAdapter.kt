package com.arturkosta.mvisandbox.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturkosta.mvisandbox.R
import com.arturkosta.mvisandbox.model.Product
import kotlinx.android.synthetic.main.product_item_layout.view.*

class ProductListAdapter(context: Context, var products: MutableList<Product> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.product_item_layout,
                parent,
                false
            )
        )
    }

    fun setData(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.products.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindData(products[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(product: Product) {
            itemView.title.text = product.title
        }
    }
}
package com.arturkosta.mvisandbox.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arturkosta.mvisandbox.R
import com.arturkosta.mvisandbox.domain.Product
import kotlinx.android.synthetic.main.product_item_layout.view.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class ProductListAdapter(context: Context, var products: MutableList<Product> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private val itemLongClicksChannel = BroadcastChannel<Int>(BUFFERED)
    val itemLongClicks: Flow<Int>
        get() = itemLongClicksChannel.asFlow()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.product_item_layout,
                parent,
                false
            )
        ) { itemLongClicksChannel.offer(it) }
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

    class ViewHolder(itemView: View, private val onItemLongClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bindData(product: Product) {
            itemView.title.text = product.title
            itemView.icon.setOnLongClickListener {
                onItemLongClick(product.id)
                true
            }
        }
    }
}
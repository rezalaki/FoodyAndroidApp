package com.rezalaki.foody.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rezalaki.foody.databinding.ItemFoodBinding
import com.rezalaki.foody.data.model.responses.FoodItem
import com.rezalaki.foody.util.enterByScaleAnimation

class HomeRvAdapter(
    private val foodsList: List<FoodItem>,
    private val onClicked: (foodId: Int) -> Unit
) : RecyclerView.Adapter<HomeRvAdapter.FoodItemViewHolder>() {

    private var lastAnimatedPosition = -1

    inner class FoodItemViewHolder(
        private val itemBinding: ItemFoodBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(food: FoodItem, position: Int) {
            if (lastAnimatedPosition < position) {
                itemBinding.root.enterByScaleAnimation()
                lastAnimatedPosition = position
            }
            itemBinding.tvName.text = food.title
            itemBinding.ivBanner.load(food.image)
            itemBinding.root.setOnClickListener { onClicked.invoke(food.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val itemBinding =
            ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = foodsList.size

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        holder.bind(foodsList[position], position)
    }

}
package com.example.test

import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.test.databinding.ListItemBinding
import com.example.test.databinding.ListSectionTitleBinding

sealed class CarListViewHolder(private val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root)

class CarListSectionTitleViewHolder(private val sectionBinding: ListSectionTitleBinding) : CarListViewHolder(sectionBinding) {
    fun setData(data: CarListSectionTitle) {
        sectionBinding.name.text = data.details.title
        sectionBinding.icon.setImageResource(data.details.icon)
    }
}

class CarListItemViewHolder(private val itemBinding: ListItemBinding) : CarListViewHolder(itemBinding) {
    fun setData(data: CarListItem) {
        itemBinding.name.text = data.car.name

        itemBinding.releaseYear.let { releaseYearTextView ->
            releaseYearTextView.text = SpannableStringBuilder()
                .bold {
                    append(releaseYearTextView.context.getString(R.string.release_year))
                }
                .append(": ")
                .append(data.car.releaseYear.toString())
        }

        itemBinding.startingPrice.let { startingPriceTextView ->
            startingPriceTextView.text = SpannableStringBuilder()
                .bold {
                    append(startingPriceTextView.context.getString(R.string.starting_price))
                }
                .append(": ")
                .append(data.car.startingPrice.toString())
        }
    }
}

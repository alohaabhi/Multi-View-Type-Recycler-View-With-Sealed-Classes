package com.example.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ListItemBinding
import com.example.test.databinding.ListSectionTitleBinding

enum class CarListViewType {
    SECTION_TITLE,
    ITEM
}

class CarListAdapter(private val data: List<CarListData>) :
    RecyclerView.Adapter<CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        return if (viewType == CarListViewType.ITEM.ordinal) {
            CarListItemViewHolder(
                ListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            CarListSectionTitleViewHolder(
                ListSectionTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is CarListItem -> CarListViewType.ITEM.ordinal
            is CarListSectionTitle -> CarListViewType.SECTION_TITLE.ordinal
        }
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        when (val dataForCurrentPosition = data[position]) {
            is CarListItem -> {
                (holder as CarListItemViewHolder).setData(dataForCurrentPosition)
            }
            is CarListSectionTitle -> {
                (holder as CarListSectionTitleViewHolder).setData(dataForCurrentPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
package com.example.test

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.MainBinding

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = MainBinding.inflate(layoutInflater, null, false)
        setContentView(mainBinding.root)

        mainBinding.carsList.layoutManager = LinearLayoutManager(this)
        mainBinding.carsList.addItemDecoration(VerticalSpaceItemDecoration(resources.getDimension(R.dimen.spacing_16dp).toInt()))
        mainBinding.carsList.adapter = CarListAdapter(CarListData.fromCarData(sampleCarData))
    }
}

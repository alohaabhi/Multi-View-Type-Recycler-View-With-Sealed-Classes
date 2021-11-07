package com.example.test

sealed class CarListData {
    companion object {
        fun fromCarData(carData: CarData): List<CarListData> {
            val carsList = mutableListOf<CarListData>()
            carData.sections.forEach { carSection ->
                carsList.add(CarListSectionTitle(carSection.details))
                carSection.cars.forEach { car ->
                    carsList.add(CarListItem(car))
                }
            }
            return carsList
        }
    }
}

data class CarListSectionTitle(val details: CarSectionDetails) : CarListData()
data class CarListItem(val car: Car) : CarListData()

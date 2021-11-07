package com.example.test

import androidx.annotation.DrawableRes

data class CarData(
    val sections: List<CarSection>
)

data class CarSection(
    val details: CarSectionDetails,
    val cars: List<Car>
)

data class CarSectionDetails(
    val title: String,
    @DrawableRes val icon: Int
)

data class Car(
    val name: String,
    val startingPrice: Int,
    val releaseYear: Int
)

val sampleCarData = CarData(
    listOf(
        CarSection(
            CarSectionDetails(
                "HatchBacks",
                R.drawable.hatchback
            ),
            listOf(
                Car(
                    "Suzuki Swift",
                    20000,
                    2010
                ),
                Car(
                    "Hyundai i10",
                    25000,
                    2015
                )
            )
        ),
        CarSection(
            CarSectionDetails(
                "Sedan",
                R.drawable.sedan
            ),
            listOf(
                Car(
                    "Honda City",
                    30000,
                    2010
                ),
                Car(
                    "Toyota Camry",
                    40000,
                    2005
                )
            )
        )

    )
)

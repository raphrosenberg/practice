package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.dessertclicker.model.Dessert

data class DessertUIState (
    val desserts: List<Dessert>,
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val dessertToShow: Dessert = desserts.first(),
    val dessertPrice: Int = dessertToShow.price,
    @DrawableRes val dessertImageId: Int = dessertToShow.imageId
)
package com.example.dessertclicker.ui.theme

import androidx.compose.runtime.currentComposer
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.ui.DessertUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {
    val desserts = Datasource.dessertList
    private val _uiState = MutableStateFlow(DessertUIState(desserts))
    val uiState: StateFlow<DessertUIState> = _uiState.asStateFlow()


    fun updateDessert() {
        val dessertToShow = determineDessertToShow()
        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue + currentState.dessertPrice,
                dessertsSold = currentState.dessertsSold + 1,
                //dessertToShow = determineDessertToShow()
            )
        }
    }


    /**
     * Determine which dessert to show.
     */
    fun determineDessertToShow() {
        for (dessert in desserts) {
            if (_uiState.value.dessertsSold >= dessert.startProductionAmount) {
                _uiState.update { currentState ->
                    currentState.copy(
                        dessertImageId = dessert.imageId,
                        dessertPrice = dessert.price,
                        dessertToShow = dessert
                    )
                }
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }
    }
/*
    fun updateDessertToShow() {
        _uiState.update { currentState ->
            currentState.copy( currentState ->
                dessertToShow = determineDessertToShow()
            )
        }

    }

 */
}
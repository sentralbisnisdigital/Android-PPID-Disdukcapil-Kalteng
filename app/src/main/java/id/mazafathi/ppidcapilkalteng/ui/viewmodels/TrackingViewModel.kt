package id.mazafathi.ppidcapilkalteng.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.mazafathi.ppidcapilkalteng.data.models.Tracking
import id.mazafathi.ppidcapilkalteng.data.repositories.TrackingRepository
import kotlinx.coroutines.launch

class TrackingViewModel(private val trackingRepository: TrackingRepository) : ViewModel() {
    val allTracking:LiveData<List<Tracking>> = trackingRepository.allTracking.asLiveData()
    fun insert(tracking: Tracking)= viewModelScope.launch {
        trackingRepository.insert(tracking)
    }

    fun deleteItem(tracking: Tracking)= viewModelScope.launch {
        trackingRepository.deleteItem(tracking)
    }
}
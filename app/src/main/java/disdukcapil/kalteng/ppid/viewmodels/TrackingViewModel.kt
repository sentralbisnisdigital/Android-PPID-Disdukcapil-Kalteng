package disdukcapil.kalteng.ppid.viewmodels

import androidx.lifecycle.*
import disdukcapil.kalteng.ppid.models.Tracking
import disdukcapil.kalteng.ppid.repositories.TrackingRepository
import kotlinx.coroutines.Dispatchers
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
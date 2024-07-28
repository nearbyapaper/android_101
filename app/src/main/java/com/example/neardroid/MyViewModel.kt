// MyViewModel.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neardroid.model.MyRepository
import kotlinx.coroutines.*

class MyViewModel : ViewModel() {

    private val repository = MyRepository()

    private val _data = MutableLiveData<List<String>>()
    val data: LiveData<List<String>> get() = _data

    // ViewModel's scope for coroutines
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            // Simulating a data fetch with delay
            delay(1000)
            _data.value = repository.getData()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

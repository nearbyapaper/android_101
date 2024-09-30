package com.example.neardroid.util

data class Resource<out T>(val status: StatusResource, val data: T?, val message: String?, val messageId: Int?) {

    private var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Read more: https://medium.com/google-developers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
     * For handle observer use it again
     */
    fun getResourceContentIfNotHandled(): Resource<T>? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            this
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): Resource<T> = this

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(StatusResource.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, data: T?, msgId: Int? = 0): Resource<T> {
            return Resource(StatusResource.ERROR, data, msg, msgId)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(StatusResource.LOADING, data, null, null)
        }
    }
}

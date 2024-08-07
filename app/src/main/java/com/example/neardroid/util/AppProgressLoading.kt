import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar

open class AppProgressLoading {
    fun create(context: Context): ProgressBar {
        val progressBar = ProgressBar(context)
        // Set layout parameters for the ProgressBar
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )

        progressBar.layoutParams = layoutParams
        // Optionally, set other properties like visibility, style, etc.
        progressBar.visibility = View.VISIBLE
        return progressBar
    }

    fun show(progressBar: ProgressBar, parentView: ViewGroup) {
        // Check if the ProgressBar is already a child of the parentView to avoid duplication
        if (progressBar.parent == null) {
            parentView.addView(progressBar)
        }
        // Center the ProgressBar within the parent view
        val layoutParams = progressBar.layoutParams as FrameLayout.LayoutParams
        layoutParams.width = FrameLayout.LayoutParams.WRAP_CONTENT
        layoutParams.height = FrameLayout.LayoutParams.WRAP_CONTENT
        layoutParams.gravity = android.view.Gravity.CENTER
        progressBar.layoutParams = layoutParams
        progressBar.visibility = View.VISIBLE
    }

    fun hide(progressBar: ProgressBar) {
        progressBar.visibility = View.GONE
    }
}

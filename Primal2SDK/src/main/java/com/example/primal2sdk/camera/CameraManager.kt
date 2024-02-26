package com.example.primal2sdk.camera


import android.app.Activity
import android.content.Intent
import android.provider.MediaStore



import android.content.ContentValues
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity

class CameraManager(private val activity: AppCompatActivity) {

    fun openCamera() {
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.TITLE, "New Picture")
            put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        }
        // Get the URI for the location to save the photo
        val imageUri: Uri? = activity.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        // Launch the camera activity
        getCameraResultLauncher().launch(imageUri)
    }

    private fun getCameraResultLauncher(): ActivityResultLauncher<Uri> {
        // Assuming this method sets up and returns the ActivityResultLauncher for taking a picture.
        // Actual implementation will depend on the Activity/Fragment from which it's called.
        // This may involve setting up the launcher in the activity/fragment and passing it through.
        TODO("Implement method to return ActivityResultLauncher<Uri>")
    }
}
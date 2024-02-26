package com.example.primal2sdk.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap

import android.net.Uri
import android.widget.ImageView

object CameraResultHandler {
    private var imageUri: Uri? = null

    fun handleCameraResult(isSuccess: Boolean, imageView: ImageView) {
        if (isSuccess) {
            // Set the captured image URI to the provided ImageView
            imageView.setImageURI(imageUri)
            // Perform additional tasks after the image has been captured and set.
            // This can include saving the image to a database, performing image processing, etc.
        }
    }
}

package com.example.primal2sdk.camera


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CameraPermissions(private val activity: AppCompatActivity) {

    fun requestCameraPermissions(permissionResultLauncher: ActivityResultLauncher<Array<String>>) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val requiredPermissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val allPermissionsGranted = requiredPermissions.all {
                ContextCompat.checkSelfPermission(activity, it) == PackageManager.PERMISSION_GRANTED
            }
            if (!allPermissionsGranted) {
                // Request the permissions
                permissionResultLauncher.launch(requiredPermissions)
            } else {
                // Permissions are already granted
                CameraManager(activity).openCamera()
            }
        } else {
            // For OS versions below Marshmallow
            CameraManager(activity).openCamera()
        }
    }
}
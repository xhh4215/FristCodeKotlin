package com.example.thefristcode.jetpackproject.medias

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_normal.*
import kotlinx.android.synthetic.main.activity_take_photo.*
import java.io.File
import java.util.zip.CheckedOutputStream

class TakePhotoActivity : AppCompatActivity() {
    val takePhotos = 1
    val fromPirctur = 2
    lateinit var imageUri: Uri
    lateinit var outputImageView: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_photo)
        takePhoto.setOnClickListener {
            outputImageView = File(externalCacheDir, "output_image.jpg")
            if (outputImageView.exists()) {
                outputImageView.delete()
            }
            outputImageView.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(
                    this,
                    "com.example.thefristcode.jetpackproject.fileprovider",
                    outputImageView
                )

            } else {
                Uri.fromFile(outputImageView)
            }

            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, takePhotos)
        }
        picturePhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, fromPirctur)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            takePhotos -> {
                if (resultCode == Activity.RESULT_OK) {
                    val bitmap =
                        BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                    showPhoto.setImageBitmap(rotateIfRequire(bitmap))
                }
            }
            fromPirctur -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    data.data?.let {
                        val bitmap = getBitmapFromUri(it)
                        showPhoto.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }


    private fun getBitmapFromUri(uri: Uri) =
        contentResolver.openFileDescriptor(uri, "r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)


        }

    private fun rotateIfRequire(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImageView.path)
        val orientation =
            exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
            else -> bitmap
        }

    }


    private fun rotateBitmap(bitmap: Bitmap, degreen: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degreen.toFloat())
        val rotateBitmap =
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        bitmap.recycle()
        return rotateBitmap
    }
}
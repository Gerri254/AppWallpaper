package com.gerald.wallpaperapp

import android.app.ProgressDialog
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.gerald.wallpaperapp.databinding.ActivityStoredBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class StoredActivity : AppCompatActivity() {

    lateinit var binding: ActivityStoredBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoredBinding.inflate(LayoutInflater)
        setContentView(binding.root)

        binding.getImage.setOnClickListener {

            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Fetching Image")
            progressDialog.setCancelable(false)
            progressDialog.show()
            val imageName = binding.imageId.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName.jpg")

            val localFile = File.createTempFile("tempImage","jpg")
            storageRef.getFile(localFile).addOnSuccessListener {

                if (progressDialog.isShowing)
                    progressDialog.dismiss()

                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.wallpaperView.setImageBitmap(bitmap)

            }.addOnFailureListener{

                if (progressDialog.isShowing)
                    progressDialog.dismiss()

                Toast.makeText(this,"Failed to retrieve Image",Toast.LENGTH_SHORT).show()

            }
        }

    }
}
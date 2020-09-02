package com.example.thefristcode.jetpackproject.permisssiongs

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_permission.*
import java.util.jar.Manifest

class PermissionActivity : AppCompatActivity() {
    private val contactList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactList)
        contartList.adapter = adapter
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                1
            )
        } else {
            getContactList()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getContactList()
                } else {
                    Toast.makeText(this, "no permission", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun getContactList() {
        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            , null, null, null, null
        )
            ?.apply {
                while (moveToNext()) {
                    val displayname =
                        getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                    val number =
                        getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    contactList.add("$displayname\n$number")

                }
                adapter
                    .notifyDataSetChanged()
                close()
            }
    }

}
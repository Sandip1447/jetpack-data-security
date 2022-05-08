package com.freecodecloud.dataencriptionsample

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.freecodecloud.dataencriptionsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {

        private const val PARAM_KEY_USERNAME: String = "username"
        private const val PARAM_KEY_PASSWORD: String = "password"
        private const val SHARED_PRE_FILE: String = "app_security"
    }

    private val masterKeyAlias: String by lazy {
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }

    private val sharedPreferences: SharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            SHARED_PRE_FILE,
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {

            val userName =binding.userName.text.toString()
            val password =binding.userPassword.text.toString()

            with(sharedPreferences.edit()){
                putString(PARAM_KEY_USERNAME,userName)
                putString(PARAM_KEY_PASSWORD,password)
                apply()
            }

        }

        binding.loadButton.setOnClickListener {
            getUserName()?.let {name->
                binding.userName.setText(name)

            }

            getUserPassword()?.let {password->
                binding.userPassword.setText(password)
            }
        }
    }

    fun getUserName():String? =sharedPreferences.getString(PARAM_KEY_USERNAME,null)
    fun getUserPassword():String? =sharedPreferences.getString(PARAM_KEY_PASSWORD,null)
}
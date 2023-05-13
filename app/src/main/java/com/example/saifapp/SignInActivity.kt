package com.example.saifapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern




class SignInActivity : AppCompatActivity() {

    var preff: SharedPreferences? = null
    val pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val pattern2 = ("[a-z0-9A-Z]{1,34}")

    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var check: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mail = findViewById(R.id.editTextName)
        pass = findViewById(R.id.editTextName2)
        check = findViewById(R.id.checkBox)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        check.isChecked = preff?.getBoolean("key4", false) ?: false
        mail.setText(preff?.getString("key2", ""))
        pass.setText(preff?.getString("key3", ""))
    }

    fun savestate(check: Boolean) {
        val editor = preff?.edit()
        editor?.putBoolean("key4", check)
        editor?.apply()
    }

    fun saveData(mail: String, pass: String) {
        val editor = preff?.edit()
        editor?.putString("key2", mail)
        editor?.putString("key3", pass)
        editor?.apply()
    }

    fun deleteAll() {
        val editor = preff?.edit()
        editor?.clear()
        editor?.apply()
    }

    fun emailVaild(text: String): Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun passVaild(text: String): Boolean {
        return Pattern.compile(pattern2).matcher(text).matches()
    }

    fun next(view: View)
    {

        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            if (emailVaild(mail.text.toString()))
            {
                if (passVaild(pass.text.toString()))
                {
                    val value: String = mail.text.toString()
                    val value2: String = pass.text.toString()
                    val checkboxstate: Boolean = check.isChecked
                    if (checkboxstate == true)
                    {
                        saveData(value, value2)
                        savestate(checkboxstate)
                        val intent = Intent(this@SignInActivity, ToolbarActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    else
                    {
                        deleteAll()
                        val intent = Intent(this@SignInActivity, ToolbarActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                else
                {
                    Toast.makeText(this, "Пароль содержит не допустимые символы!", Toast.LENGTH_SHORT).show()
                }
            }

            else
            {
                Toast.makeText(this, "E-mail введён не корректно!", Toast.LENGTH_SHORT).show()
            }

        }
        else
        {
            Toast.makeText(this, "Введите данные для входа!", Toast.LENGTH_SHORT).show()
        }
    }

    fun next2(view: View)
    {
        val inten = Intent(this@SignInActivity, RegistrationActivity::class.java)
        startActivity(inten)
        finish()
    }
}


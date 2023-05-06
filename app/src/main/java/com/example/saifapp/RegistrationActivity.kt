package com.example.saifapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity()
{
    val pattern2 = ("[a-zA-Z]{1,34}")
    val pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val pattern3 = ("[a-z0-9A-Z]{1,34}")

    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var repass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        name = findViewById(R.id.editTextTextPersonName)
        surname = findViewById(R.id.editTextTextPersonName2)
        mail = findViewById(R.id.editTextTextPersonName3)
        pass = findViewById(R.id.editTextTextPersonName4)
        repass = findViewById(R.id.editTextTextPersonName5)
    }

    fun emailVaild(text: String): Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }
    fun nameVaild(text: String): Boolean {
        return Pattern.compile(pattern2).matcher(text).matches()
    }
    fun passVaild(text: String): Boolean {
        return Pattern.compile(pattern3).matcher(text).matches()
    }

    fun reg(view: View)
    {
        if (name.text.toString().isNotEmpty() &&
            surname.text.toString().isNotEmpty() &&
            mail.text.toString().isNotEmpty() &&
            pass.text.toString().isNotEmpty() &&
            repass.text.toString().isNotEmpty())
        {
            if (nameVaild(name.text.toString())&&nameVaild(surname.text.toString()))
            {
                if (emailVaild(mail.text.toString()))
                {
                    if (passVaild(pass.text.toString())&&passVaild(repass.text.toString()))
                    {
                        if(pass.text.toString()==repass.text.toString())
                        {
                        val intent = Intent(this@RegistrationActivity, SignInActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()
                        finish()
                        }
                        else
                        {
                        Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(this, "Имя или Фамилия содержит не допустимые символы!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
        Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show()
        }
    }

    fun back(view: View)
    {
        val inten = Intent(this@RegistrationActivity, SignInActivity::class.java)
        startActivity(inten)
        finish()
    }
}
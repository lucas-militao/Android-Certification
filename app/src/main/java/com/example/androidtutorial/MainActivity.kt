package com.example.androidtutorial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.androidtutorial.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var myName : MyName = MyName("Lucas Militao", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        doneButton.setOnClickListener {
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nicknameEdit)
//        val nicknameTextView = findViewById<TextView>(R.id.nicknameText)
//
//        if(editText.text.isNullOrEmpty()) {
//            Toast.makeText(this, "Type a nickname to show", Toast.LENGTH_LONG).show()
//        } else {
//            nicknameTextView.text = editText.text
//            editText.visibility = View.GONE
//            view.visibility = View.GONE
//            nicknameTextView.visibility = View.VISIBLE

        binding.apply {
            if(this.nicknameEdit.text.isNullOrEmpty()) {
                Toast.makeText(this@MainActivity, "Type a nickname to show", Toast.LENGTH_LONG).show()
            } else {
                myName.nickname = nicknameEdit.text.toString()
                invalidateAll()
                nicknameEdit.visibility = View.GONE
                view.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


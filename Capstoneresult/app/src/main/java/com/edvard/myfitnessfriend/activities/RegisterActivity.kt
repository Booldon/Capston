package com.edvard.myfitnessfriend.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.edvard.myfitnessfriend.DB
import com.edvard.myfitnessfriend.R
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register.setOnClickListener(View.OnClickListener {
            val data = HashMap<String, Any>()
            data["userID"] = et_id.text.toString() //getText() -> text
            data["userPassword"] = et_pass.text.toString() //getText() -> text
            data["userName"] = et_name.text.toString() //getText() -> text
            data["userWeight"] = et_age.text.toString().toFloat() //getText() -> text
            val queue = DB.makeNewRequestQueue(this)
            DB.registerRequest(this, queue, data)

            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
    override fun onBackPressed() {
        val mintent = Intent(this, LoginActivity::class.java)
        startActivity(mintent)
        finish()
    }

}

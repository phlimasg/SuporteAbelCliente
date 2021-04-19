package br.edu.lasalle.suporteabelcliente.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.edu.lasalle.suporteabelcliente.R
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mAuth =  FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if(user != null){
                val dashboardIntent = Intent(this, MainActivity::class.java )
                startActivity(dashboardIntent)
                finish()
            }
            else{
                val loginIntent = Intent(this, LoginActivity::class.java )
                startActivity(loginIntent)
                finish()
            }
        },1000)
    }
    private fun mostrarLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
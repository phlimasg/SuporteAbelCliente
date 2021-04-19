package br.edu.lasalle.suporteabelcliente.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import br.edu.lasalle.suporteabelcliente.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        mAuth =  FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        findViewById<TextView>(R.id.txt_id).text = user?.uid
        findViewById<TextView>(R.id.txt_email).text = user?.displayName
        findViewById<TextView>(R.id.txt_nome).text = user?.email
        Glide.with(this).load(user?.photoUrl).into(findViewById<ImageView>(R.id.imageView));
        */


    }
}
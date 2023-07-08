package com.demo.demogeeks

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class ImplicitIntentActivity : AppCompatActivity() {

    lateinit var btnPerformAction: Button
    lateinit var ivMain: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        btnPerformAction = findViewById(R.id.btnPerformAction)
        ivMain = findViewById(R.id.ivMain)

        btnPerformAction.setOnClickListener(){
//            val bitmapDrawable= ivMain.drawable as BitmapDrawable
//            val bitmap = bitmapDrawable.bitmap
//            shareImage(bitmap)
            shareText("Hello")
        }
    }

    private fun shareImage(bitmap: Bitmap) {
      val photoUri = getImageToShare(bitmap)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type="image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM,photoUri)
        startActivity(Intent.createChooser(shareIntent,"Share photo using"))

    }
    private fun getImageToShare(bitmap: Bitmap): Uri? {
        val imagefolder = File(cacheDir, "images")
        var uri: Uri? = null
        try {
            imagefolder.mkdirs()
            val file = File(imagefolder, "shared_image.png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream)
            outputStream.flush()
            outputStream.close()
            uri = FileProvider.getUriForFile(this, "com.demo.demogeeks.fileprovider", file)
        } catch (e: Exception) {
            Toast.makeText(this, "" + e.message, Toast.LENGTH_LONG).show()
        }
        return uri
    }
    //To open url in browser
    private fun openBrowser(){
        val url ="https://www.geeksforgeeks.org/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
    }

    //Open Dialer Intent
    private fun openDialer(){
        val phone ="124567890"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phone")
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }
    }
    // Open Email
    private fun openEmail(){
        val recipientEmail = "example@example.com" // Replace with the recipient's email address
        val subject = "Hello" // Replace with the desired subject
        val body = "This is the body of the email." // Replace with the desired email body

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
    //Open Message
    private fun shareMessage(){
        val phoneNumber = "1234567890" // Replace with the desired phone number
        val message = "Hello, this is a prefilled message!" // Replace with the desired message

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("smsto:$phoneNumber")
        intent.putExtra("sms_body", message)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    //Share App
    private fun shareApp() {
        val appUrl = "https://play.google.com/store/apps/details?id="+ applicationContext.packageName;
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, appUrl)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    //ShareText
    private fun shareText(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
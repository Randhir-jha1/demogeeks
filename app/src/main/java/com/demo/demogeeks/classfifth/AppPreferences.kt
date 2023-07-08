package com.demo.demogeeks.classfifth

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(private val context:Context) {

    private val sharedPreferences:SharedPreferences= context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)

    companion object{
        private const val KEY_USERNAME="username"
        private const val KEY_USERTYPE="usertype"
        private const val KEY_IS_LOGIN="isLogin"
    }
    fun setUsername(username:String){
        sharedPreferences.edit().putString(KEY_USERNAME,username).apply()
    }
    fun getUsername():String?{
        return sharedPreferences.getString(KEY_USERNAME,null)
    }

    fun setUsertype(usertype:Int){
        sharedPreferences.edit().putInt(KEY_USERTYPE,usertype).apply()
    }
    fun getUsertype():Int{
        return sharedPreferences.getInt(KEY_USERTYPE,0)
    }

    fun setIsLogin(isLogin:Boolean){
        sharedPreferences.edit().putBoolean(KEY_IS_LOGIN,isLogin).apply()
    }
    fun getIsLogin():Boolean{
        return sharedPreferences.getBoolean(KEY_IS_LOGIN,false)
    }
    fun clearData(){
        sharedPreferences.edit().clear().apply()
    }


}
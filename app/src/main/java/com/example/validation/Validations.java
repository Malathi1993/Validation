package com.example.validation;

import android.widget.EditText;

public class Validations {
    internal var result = false
    private var pattern: Pattern? = null
    private var matcher: Matcher? = null
    private const val PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!*^]).{8,12})"
    private const val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    private const val USERNAME_PATTERN = "[ أ ئ ا-ى   ؤ ء ي a-zA-Z0-9 ]+"
    private const val CITYNAME_PATTERN = "[أ ئ ا-ى   ؤ ء ي a-zA-Z]+"
    private const val MOBILE_PATTERN = "^([0-9]{9})$"
    private const val MPIN_PATTERN = "^([0-9]{6})$"
    fun validatePassword(password: EditText): Boolean {
        var mPassword: String? = null
        if (password.length() != 0) {
            mPassword = password.text.toString()
            result = true
        } else result = false
        if (mPassword != null) {
            if (mPassword.length > 0) {
                pattern = Pattern.compile(PASSWORD_PATTERN)
                matcher = pattern?.matcher(mPassword)
                result = (Character.isUpperCase(mPassword[0])
                        && matcher!!.matches())
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidMobile(mMobile: TextView): Boolean {
        var mobile: String? = null
        if (mMobile.length() != 0) {
            mobile = mMobile.text.toString()
            mobile = mobile.trim { it <= ' ' }
        } else result = false
        if (mobile != null) {
            if (mobile.length > 0) {
                pattern = Pattern.compile(MOBILE_PATTERN)
                matcher = pattern?.matcher(mobile)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidCity(mCity: EditText): Boolean {
        var city: String? = null
        if (mCity.length() != 0) {
            city = mCity.text.toString()
            city = city.trim { it <= ' ' }
        } else result = false
        if (city != null) {
            if (city.length > 0) {
                pattern = Pattern.compile(CITYNAME_PATTERN)
                matcher = pattern?.matcher(city)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidMpin(mPin: EditText): Boolean {
        var mpin: String? = null
        if (mPin.length() != 0) {
            mpin = mPin.text.toString()
            mpin = mpin.trim { it <= ' ' }
        } else result = false
        if (mpin != null) {
            if (mpin.length > 0) {
                pattern = Pattern.compile(MPIN_PATTERN)
                matcher = pattern?.matcher(mpin)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidEmail(mEmail: EditText): Boolean {
        var email: String? = null
        if (mEmail.length() != 0) {
            email = mEmail.text.toString()
            email = email.trim { it <= ' ' }
        } else result = false
        if (email != null) {
            if (email.length > 0) {
                pattern = Pattern.compile(EMAIL_PATTERN)
                matcher = pattern?.matcher(email)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidMail(mEmail: TextView): Boolean {
        var email: String? = null
        if (mEmail.length() != 0) {
            email = mEmail.text.toString()
            email = email.trim { it <= ' ' }
        } else result = false
        if (email != null) {
            if (email.length > 0) {
                pattern = Pattern.compile(EMAIL_PATTERN)
                matcher = pattern?.matcher(email)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidUserName(uName: EditText): Boolean {
        var username: String? = null
        if (uName.length() != 0) {
            username = uName.text.toString()
            username = username.trim { it <= ' ' }
        } else result = false
        if (username != null) {
            if (username.length > 0) {
                pattern = Pattern.compile(USERNAME_PATTERN)
                matcher = pattern?.matcher(username)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isValidName(uName: TextView): Boolean {
        var username: String? = null
        if (uName.length() != 0) {
            username = uName.text.toString()
            username = username.trim { it <= ' ' }
        } else result = false
        if (username != null) {
            if (username.length > 0) {
                pattern = Pattern.compile(USERNAME_PATTERN)
                matcher = pattern?.matcher(username)
                result = matcher!!.matches()
            } else {
                result = false
            }
        }
        return result
    }

    fun isRequired(field: EditText): Boolean {
        result = if (field.length() != 0) {
            true
        } else {
            false
        }
        return result
    }

    fun isValidPhone(phone: EditText): Boolean {
        result = if (phone.length() == 10) {
            true
        } else {
            false
        }
        return result
    }

    fun isValidZipCode(zip:EditText): Boolean {
        if (zip.length() == 5) {
            result = true
        }
        return result
    }
}



==========================

        var mobile_email: String = phonumber?.getText().toString()
        mobile_email = mobile_email.trim { it <= ' ' }
        println("========username lenght is====" + mobile_email.length)
        if (mobile_email.length == 0) {
        phonumber?.setError(resources.getString(R.string.mobilenoshouldnotempty))
        proceedToLogin = false
        }
        else if (!Pattern.matches("[a-zA-Z]+", mobile_email)) {
        // if (Constants.DB.equals("SA")) {
        if (mobile_email.length >= 10 || mobile_email.length <= 8) {
        phonumber!!.setError(resources.getString(R.string.mobile_no_not_valid))
        proceedToLogin = false
        } else if (mobile_email[0] != '5') {
        phonumber!!.setError(resources.getString(R.string.mobilenosholdstartdigit5))
        proceedToLogin = false

        } else {

        phonumber?.setError(null)

        //proceedToLogin = true
        }
        if (proceedToLogin) {
        unaame = phonumber!!.text.toString()



        ApplicationSharedPref.init(this)
        co_code = country_code!!.text.toString().substring(1)
        ApplicationSharedPref.write(ApplicationSharedPref.KUANAME, co_code + unaame)


        if (Connectivity.isConnected(this)) {
        LoginRequest().execute()
        } else {
        NetWorkErrorPopup.callDailog(this)
        }
        }
        }
        }

        =========================================
        fun initValidationsmpin(): Boolean {
        var validation = false
        val currentpassword = mpin!!.text.toString().trim { it <= ' ' }
        val confirmpassword = confirmmpin!!.text.toString().trim { it <= ' ' }
        if (currentpassword.length <= 0) {
        mpin!!.error = getString(R.string.entercurrentmpin)
        } else if (currentpassword.length < 6 || currentpassword.length > 6) {
        mpin!!.error = getString(R.string.mpin_should_be_6digit_only)
        }  else if (confirmpassword.length <= 0) {
        confirmmpin!!.error = getString(R.string.confirmpassword)
        } else if (confirmpassword.length < 6 || confirmpassword.length > 6) {
        confirmmpin!!.error = getString(R.string.mpin_should_be_6digit_only)
        } else if (confirmpassword != currentpassword) {
        confirmmpin!!.error = getString(R.string.mpin_didnt_match)
        }
        else {
        validation = true
        }
        return validation
        }
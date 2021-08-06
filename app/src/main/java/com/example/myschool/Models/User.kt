package com.example.myschool.Models

data class User (
    private  var surname: String = "",
    private  var patronymic:String = "",
    private var name:String = "",
    private var email:String = "",
    private  var pass:String = "",
    private  var phone:String = "",
    private var address:String = "",
    private  var kl:String = "",
    private  var letter:String = ""
)
{
    fun getSurname(): String? {
        return surname
    }

    fun setSurname(surname: String?) {
        this.surname = surname!!
    }

    fun getPatronymic(): String? {
        return patronymic
    }

    fun setPatronymic(patronymic: String?) {
        this.patronymic = patronymic!!
    }

    fun getLetter(): String? {
        return letter
    }

    fun setLetter(letter: String?) {
        this.letter = letter!!
    }

    fun getKl(): String? {
        return kl
    }

    fun setKl(kl: String?) {
        this.kl = kl!!
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String?) {
        this.address = address!!
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email!!
    }

    fun getPass(): String? {
        return pass
    }

    fun setPass(pass: String?) {
        this.pass = pass!!
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone!!
    }
}

/*class User {
    private lateinit var surname: String
    private lateinit var patronymic:String
    private lateinit var name:String
    private lateinit var email:String
    private lateinit var pass:String
    private lateinit var phone:String
    private lateinit  var address:String
    private lateinit var kl:String
    private lateinit var letter:String
    constructor() {}
    constructor(surname: String, patronymic:String, name: String,
                email: String, pass: String,phone: String, address: String,
                kl: String, letter: String)
    {
        this.surname = surname
        this.patronymic = patronymic
        this.name = name
        this.email = email
        this.pass = pass
        this.phone = phone
        this.address = address
        this.kl = kl
        this.letter = letter
    }

    fun getSurname(): String? {
        return surname
    }

    fun setSurname(surname: String?) {
        this.surname = surname!!
    }

    fun getPatronymic(): String? {
        return patronymic
    }

    fun setPatronymic(patronymic: String?) {
        this.patronymic = patronymic!!
    }

    fun getLetter(): String? {
        return letter
    }

    fun setLetter(letter: String?) {
        this.letter = letter!!
    }

    fun getKl(): String? {
        return kl
    }

    fun setKl(kl: String?) {
        this.kl = kl!!
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String?) {
        this.address = address!!
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email!!
    }

    fun getPass(): String? {
        return pass
    }

    fun setPass(pass: String?) {
        this.pass = pass!!
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone!!
    }
}

*/
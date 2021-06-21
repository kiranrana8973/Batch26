package com.example.batch26

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val stdId : Int? = 0,
    val fname : String? = null,
    val androidMarks : Int? = 0,
    val api : Int? = 0,
    val iot : Int? = 0
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(stdId)
        parcel.writeString(fname)
        parcel.writeValue(androidMarks)
        parcel.writeValue(api)
        parcel.writeValue(iot)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}
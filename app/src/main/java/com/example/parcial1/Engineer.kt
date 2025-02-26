package com.example.parcial1

import android.os.Parcel
import android.os.Parcelable

data class Engineer(
    val name: String,
    val specialty: String,
    val imageResId: Int,
    val about: String,
    val phone: String,
    val email: String,
    val experience: String,
    val projects: String
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(specialty)
        dest.writeInt(imageResId)
        dest.writeString(about)
        dest.writeString(phone)
        dest.writeString(email)
        dest.writeString(experience)
        dest.writeString(projects)
    }

    companion object CREATOR : Parcelable.Creator<Engineer> {
        override fun createFromParcel(parcel: Parcel): Engineer {
            return Engineer(
                name = parcel.readString() ?: "",
                specialty = parcel.readString() ?: "",
                imageResId = parcel.readInt(),
                about = parcel.readString() ?: "",
                phone = parcel.readString() ?: "",
                email = parcel.readString() ?: "",
                experience = parcel.readString() ?: "",
                projects = parcel.readString() ?: ""
            )
        }

        override fun newArray(size: Int): Array<Engineer?> {
            return arrayOfNulls(size)
        }
    }
}

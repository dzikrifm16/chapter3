package com.example.myapplication


import android.os.Parcel
import android.os.Parcelable

data class MenuItem(
    val nama: String,
    val harga: Int,
    val gambarId: Int,
    val deskripsi: String,
    val lokasi: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(harga)
        parcel.writeInt(gambarId)
        parcel.writeString(deskripsi)
        parcel.writeString(lokasi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MenuItem> {
        override fun createFromParcel(parcel: Parcel): MenuItem {
            return MenuItem(parcel)
        }

        override fun newArray(size: Int): Array<MenuItem?> {
            return arrayOfNulls(size)
        }
    }
}

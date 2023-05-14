package br.com.brayandelmondes.finance.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val id: Int
) : Parcelable

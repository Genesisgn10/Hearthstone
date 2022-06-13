package com.genesis.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hearthstone(
    val cardId: String?,
    val name: String?,
    val type: String?,
    val text: String?,
    val health: String?,
    val cost: String?,
    val flavor: String?,
    val cardSet: String?,
    val faction: String?,
    val rarity: String?,
    val attack: String?,
    val img: String?
) : Parcelable
package com.genesis.presenter.model

import android.os.Parcelable
import com.genesis.domain.model.Hearthstone
import kotlinx.android.parcel.Parcelize

@Parcelize
class HearthstoneUiModel(
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

fun Hearthstone.toUiModel() = HearthstoneUiModel(
    cardId = this.cardId,
    name = this.name,
    type = this.type,
    text = this.text,
    health = this.health,
    cost = this.cost,
    flavor = this.flavor,
    cardSet = this.cardSet,
    faction = this.faction,
    rarity = this.rarity,
    attack = this.attack,
    img = this.img,
)


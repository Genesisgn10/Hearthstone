package com.genesis.presenter.model

import com.genesis.domain.model.Category

class CategoryUiModel(
    val name: String,
    val thumb: String
)

fun Category.toUiModel() = CategoryUiModel(
    name = this.name,
    thumb = this.thumb
)


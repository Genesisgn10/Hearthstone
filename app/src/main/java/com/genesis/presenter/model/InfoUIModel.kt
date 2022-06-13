package com.genesis.presenter.model

import com.genesis.domain.model.Sets

data class InfoUIModel(
    val sets: List<String>
)


fun InfoUIModel.toUiModel() = Sets(
    sets = this.sets
)


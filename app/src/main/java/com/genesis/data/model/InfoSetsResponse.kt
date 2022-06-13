package com.genesis.data.model

import com.genesis.domain.model.Sets

data class InfoSetsResponse(
    val sets: List<String>
)

fun InfoSetsResponse.toSets() = Sets(
    sets = this.sets
)
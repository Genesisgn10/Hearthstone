package com.genesis.network

class BaseResponse<Data>(
    val hearthstone: List<Data>,
    val sets: List<Data>,
    val HallofFame: List<Data>
)
package com.pedromassango.crypto.data

import com.google.gson.annotations.SerializedName

class BlockchainStats(
    @SerializedName("timestamp") val timestamp: Int,
    @SerializedName("market_price_usd") val marketPriceUsd: Double,
    @SerializedName("hash_rate") val hashRate: Double,
    @SerializedName("total_fees_btc") val totalFeesBtc: Int,
    @SerializedName("n_btc_mined") val nBtcMined: Int,
    @SerializedName("n_tx") val nTx: Int,
    @SerializedName("n_blocks_mined") val nBlocksMined: Int,
    @SerializedName("minutes_between_blocks") val minutesBetweenBlocks: Double,
    @SerializedName("totalbc") val totalbc: Int,
    @SerializedName("n_blocks_total") val nBlocksTotal: Int,
    @SerializedName("estimated_transaction_volume_usd") val estimatedTransactionVolumeUsd: Double,
    @SerializedName("blocks_size") val blocksSize: Int,
    @SerializedName("miners_revenue_usd") val minersRevenueUsd: Double,
    @SerializedName("nextretarget") val nextretarget: Int,
    @SerializedName("difficulty") val difficulty: Int,
    @SerializedName("estimated_btc_sent") val estimatedBtcSent: Int,
    @SerializedName("miners_revenue_btc") val minersRevenueBtc: Int,
    @SerializedName("total_btc_sent") val totalBtcSent: Int,
    @SerializedName("trade_volume_btc") val tradeVolumeBtc: Double,
    @SerializedName("trade_volume_usd") val tradeVolumeUsd: Double
)
package br.com.brayandelmondes.finance.domain

data class Transaction(
    val id: Int,
    val dateTime: String,
    val description: String,
    val value: Double,
    val type: TransactionType,
    val userId: Int
)

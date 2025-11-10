package com.example.questnavigasitugas_163.model

data class Peserta(
    val nama: String,
    val jenisKelamin: String,
    val status: String,
    val alamat: String
)

object DataPeserta {
    val daftarPeserta = listOf(
        Peserta(
            nama = "Asroni Sukirman",
            jenisKelamin = "Laki-laki",
            status = "Cerai",
            alamat = "Sleman"
        ),
        Peserta(
            nama = "Aprilia Kurnianti",
            jenisKelamin = "Perempuan",
            status = "Belum Kawin",
            alamat = "Bantul"
        ),
        Peserta(
            nama = "Haris Setyawan",
            jenisKelamin = "Laki-laki",
            status = "Kawin",
            alamat = "Jogja"
        ),
        Peserta(
            nama = "Haris Setyawan",
            jenisKelamin = "Laki-laki",
            status = "Kawin",
            alamat = "Jogja"
        ),
        Peserta(
            nama = "Dwijoko Purbohadi",
            jenisKelamin = "Laki-laki",
            status = "Belum Kawin",
            alamat = "Bantul"
        )
    )
}
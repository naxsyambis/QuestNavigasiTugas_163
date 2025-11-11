package com.example.questnavigasitugas_163

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_163.view.Beranda
import com.example.questnavigasitugas_163.view.DaftarPeserta
import com.example.questnavigasitugas_163.view.Formulir

enum class Layar {
    Beranda,
    Daftar,
    Formulir
}

@Composable
fun AplikasiNavigasi(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Layar.Beranda.name
    ) {
        composable(route = Layar.Beranda.name) {
            Beranda(
                onMasukClick = {
                    navController.navigate(Layar.Daftar.name)
                }
            )
        }

        composable(route = Layar.Daftar.name) {
            DaftarPeserta(
                onBerandaClick = {
                    navController.navigate(Layar.Beranda.name) {
                        popUpTo(Layar.Beranda.name) { inclusive = true }
                    }
                },
                onFormulirClick = {
                    navController.navigate(Layar.Formulir.name)
                }
            )
        }

        composable(route = Layar.Formulir.name) {
            Formulir(
                onKembaliClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
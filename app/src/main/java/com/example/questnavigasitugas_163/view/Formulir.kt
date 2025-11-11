package com.example.questnavigasitugas_163.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.questnavigasitugas_163.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Formulir(
    onKembaliClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    // State untuk dropdown
    var dropdownExpanded by remember { mutableStateOf(false) }
    val opsiStatus = listOf(
        stringResource(R.string.belum_kawin),
        stringResource(R.string.kawin),
        stringResource(R.string.cerai)
    )

    // State untuk dialog
    var tampilDialog by remember { mutableStateOf(false) }
}
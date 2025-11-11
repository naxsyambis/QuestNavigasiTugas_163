package com.example.questnavigasitugas_163.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.formulir_pendaftaran),
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Input Nama Lengkap
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(R.string.nama_lengkap)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Input Jenis Kelamin
            Text(
                text = stringResource(R.string.jenis_kelamin),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(24.dp))

            RadioButton(
                selected = jenisKelamin == "Perempuan", // ✅ DIPERBAIKI
                onClick = { jenisKelamin = "Perempuan" } // ✅ DIPERBAIKI
            )
            Text(
                stringResource(R.string.perempuan), // Label tetap pakai string resource
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Input Status Perkawinan (Dropdown)
        ExposedDropdownMenuBox(
            expanded = dropdownExpanded,
            onExpandedChange = { dropdownExpanded = !dropdownExpanded }
        ) {
            OutlinedTextField(
                value = statusPerkawinan,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.status_perkawinan)) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false }
            ) {
                opsiStatus.forEach { opsi ->
                    DropdownMenuItem(
                        text = { Text(opsi) },
                        onClick = {
                            statusPerkawinan = opsi
                            dropdownExpanded = false
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Input Alamat
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(stringResource(R.string.alamat)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                maxLines = 3
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Tombol Aksi
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = onKembaliClick) {
                    Text(stringResource(R.string.kembali))
                }

                Button(
                    onClick = {
                        if (nama.isNotEmpty() && jenisKelamin.isNotEmpty() &&
                            statusPerkawinan.isNotEmpty() && alamat.isNotEmpty()) {
                            tampilDialog = true
                        }
                    },
                    enabled = nama.isNotEmpty() && jenisKelamin.isNotEmpty() &&
                            statusPerkawinan.isNotEmpty() && alamat.isNotEmpty()
                ) {
                    Text(stringResource(R.string.submit))
                }
            }
        }
    }
}
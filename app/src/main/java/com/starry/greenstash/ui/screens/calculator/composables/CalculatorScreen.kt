package com.starry.greenstash.ui.screens.calculator.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.starry.greenstash.utils.weakHapticFeedback
import java.text.DecimalFormat
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FutureValueCalculatorScreen(navController: NavController) {
    val view = LocalView.current
    var presentValue by remember { mutableStateOf("") }
    var periods by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    var compounding by remember { mutableStateOf("") }
    var futureValue by remember { mutableStateOf("0.00") }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    fun calculateFV() {
        val pv = presentValue.toDoubleOrNull() ?: 0.0
        val t = periods.toDoubleOrNull() ?: 0.0
        val r = (rate.toDoubleOrNull() ?: 0.0) / 100
        val m = compounding.toDoubleOrNull() ?: 1.0

        if (pv > 0 && t > 0 && r > 0 && m > 0) {
            val fv = pv * (1 + r / m).pow(m * t)
            futureValue = DecimalFormat("#,###.##").format(fv)
        } else {
            futureValue = "Invalid Input"
        }
    }

    fun clearFields() {
        presentValue = ""
        periods = ""
        rate = ""
        compounding = ""
        futureValue = "0.00"
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Future Value Calculator",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        view.weakHapticFeedback()
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                )
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                // Future Value Display
                Card(
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp)
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "FV:",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.weight(1f)) // Pushes the next text to the right
                            Text(
                                text = futureValue,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            item {
                // Input Fields Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp)
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        InputField(value = presentValue, label = "Present Value (PV)") { presentValue = it }
                        InputField(value = periods, label = "Number of Periods (t)") { periods = it }
                        InputField(value = rate, label = "Rate (%)") { rate = it }
                        InputField(value = compounding, label = "Compounding (m)") { compounding = it }
                    }
                }
            }

            item {
                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextButton(
                        onClick = { clearFields() },
                        modifier = Modifier.padding(end = 2.dp)
                    ) {
                        Text(
                            text = "CLEAR",
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Button(
                        onClick = { calculateFV() },
                        modifier = Modifier.padding(end = 2.dp)
                    ) {
                        Text(
                            text = "CALCULATE",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InputField(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}
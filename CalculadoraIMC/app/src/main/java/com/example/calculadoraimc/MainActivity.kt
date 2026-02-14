package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                CalculadoraIMCLayout()
            }
        }
    }
}

@Composable
fun CalculadoraIMCLayout() {

    var pesoInput by remember { mutableStateOf("") }

    var alturaInput by remember { mutableStateOf("") }

    var imc by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calcular_imc),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(
            label = R.string.peso,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = pesoInput,
            onValueChange = { pesoInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        EditNumberField(
            label = R.string.altura,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = alturaInput,
            onValueChange = { alturaInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        Button(onClick = {
            val peso = pesoInput.toDoubleOrNull() ?: 0.0

            val altura = alturaInput.toDoubleOrNull() ?: 0.0

            if (peso > 0 && altura > 0) {
                imc = calculateImc(peso, altura)

            } else {
                imc = null
            }

        }) {
            Text(text = stringResource(R.string.calcular))
        }

        Spacer(modifier = Modifier.height(150.dp))

        imc?.let { calcularRetorno(it) }
    }
}

private fun calculateImc(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

@Composable
fun calcularRetorno(imc: Double) {

    val mensagem = when {
        imc < 17 -> stringResource(R.string.muito_abaixo_do_peso)
        imc >= 17 && imc <= 18.49 -> stringResource(R.string.abaixo_do_peso)
        imc >= 18.5 && imc <= 24.99 -> stringResource(R.string.peso_normal)
        imc >= 25 && imc <= 29.99 -> stringResource(R.string.acima_do_peso)
        imc >= 30 && imc <= 34.99 -> stringResource(R.string.obesidade_i)
        imc >= 35 && imc <= 39.99 -> stringResource(R.string.obesidade_ii_severa)
        imc > 40 -> stringResource(R.string.obesidade_iii_m_rbida)
        else -> stringResource(R.string.invalido)
    }

    Text(text = "Seu IMC é %.2f - %s".format(imc, mensagem))
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CalculadoraIMCLayoutPreview() {
    CalculadoraIMCTheme {
        CalculadoraIMCLayout()
    }
}
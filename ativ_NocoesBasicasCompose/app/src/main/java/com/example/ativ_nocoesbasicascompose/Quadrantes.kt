package com.example.ativ_nocoesbasicascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ativ_nocoesbasicascompose.ui.theme.Ativ_NocoesBasicasComposeTheme

class Quadrantes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ativ_NocoesBasicasComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantesTest(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantesTest(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
        Row {
            Quadrante1()
            Quadrante2()
        }
        Row {
            Quadrante3()
            Quadrante4()
        }
    }

}

@Composable
fun Quadrante1(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .background(Color(0xFFEADDFF))
        .fillMaxWidth(0.5f)
        .fillMaxHeight(0.5f)
        .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.text_composable),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun Quadrante2(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .background(Color(0xFFD0BCFF))
        .fillMaxHeight(0.5f)
        .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.image_composable),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
            textAlign = TextAlign.Justify,

        )
    }
}

@Composable
fun Quadrante3(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .background(Color(0xFFB69DF8))
        .fillMaxHeight()
        .fillMaxWidth(0.5f)
        .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.row_composable),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun Quadrante4(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .background(Color(0xFFF6EDFF))
        .fillMaxHeight()
        .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.column_composable),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
            textAlign = TextAlign.Justify,

        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Ativ_NocoesBasicasComposeTheme {
        QuadrantesTest()
    }
}
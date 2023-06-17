package com.neuralnet.poc.financasapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neuralnet.poc.financasapp.data.model.Despesa
import com.neuralnet.poc.financasapp.ui.theme.PoCFinançasTheme
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val despesas by homeViewModel.despesas.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(despesas) { despesa ->
                ItemDespesa(despesa)
            }
        }
    }
}

@Composable
fun ItemDespesa(despesa: Despesa, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = despesa.nome,
                modifier = Modifier.padding(8.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(text = despesa.nome.formatResponse(), style = MaterialTheme.typography.labelLarge)
                Text(text = despesa.categoria.formatResponse(), style = MaterialTheme.typography.bodySmall)
            }
            Text(
                text = despesa.valor.toReal(),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(widthDp = 320, showBackground = true)
@Composable
fun ItemDespesaPreview() {
    PoCFinançasTheme {
        Column {
            ItemDespesa(
                Despesa("Netflix", 39.90, "Entretenimento")
            )
            ItemDespesa(
                Despesa("Netflix", 39.90, "Entretenimento")
            )
        }
    }
}

fun Double.toReal():String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 2
    format.currency = Currency.getInstance(Locale("pt", "BR"))

    return format.format(this)
}

fun String.formatResponse():String =
    this.replace("Ã�", "Á")
        .replace("Ãº", "ú")



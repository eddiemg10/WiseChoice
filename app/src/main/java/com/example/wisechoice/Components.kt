package com.example.wisechoice

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Heading(title: String){
    Text(
        color = MaterialTheme.colorScheme.onBackground,
        text = title,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 20.dp)
    )
}

@Composable
fun PrimaryButton(text: String, handler: ()->Unit){
    Button(
        onClick = handler,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(0.8F)
    ) {
        Text(
            text= text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
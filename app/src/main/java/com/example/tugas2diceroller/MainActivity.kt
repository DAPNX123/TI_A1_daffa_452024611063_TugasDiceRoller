package com.example.tugas2diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2diceroller.ui.theme.Tugas2DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas2DiceRollerTheme {
                // Memanggil aplikasi utama
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    // Modifier di sini membuat tata letak mengisi seluruh layar dan kontennya berada di tengah
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // remember dan mutableIntStateOf memberi tahu Compose untuk menggambar ulang UI
    // setiap kali nilai 'result' berubah.
    var result by remember { mutableIntStateOf(1) }

    // Menentukan gambar dadu mana yang akan ditampilkan berdasarkan nilai acak
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Column menyusun gambar dan tombol secara vertikal (atas-bawah)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )

        // Memberikan jarak antara gambar dadu dan tombol
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol yang akan mengacak angka 1 sampai 6 saat diklik
        Button(onClick = { result = (1..6).random() }) {
            // Teks sudah direvisi menjadi hardcode agar tidak memicu error unresolved reference
            Text("Roll")
        }
    }
}
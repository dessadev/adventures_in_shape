package com.example.adventuresinshape

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EscolhaPersonagem(navController: NavController) {
    var selectedCharacter by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9))
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.escolha),
                contentDescription = "Escolher",
                modifier = Modifier.size(190.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Prepare-se para explorar o incrível mundo das formas geométricas!\n\nNeste app, você se tornará um verdadeiro aventureiro da geometria.",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Escolha o seu personagem:",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_black)),
                color = Color(0xFF503448),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                CharacterOption(
                    characterImage = R.drawable.sunny,
                    selected = selectedCharacter == "Sunny",
                    onSelect = { selectedCharacter = "Sunny" }
                )

                CharacterOption(
                    characterImage = R.drawable.pinky,
                    selected = selectedCharacter == "Pinky",
                    onSelect = { selectedCharacter = "Pinky" }
                )
            }

            Spacer(modifier = Modifier.height(55.dp))

            Button(
                onClick = { navController.navigate("falapersonagem/${selectedCharacter}") },
                enabled = selectedCharacter.isNotEmpty(),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
            ) {
                Text(
                    text = "AVANÇAR",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold))
                )
            }
        }
    }
}

@Composable
fun CharacterOption(characterImage: Int, selected: Boolean, onSelect: () -> Unit) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .border(2.dp, if (selected) Color(0xFF503448) else Color(0xFFEBE1D5), RoundedCornerShape(15.dp))
            .clickable { onSelect() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = characterImage),
            contentDescription = "Personagem",
            modifier = Modifier.size(130.dp)
        )
    }
}

@Composable
fun FalaPersonagem(navController: NavController, selectedCharacter: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .border(
                    width = 4.dp,
                    color = Color(0xFFFEEEAB),
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = when (selectedCharacter) {
                        "Sunny" -> R.drawable.sunny01
                        "Pinky" -> R.drawable.pinky01
                        else -> R.drawable.default_character
                    }
                ),
                contentDescription = "Personagem",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.bemvindo),
                contentDescription = "Bem-vindo",
                modifier = Modifier.height(60.dp)
                    .width(550.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = when (selectedCharacter) {
                    "Sunny" -> "Eu sou o Sunny, seu guia nessa incrível aventura geométrica! No nosso app, você vai aprender sobre formas como círculos, quadrados e triângulos. É muito fácil: você só precisa colocar alguns valores, e eu te mostro os cálculos de área, perímetro e muito mais! Vamos explorar juntos esse mundo cheio de formas e descobrir como a geometria pode ser divertida!"
                    "Pinky" -> "Eu sou a Pinky e vou te mostrar como a geometria pode ser superdivertida! Aqui no app, você só precisa me dizer os números, e eu faço as contas para você. Quer saber a área de um círculo ou o perímetro de um quadrado? É só escolher uma forma e começar a explorar comigo. Vamos nessa?"
                    else -> "Bem-vindo ao mundo das formas geométricas!"
                },
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                color = Color(0xFF503448),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate("home")
                },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
            ) {
                Text(
                    text = "AVANÇAR",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FalaPersonagemPreview() {
    FalaPersonagem(navController = rememberNavController(), selectedCharacter = "Sunny")
}

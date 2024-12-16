package com.example.adventuresinshape

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Circulo(navController: NavHostController) {
    var raio by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(0.0) }
    val areaCirculo = if (area != null) "%.2f".format(area) else "0.00"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Círculo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.circulo),
            contentDescription = "Desenho do Círculo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = raio,
            onValueChange = { raio = it },
            label = {
                Text(
                    text = "Digite o raio",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (raio.isNotEmpty()) Math.PI * raio.toFloat() * raio.toFloat() else 0.0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $areaCirculo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um círculo é calculada usando a fórmula: A = π * r², onde r é o raio.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quadrado(navController: NavHostController) {

    var lado by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Float?>(0.0f) }
    var area_quadrado = "%.2f".format(area)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Quadrado",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.quadrado),
            contentDescription = "Desenho do Quadrado",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = lado,
            onValueChange = { lado = it },
            label = {
                Text(
                    text = "Digite o lado",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (lado.isNotEmpty()) lado.toFloat() * lado.toFloat() else 0.0f
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $area_quadrado",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um quadrado é calculada usando a fórmula: A = lado², onde lado é a medida do lado do quadrado.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Triangulo(navController: NavHostController) {

    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) }
    var area_triangulo = "%.2f".format(area)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Triângulo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.triangulo),
            contentDescription = "Desenho do Triângulo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = base,
            onValueChange = { base = it },
            label = {
                Text(
                    text = "Digite a base",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text(
                    text = "Digite a altura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (base.isNotEmpty() && altura.isNotEmpty()) {
                    (base.toFloat() * altura.toFloat() / 2).toDouble()
                } else 0.0
                area_triangulo = "%.2f".format(area)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $area_triangulo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um triângulo é calculada usando a fórmula: A = (base * altura) / 2, onde base é a medida da base do triângulo e altura é a altura do triângulo.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Retangulo(navController: NavHostController) {

    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) }
    var area_retangulo = "%.2f".format(area)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Retângulo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.retangulo),
            contentDescription = "Desenho do Retângulo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = largura,
            onValueChange = { largura = it },
            label = {
                Text(
                    text = "Digite a largura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text(
                    text = "Digite a altura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (largura.isNotEmpty() && altura.isNotEmpty()) {
                    largura.toFloat().toDouble() * altura.toFloat().toDouble()
                } else 0.0
                area_retangulo = "%.2f".format(area)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $area_retangulo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um retângulo é calculada usando a fórmula: A = largura × altura, onde largura e altura são as medidas dos lados do retângulo.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Romboedro(navController: NavHostController) {

    var comprimento by remember { mutableStateOf("") }
    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var volume by remember { mutableStateOf(0.0) }
    var volume_romboedro = "%.2f".format(volume)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Romboedro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.romboedro),
            contentDescription = "Desenho do Romboedro",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = comprimento,
            onValueChange = { comprimento = it },
            label = {
                Text(
                    text = "Digite o comprimento",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = largura,
            onValueChange = { largura = it },
            label = {
                Text(
                    text = "Digite a largura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text(
                    text = "Digite a altura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                volume = if (comprimento.isNotEmpty() && largura.isNotEmpty() && altura.isNotEmpty()) {
                    comprimento.toFloat().toDouble() * largura.toFloat().toDouble() * altura.toFloat().toDouble()
                } else 0.0
                volume_romboedro = "%.2f".format(volume) // Atualiza o valor formatado
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Volume: $volume_romboedro",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "O volume de um romboedro é calculado usando a fórmula: V = comprimento × largura × altura.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Trapezoide(navController: NavHostController) {

    var baseMaior by remember { mutableStateOf("") }
    var baseMenor by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) }
    var area_trapezoide = "%.2f".format(area)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Trapézio",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.trapezoide),
            contentDescription = "Desenho do Trapézio",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = baseMaior,
            onValueChange = { baseMaior = it },
            label = {
                Text(
                    text = "Digite a base maior",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = baseMenor,
            onValueChange = { baseMenor = it },
            label = {
                Text(
                    text = "Digite a base menor",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text(
                    text = "Digite a altura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (baseMaior.isNotEmpty() && baseMenor.isNotEmpty() && altura.isNotEmpty()) {
                    ((baseMaior.toFloat() + baseMenor.toFloat()) * altura.toFloat() / 2).toDouble()
                } else 0.0
                area_trapezoide = "%.2f".format(area)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $area_trapezoide",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um trapézio é calculada usando a fórmula: A = ((B + b) × h) / 2, onde B e b são as bases maior e menor, e h é a altura do trapézio.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Poligono(navController: NavHostController) {

    var numLados by remember { mutableStateOf("") }
    var comprimentoLado by remember { mutableStateOf("") }
    var area by remember { mutableStateOf(0.0) }
    var area_poligono = "%.2f".format(area)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Polígono Regular",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.poligono),
            contentDescription = "Desenho do Polígono Regular",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numLados,
            onValueChange = { numLados = it },
            label = {
                Text(
                    text = "Digite o número de lados",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = comprimentoLado,
            onValueChange = { comprimentoLado = it },
            label = {
                Text(
                    text = "Digite o comprimento do lado",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = if (numLados.isNotEmpty() && comprimentoLado.isNotEmpty()) {
                    val n = numLados.toInt()
                    val s = comprimentoLado.toFloat()
                    (n * s * s) / (4 * kotlin.math.tan(kotlin.math.PI / n))
                } else 0.0
                area_poligono = "%.2f".format(area)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Área: $area_poligono",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "A área de um polígono regular com n lados é calculada usando a fórmula: A = (n × s²) / (4 × tan(π/n)), onde n é o número de lados e s é o comprimento do lado.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cuboide(navController: NavHostController) {

    var comprimento by remember { mutableStateOf("") }
    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var volume by remember { mutableStateOf(0.0) }
    var volume_cuboide = "%.2f".format(volume)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDF4E9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Cálculo da Forma: Cuboide",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(R.drawable.cuboide),
            contentDescription = "Desenho do Cuboide",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = comprimento,
            onValueChange = { comprimento = it },
            label = {
                Text(
                    text = "Digite o comprimento",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = largura,
            onValueChange = { largura = it },
            label = {
                Text(
                    text = "Digite a largura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text(
                    text = "Digite a altura",
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                    color = Color(0xFF503448)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF503448),
                focusedBorderColor = Color(0xFF503448),
                cursorColor = Color(0xFF503448)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                volume = if (comprimento.isNotEmpty() && largura.isNotEmpty() && altura.isNotEmpty()) {
                    comprimento.toFloat().toDouble() * largura.toFloat().toDouble() * altura.toFloat().toDouble()
                } else 0.0
                volume_cuboide = "%.2f".format(volume) // Atualiza o valor formatado
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFF503448)
            ),
            border = BorderStroke(1.dp, Color(0xFF503448)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular",
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Volume: $volume_cuboide",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "O volume de um cuboide é calculado usando a fórmula: V = comprimento × largura × altura.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF503448),
            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
            modifier = Modifier.padding(horizontal = 60.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF503448),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color(0xFF503448),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}






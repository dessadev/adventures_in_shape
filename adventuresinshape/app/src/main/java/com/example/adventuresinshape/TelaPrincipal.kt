package com.example.adventuresinshape

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TelaPrincipal(navController: NavController) {
    Scaffold(
        bottomBar = { Menu(navController) },
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, top = 8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("logout")
                    },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "logout",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF4E9))
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp),
                     horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.select),
                    contentDescription = "Welcome Image",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(180.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                val shapes = listOf(
                    Pair(R.drawable.circulo, "Círculo"),
                    Pair(R.drawable.quadrado, "Quadrado"),
                    Pair(R.drawable.triangulo, "Triângulo"),
                    Pair(R.drawable.retangulo, "Retângulo"),
                    Pair(R.drawable.romboedro, "Romboedro"),
                    Pair(R.drawable.trapezoide, "Trapezoide Irregular"),
                    Pair(R.drawable.poligono, "Polígono Regular com N Lados"),
                    Pair(R.drawable.cuboide, "Cubóide")
                )

                val colors = listOf(
                    Color(0xFFB6D7A8),
                    Color(0xFFFFD97A),
                    Color(0xFF6FA6EF),
                    Color(0xFFE1B9B9),
                    Color(0xFF97D5B2),
                    Color(0xFFD1B4FF),
                    Color(0xFFFF6F61),
                    Color(0xFF70A6A9)
                )

                shapes.forEachIndexed { index, (imageRes, shape) ->
                    val color = colors[index % colors.size]

                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(8.dp)
                            .clickable {
                                when (shape) {
                                    "Círculo" -> navController.navigate("circulo")
                                    "Quadrado" -> navController.navigate("quadrado")
                                    "Triângulo" -> navController.navigate("triangulo")
                                    "Retângulo" -> navController.navigate("retangulo")
                                    "Romboedro" -> navController.navigate("romboedro")
                                    "Trapezoide Irregular" -> navController.navigate("trapezoide")
                                    "Polígono Regular com N Lados" -> navController.navigate("poligono")
                                    "Cubóide" -> navController.navigate("cuboide")
                                }
                            },
                        colors = CardDefaults.cardColors(containerColor = color)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = shape,
                                modifier = Modifier.size(44.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = shape,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Menu(navController: NavController, modifier: Modifier = Modifier) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF331E2D))
            .padding(horizontal = 55.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val menuItems = listOf(
            Pair(R.drawable.home, "home"),
            Pair(R.drawable.perfil, "perfil"),
            Pair(R.drawable.termos, "termos"),
        )

        menuItems.forEach { (icon, title) ->
            val isSelected = title == currentRoute

            val circleBackgroundColor = if (isSelected) Color(0xFF331E2D) else Color.Transparent
            val iconColor = if (isSelected) Color(0xFFFFFAF4) else Color(0xFFFFFAF4)
            val borderColor = if (isSelected) Color(0xFFFDF4E9) else Color.Transparent
            val elevatedOffset = if (isSelected) (-40).dp else 0.dp

            Box(
                modifier = Modifier
                    .size(if (isSelected) 90.dp else 70.dp)
                    .offset(y = elevatedOffset)
                    .clip(RoundedCornerShape(50.dp))
                    .background(circleBackgroundColor)
                    .border(8.dp, borderColor, RoundedCornerShape(50.dp))
                    .padding(8.dp)
                    .zIndex(if (isSelected) 1f else 0f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        if (title != currentRoute && title != "logout") {
                            navController.navigate(title)
                        }
                    },
                    modifier = Modifier.size(if (isSelected) 45.dp else 30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = title,
                        tint = iconColor,
                        modifier = Modifier.size(45.dp)
                    )
                }
                }
            }
        }

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(navController: NavController) {
    Scaffold(
        bottomBar = { Menu(navController) }
    ) { padding ->

        var userName by remember { mutableStateOf("Andressa Morais") }
        var userEmail by remember { mutableStateOf("andressa@example.com") }
        val formasUsadas = listOf("Quadrado", "Triângulo", "Retângulo", "Trapézio", "Polígono Regular", "Cuboide")

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF4E9))
                .padding(padding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Perfil",
                    fontSize = 24.sp,
                    color = Color(0xFF503448),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
                )

                Spacer(modifier = Modifier.height(32.dp))

                Image(
                    painter = painterResource(R.drawable.pinky01),
                    contentDescription = "Foto do Personagem Pinky",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFF503448), CircleShape)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = {
                        Text(
                            text = "Nome",
                            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                            color = Color(0xFF503448)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(0xFF503448),
                        focusedBorderColor = Color(0xFF503448),
                        cursorColor = Color(0xFF503448)
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = userEmail,
                    onValueChange = { userEmail = it },
                    label = {
                        Text(
                            text = "Email",
                            fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                            color = Color(0xFF503448)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(0xFF503448),
                        focusedBorderColor = Color(0xFF503448),
                        cursorColor = Color(0xFF503448)
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Formas Usadas:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF503448),
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold))
                )

                formasUsadas.forEach { forma ->
                    Text(
                        text = forma,
                        fontSize = 16.sp,
                        color = Color(0xFF503448),
                        fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
                ) {
                    Text(
                        text = "Salvar",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermosDeUso(navController: NavController) {
    Scaffold(
        bottomBar = { Menu(navController) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF4E9))
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Termos de Uso",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF503448),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold)),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFEEEAB), RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = """
                            Bem-vindo ao nosso aplicativo!
                            
                            Antes de usar nossos serviços, leia atentamente os seguintes termos:
                            
                            1. Este aplicativo é destinado a fins educacionais e de entretenimento.
                            2. Os dados fornecidos são utilizados apenas para melhorar a experiência do usuário.
                            3. É proibido usar este aplicativo para atividades ilícitas.
                            4. Ao utilizar o aplicativo, você concorda com os termos descritos aqui.
                            
                            Caso tenha dúvidas, entre em contato conosco.
                        """.trimIndent(),
                        fontSize = 16.sp,
                        color = Color(0xFF503448),
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                        textAlign = TextAlign.Justify
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF503448)
                    )
                ) {
                    Text(
                        text = "Voltar",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c))
                    )
                }
            }
        }
    }
}


@Composable
fun Logout(navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDF4E9))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Deseja sair?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF503448),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate("login")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF503448)
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = "Sim",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = "Não",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun TelaPrincipalPreview() {
    val navController = rememberNavController()
    TelaPrincipal(navController)
}



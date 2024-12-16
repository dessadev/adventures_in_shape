package com.example.adventuresinshape

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cadastro(navController: NavController) {
    var nomeUsuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mostrarSenha by remember { mutableStateOf(false) }
    var requisitosValidos by remember { mutableStateOf(ValidacaoSenha()) }
    var senhaDigitada by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    fun updateValidacaoSenha(s: String) {
        requisitosValidos = validaSenha(s)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9))
            .imePadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(horizontal = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo02),
                contentDescription = null,
                modifier = Modifier.size(160.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.cadastro),
                contentDescription = "cadastro",
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "NOME DE USUÁRIO:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                modifier = Modifier
                    .offset(y = -8.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = nomeUsuario,
                onValueChange = { nomeUsuario = it },
                placeholder = { Text("nome de usuário:") },
                singleLine = true,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "usuario",
                        modifier = Modifier.size(20.dp)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF503448),
                    unfocusedBorderColor = Color(0xFF503448),
                    cursorColor = Color(0xFF503448),
                    focusedLabelColor = Color(0xFF503448)
                ),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF503448),
                        shape = RoundedCornerShape(25.dp)
                    )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "SEU EMAIL:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                modifier = Modifier
                    .offset(y = -8.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("seuemail@gmail.com") },
                singleLine = true,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "email"
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF503448),
                    unfocusedBorderColor = Color(0xFF503448),
                    cursorColor = Color(0xFF503448),
                    focusedLabelColor = Color(0xFF503448)
                ),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF503448),
                        shape = RoundedCornerShape(25.dp)
                    )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "SENHA:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                modifier = Modifier
                    .offset(y = -8.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = senha,
                onValueChange = {
                    senha = it
                    senhaDigitada = true
                    updateValidacaoSenha(it)
                },
                placeholder = { Text("Exemplo123!") },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { mostrarSenha = !mostrarSenha }) {
                        Image(
                            painter = painterResource(if (mostrarSenha) R.drawable.senha else R.drawable.senhaoculta),
                            contentDescription = if (mostrarSenha) "Ocultar senha" else "Exibir senha"
                        )
                    }
                },
                visualTransformation = if (mostrarSenha) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF503448),
                    unfocusedBorderColor = Color(0xFF503448),
                    cursorColor = Color(0xFF503448),
                    focusedLabelColor = Color(0xFF503448)
                ),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF503448),
                        shape = RoundedCornerShape(25.dp)
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (senhaDigitada) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    val faltando = mutableListOf<String>()
                    if (!requisitosValidos.temMaiuscula) faltando.add("uma letra maiúscula")
                    if (!requisitosValidos.temMinuscula) faltando.add("uma letra minúscula")
                    if (!requisitosValidos.temNumero) faltando.add("um número")
                    if (!requisitosValidos.temCaractereEspecial) faltando.add("um caractere especial")

                    if (faltando.isNotEmpty()) {
                        Text(
                            text = "A senha deve conter: ${faltando.joinToString(", ")}.",
                            color = Color.Red,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("cadastrofeito") },
                enabled = nomeUsuario.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() &&
                        requisitosValidos.temMaiuscula && requisitosValidos.temMinuscula &&
                        requisitosValidos.temNumero && requisitosValidos.temCaractereEspecial,
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (nomeUsuario.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() &&
                        requisitosValidos.temMaiuscula && requisitosValidos.temMinuscula &&
                        requisitosValidos.temNumero && requisitosValidos.temCaractereEspecial
                    ) Color(0xFF503448) else Color.Gray
                )
            ) {
                Text(
                    text = "CADASTRAR",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                    color = Color.White
                )
            }


            Image(
                painter = painterResource(id = R.drawable.linha),
                contentDescription = null,
                modifier = Modifier.height(48.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Já é usuário? Faça o login",
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold)),
                color = Color(0xFF503448)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
            ) {
                Text(
                    text = "LOGIN",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold))
                )
            }
        }
    }
}

data class ValidacaoSenha(
    val temMaiuscula: Boolean = false,
    val temMinuscula: Boolean = false,
    val temNumero: Boolean = false,
    val temCaractereEspecial: Boolean = false
)

fun validaSenha(s: String): ValidacaoSenha {
    return ValidacaoSenha(
        temMaiuscula = s.any { it.isUpperCase() },
        temMinuscula = s.any { it.isLowerCase() },
        temNumero = s.any { it.isDigit() },
        temCaractereEspecial = s.any { !it.isLetterOrDigit() }
    )
}

@Composable
fun Cadastrofeito(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cadastrofeito),
            contentDescription = null,
            modifier = Modifier
                .size(170.dp)
                .scale(scaleX = 1f, scaleY = 1f)
        )

        LaunchedEffect(Unit) {
            kotlinx.coroutines.delay(2000)
            navController.navigate("escolhapersonagem")
        }
    }
}


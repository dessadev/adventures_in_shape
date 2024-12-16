package com.example.adventuresinshape

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var lembrarMe by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    var mostrarSenha by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo02),
                contentDescription = null,
                modifier = Modifier
                    .size(160.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "login",
                modifier = Modifier
                    .width(250.dp)
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "SEU EMAIL:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                modifier = Modifier
                    .offset(y = -8.dp)
                    .offset(x = -94.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF503448),
                        shape = RoundedCornerShape(25.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("seuemail@gmail.com") },
                    singleLine = true,
                    leadingIcon = {
                            Image(
                                painter = painterResource (id = R.drawable.email),
                                contentDescription = "Email")
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

            }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "SENHA:",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold)),
                color = Color(0xFF503448),
                modifier = Modifier
                    .offset(y = -8.dp)
                    .offset(x = -118.dp)
            )


            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                placeholder = { Text("********") },
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


            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = lembrarMe,
                    onCheckedChange = { lembrarMe = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF503448))
                )
                Text(
                    text = "LEMBRAR DE MIM",
                    fontSize = 14.sp,
                    color = Color(0xFF503448),
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold)),
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { navController.navigate("home")},
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

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Esqueci minha senha",
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c)),
                color = Color(0xFF503448),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    navController.navigate("esquecisenha")
                }
            )


            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.linha),
                contentDescription = null,
                modifier = Modifier
                    .height(48.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Ainda não é usuário?",
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold)),
                color = Color(0xFF503448)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { navController.navigate("cadastro") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
            ) {
                Text(
                    text = "CADASTRAR",
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
fun EsqueciSenha(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 60.dp)
        ) {
            Text(
                text = "Um link para redefinição de senha foi enviado ao seu e-mail.",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_bold)),
                color = Color(0xFF503448),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF503448))
            ) {
                Text(
                    text = "VOLTAR",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.m_plus_rounded_1c_extrabold))
                )
            }
        }
    }
}


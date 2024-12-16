package com.example.adventuresinshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("inicio") { Inicio(navController) }
        composable("login") { Login(navController) }
        composable("cadastro") { Cadastro(navController) }
        composable("esquecisenha") { EsqueciSenha(navController) }
        composable("cadastrofeito") { Cadastrofeito(navController) }
        composable("escolhapersonagem") { EscolhaPersonagem(navController) }
        composable("falapersonagem/{selectedCharacter}") { backStackEntry ->
            val selectedCharacter = backStackEntry.arguments?.getString("selectedCharacter") ?: ""
            FalaPersonagem(navController = navController, selectedCharacter = selectedCharacter)
        }
        composable("home") { TelaPrincipal(navController) }
        composable("perfil") { Perfil(navController) }
        composable("termos") { TermosDeUso(navController) }
        composable("logout") { Logout(navController) }
        composable("circulo") { Circulo(navController) }
        composable("quadrado") { Quadrado(navController) }
        composable("triangulo") { Triangulo(navController) }
        composable("retangulo") { Retangulo(navController) }
        composable("trapezoide") { Trapezoide(navController) }
        composable("poligono") { Poligono(navController) }
        composable("cuboide") { Cuboide(navController) }






    }
}











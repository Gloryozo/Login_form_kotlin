package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.ui.Composables.OutlinedTextFieldWithTrailingIcon
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp), // Space between elements
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Login", // Title text
            color = MaterialTheme.colorScheme.primary, // Primary color from theme
            fontSize = MaterialTheme.typography.titleLarge.fontSize, // Font size from theme
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            textAlign = TextAlign.Center // Center the text
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            placeholder = { Text("Enter your username") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            },
            visualTransformation = VisualTransformation.None
        )

        OutlinedTextFieldWithTrailingIcon(
            password,
            onValueChangeFunc = { password = it },
            "Password",
            "Enter your password",
            Icons.Filled.Lock,
            "Lock icon",
            true
        )

        Button(
            onClick = {
                clickHandler(username, password)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}



// Click handler function for the button
fun clickHandler(usernameValue:String, passwordValue:String) {

    if (usernameValue.isEmpty() || passwordValue.isEmpty()) {
        //Can view the result using LogCat
        println("Username or password cannot be empty")
    } else {
        //Can view the result using LogCat
        println("Username: $usernameValue")
        println("Password: $passwordValue")
    }

}




@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginTheme {
        LoginForm()
    }
}
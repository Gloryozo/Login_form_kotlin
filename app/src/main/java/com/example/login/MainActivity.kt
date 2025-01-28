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

// MainActivity class that extends ComponentActivity
class MainActivity : ComponentActivity() {
    // onCreate method is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Call the superclass method
        enableEdgeToEdge() // Enable edge-to-edge display
        setContent { // Set the content of the activity
            LoginTheme { // Apply the login theme
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Display the login form with padding
                    LoginForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Composable function to display the login form
@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") } // State for username
    var password by remember { mutableStateOf("") } // State for password

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp), // Space between elements
        modifier = modifier
            .background(Color.White) // Set background color
            .fillMaxSize() // Fill the available space
            .padding(16.dp) // Add padding around the column
    ) {
        Text(
            text = "Login", // Title text
            color = MaterialTheme.colorScheme.primary, // Primary color from theme
            fontSize = MaterialTheme.typography.titleLarge.fontSize, // Font size from theme
            modifier = Modifier
                .fillMaxWidth() // Fill the width of the parent
                .padding(all = 16.dp), // Add padding around the text
            textAlign = TextAlign.Center // Center the text
        )

        // Input field for username
        OutlinedTextField(
            value = username, // Current value of username
            onValueChange = { username = it }, // Update username state
            label = { Text("Username") }, // Label for the input field
            placeholder = { Text("Enter your username") }, // Placeholder text
            modifier = Modifier.fillMaxWidth(), // Fill the width of the parent
            trailingIcon = { // Icon at the end of the input field
                Icon(
                    imageVector = Icons.Filled.Email, // Email icon
                    contentDescription = "Email Icon" // Description for accessibility
                )
            },
            visualTransformation = VisualTransformation.None // No transformation for input
        )

        // Input field for password with trailing icon
        OutlinedTextFieldWithTrailingIcon(
            password,
            onValueChangeFunc = { password = it }, // Update password state
            "Password", // Label for the input field
            "Enter your password", // Placeholder text
            Icons.Filled.Lock, // Lock icon
            "Lock icon", // Description for accessibility
            true // Indicates that the input is for password
        )

        // Submit button
        Button(
            onClick = {
                clickHandler(username, password) // Call click handler on button click
            },
            modifier = Modifier.fillMaxWidth() // Fill the width of the parent
        ) {
            Text("Submit") // Button text
        }
    }
}

// Click handler function for the button
fun clickHandler(usernameValue: String, passwordValue: String) {
    if (usernameValue.isEmpty() || passwordValue.isEmpty()) {
        // Log message if fields are empty
        println("Username or password cannot be empty")
    } else {
        // Log username and password if fields are filled
        println("Username: $usernameValue")
        println("Password: $passwordValue")
    }
}

// Preview function to display the login form in the design view
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginTheme { // Apply the login theme
        LoginForm() // Display the login form
    }
}

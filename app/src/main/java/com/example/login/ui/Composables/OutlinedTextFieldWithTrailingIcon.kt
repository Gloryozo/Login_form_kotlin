package com.example.login.ui.Composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun OutlinedTextFieldWithTrailingIcon(userValue:String,
                                      onValueChangeFunc:(String)->Unit,
                                      labelValue:String,
                                      placeholderValue:String,


                                      imageVectorDetails:ImageVector,
                                      imageVectorContentDetails:String,

                                      isPasswordValue:Boolean=false
)

{

    OutlinedTextField(
        value = userValue,
        onValueChange = onValueChangeFunc,
        label = { Text(labelValue) },
        placeholder = { Text(placeholderValue) },

        modifier = Modifier.fillMaxWidth(),

        trailingIcon = {
            Icon(
                imageVector =  imageVectorDetails,
                contentDescription = imageVectorContentDetails
            )
        },

        visualTransformation =
        if(isPasswordValue==true){
            PasswordVisualTransformation()
        }
        else {
            VisualTransformation.None
        }

    )
}
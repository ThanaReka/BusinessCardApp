package com.kurinchilion.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kurinchilion.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(modifier = Modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        NameSection(stringResource(R.string.full_name), stringResource(R.string.quote))
        ContactInformation(stringResource(R.string.phoneNumber),
            stringResource(R.string.emailId), stringResource(R.string.website_address)
        )
    }



}

@Composable
fun NameSection(fullname: String, quote: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,0.dp,0.dp,40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        val image = painterResource(id = R.drawable.kurinchi_new_white)
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = fullname,
            fontSize = 40.sp,
            modifier = modifier
        )
        Text(
            text = quote,
            fontWeight = FontWeight.Bold,
            modifier = modifier,
        )
    }
}

@Composable
fun ContactInformation(phoneNumber: String, emailId: String, website: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row {
            val image = painterResource(id = R.drawable.baseline_phone_24)
            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = "$phoneNumber",
                modifier = Modifier
                    .padding(5.dp)
            )
        }
        Row {
            val image = painterResource(id = R.drawable.baseline_email_24)
            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = emailId,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
        Row {
            val image = painterResource(id = R.drawable.baseline_web_24)
            Icon(
                modifier = Modifier
                    .padding(5.dp),
                painter = image,
                contentDescription = null,
            )
            Text(
                text = website,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}
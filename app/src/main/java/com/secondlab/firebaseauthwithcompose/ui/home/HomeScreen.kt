package com.secondlab.firebaseauthwithcompose.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.secondlab.firebaseauthwithcompose.R
import com.secondlab.firebaseauthwithcompose.navigation.ROUTE_HOME
import com.secondlab.firebaseauthwithcompose.navigation.ROUTE_LOGIN
import com.secondlab.firebaseauthwithcompose.ui.auth.AuthViewModel
import com.secondlab.firebaseauthwithcompose.ui.theme.AppTheme
import com.secondlab.firebaseauthwithcompose.ui.theme.spacing

@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.medium)
            .padding(top = spacing.extraLarge),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurface)
        Text(text = stringResource(id = R.string.name),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSurface)
        Image(painter = painterResource(id = R.drawable.ic_person),
            contentDescription = stringResource(id = R.string.empty),
            modifier = Modifier.size(128.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.medium)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                Text(text = stringResource(id = R.string.name),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = viewModel?.currentUser?.displayName ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                Text(text = stringResource(id = R.string.email),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface)
                Text(text = viewModel?.currentUser?.email ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface)
            }
            Button(onClick = {
                viewModel?.logout()
                navController.navigate(ROUTE_LOGIN) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            },
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = spacing.extraLarge)) {
                Text(text = stringResource(id = R.string.logout))
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}
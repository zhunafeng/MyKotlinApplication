package com.example.mykotlinapplication.features.failure

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mykotlinapplication.R

object FailureScreen {
    enum class UiState {
        /** Show the delete account button and the information panel */
        SHOW_DELETE,

        /** Show the confirmation dialogue */
        SHOW_CONFIRMATION
    }

    // test tags
    const val TEST_TAG_BACK_BUTTON = "TEST_TAG_BACK_BUTTON"
    const val TEST_TAG_DELETE_BUTTON = "TEST_TAG_DELETE_BUTTON"
    const val TEST_TAG_LEARN_MORE_LINK = "TEST_TAG_LEARN_MORE_LINK"
    const val TEST_TAG_VIEW_PLANS_LINK = "TEST_TAG_VIEW_PLANS_LINK"
}

@Composable
fun FailureScreen(
    uiState: FailureScreen.UiState,
    onBackClicked: () -> Unit,
) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Please put in a valid input to the calculator",
                           // color = ,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    backgroundColor = colorResource(id = R.color.yellow),

                )
            }
        ) { padding ->
            FailureScreenContent(
                uiState = uiState,
                padding = padding
            )
        }
    }
@Composable
private fun FailureScreenContent(
    uiState: FailureScreen.UiState,
    padding: PaddingValues
) {}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FailureScreenPreview() {
        FailureScreen(
            FailureScreen.UiState.SHOW_DELETE,
            {},
        )

}



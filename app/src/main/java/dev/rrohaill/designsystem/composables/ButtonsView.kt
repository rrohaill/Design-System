package dev.rrohaill.designsystem.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rrohaill.designsystem.DsSpace
import dev.rrohaill.designsystem.input.DsButtonStyle
import dev.rrohaill.designsystem.input.DsButtonXS
import dev.rrohaill.designsystem.input.DsDismissiveButton
import dev.rrohaill.designsystem.input.DsLinkButton
import dev.rrohaill.designsystem.input.DsPrimaryButton
import dev.rrohaill.designsystem.input.DsSecondaryButton
import dev.rrohaill.designsystem.input.DsTextButton
import dev.rrohaill.designsystem.models.UiImage
import dev.rrohaill.designsystem.standard.DsIcon
import dev.rrohaill.designsystem.standard.DsText
import dev.rrohaill.designsystem.standard.IconSize
import dev.rrohaill.designsystem.text.uiText
import dev.rrohaill.designsystem.ui.theme.DesignSystemTheme
import dev.rrohaill.designsystem.util.DsPreviews
import dev.rrohaill.designsystem.util.Expandable
import dev.rrohaill.ui.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@Composable
internal fun ButtonsScreen() {
    Expandable("Buttons") {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            DsPrimaryButton(
                leadingIcon = {
                    DsIcon(UiImage.of(R.drawable.ic_person))
                },
                label = {
                    DsText("DsPrimaryButtonM".uiText())
                },
                onClick = {}
            )

            DsSpace.default()
            DsDismissiveButton(
                label = { DsText("DsDismissiveButton".uiText()) },
                onClick = {}
            )
            DsSpace.default()
            var isLoading by remember { mutableStateOf(false) }
            val scope = rememberCoroutineScope()
            DsPrimaryButton(
                leadingIcon = {
                    DsIcon(UiImage.of(R.drawable.ic_person))
                },
                label = {
                    DsText("Press to show loader".uiText())
                },
                isLoading = isLoading,
                onClick = {
                    scope.launch {
                        isLoading = true
                        delay(5.seconds.inWholeMilliseconds)
                        isLoading = false
                    }
                }
            )
            DsSpace.default()
            DsSecondaryButton(
                icon = {
                    DsIcon(UiImage.of(id = R.drawable.ic_person))
                },
                label = {
                    DsText("DsSecondaryButtonM".uiText())
                },
                onClick = {}
            )
            DsSpace.default()
            DsTextButton(
                leadingIcon = {
                    DsIcon(
                        icon = UiImage.of(R.drawable.ic_person),
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                },
                label = {
                    DsText(text = "DsTextButtonM".uiText())
                },
                onClick = { }
            )
            DsSpace.default()
            DsLinkButton(text = "DsLinkButtonM".uiText(), onClick = {})
            DsSpace.default()
            DsSecondaryButton(
                buttonStyle = DsButtonStyle.S,
                icon = {
                    DsIcon(UiImage.of(id = R.drawable.ic_person))
                },
                label = {
                    DsText("DsSecondaryButtonS".uiText())
                },
                onClick = {}
            )
            DsSpace.default()
            DsLinkButton(
                text = "DsLinkButtonS".uiText(),
                buttonStyle = DsButtonStyle.LinkS,
                onClick = { /*TODO*/ })
            DsSpace.default()
            @Suppress("DEPRECATION")
            DsButtonXS(
                label = { DsText("DsButtonXS".uiText()) },
                icon = {
                    DsIcon(
                        UiImage.of(R.drawable.ic_person),
                        iconSize = IconSize.Small,
                    )
                }
            )
        }
    }
}


@DsPreviews
@Composable
private fun PreviewButtons() {
    DesignSystemTheme {
        ButtonsScreen()
    }
}
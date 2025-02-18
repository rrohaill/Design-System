package dev.rrohaill.designsystem.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.rrohaill.designsystem.DsSpace
import dev.rrohaill.designsystem.standard.DsText
import dev.rrohaill.designsystem.text.uiText
import dev.rrohaill.designsystem.ui.theme.DesignSystemTheme
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsColors
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsTypography
import dev.rrohaill.designsystem.util.DsPreviews
import dev.rrohaill.designsystem.util.Expandable

@Composable
internal fun SpacingView() {
    Expandable("Spacing") {
        Column(
            Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            PreviewSpacing("xsmall", "4.dp") {
                DsSpace.xsmall()
            }
            PreviewSpacing("small", "8.dp") {
                DsSpace.small()
            }
            PreviewSpacing("medium", "12.dp") {
                DsSpace.medium()
            }
            PreviewSpacing("large", "16.dp") {
                DsSpace.default()
            }
            PreviewSpacing("large", "24.dp") {
                DsSpace.large()
            }
            PreviewSpacing("xlarge", "32.dp") {
                DsSpace.xlarge()
            }
        }
    }
}

@Composable
fun PreviewSpacing(tokenLabel: String, size: String, content: @Composable () -> Unit) {
    Row(
        Modifier
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DsText(
            modifier = Modifier.sizeIn(minWidth = 100.dp),
            text = tokenLabel.uiText(),
            style = dsTypography.HeadingM
        )

        DsText(
            modifier = Modifier.sizeIn(minWidth = 100.dp),
            text = size.uiText(),
            style = dsTypography.HeadingM
        )

        Box(
            Modifier
                .background(dsColors.textPrimary)
        ) {
            content()
        }
    }
}

@DsPreviews
@Composable
private fun PreviewSpacing() {
    DesignSystemTheme {
        SpacingView()
    }
}
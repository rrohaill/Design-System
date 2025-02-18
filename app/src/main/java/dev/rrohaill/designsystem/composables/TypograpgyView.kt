package dev.rrohaill.designsystem.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
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
internal fun TypographyView() {
    Expandable("Typography") {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            DsTypography()
        }
    }
}

@Composable
fun DsTypography() {
    val textStyles = mapOf(
        "DisplayL" to dsTypography.DisplayL,
        "DisplayM" to dsTypography.DisplayM,
        "HeadingL" to dsTypography.HeadingL,
        "HeadingM" to dsTypography.HeadingM,
        "HeadingS" to dsTypography.HeadingS,
        "HeadingXS" to dsTypography.HeadingXS,
        "ButtonM" to dsTypography.ButtonM,
        "ButtonS" to dsTypography.ButtonS,
        "TitleM" to dsTypography.TitleM,
        "TitleS" to dsTypography.TitleS,
        "BodyM" to dsTypography.BodyM,
        "BodyS" to dsTypography.BodyS,
        "Overline" to dsTypography.Overline,
        "Caption" to dsTypography.Caption,
        "Monospace" to dsTypography.Monospace,
    )
    Column {
        textStyles.entries.toList().forEach {
            DsText(text = it.key.uiText(), style = it.value, color = dsColors.textPrimary)
            DsSpace.default()
        }
    }
}


@DsPreviews
@Composable
private fun PreviewTokens() {
    DesignSystemTheme {
        TypographyView()
    }
}
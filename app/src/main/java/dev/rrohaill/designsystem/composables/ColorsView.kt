package dev.rrohaill.designsystem.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.rrohaill.designsystem.DsSpace
import dev.rrohaill.designsystem.input.DsLinkButton
import dev.rrohaill.designsystem.input.DsTextButton
import dev.rrohaill.designsystem.listing.DsMediumSectionHeader
import dev.rrohaill.designsystem.models.UiImage
import dev.rrohaill.designsystem.standard.DsIcon
import dev.rrohaill.designsystem.standard.DsSurface
import dev.rrohaill.designsystem.standard.DsText
import dev.rrohaill.designsystem.text.uiText
import dev.rrohaill.designsystem.ui.theme.DesignSystemTheme
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsColors
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsDimensions
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsShapes
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsTypography
import dev.rrohaill.designsystem.util.DsCircle
import dev.rrohaill.designsystem.util.DsPreviews
import dev.rrohaill.designsystem.util.Expandable
import dev.rrohaill.ui.R

private data class DescribedColor(
    val label: String,
    val color: Color,
    val labelColor: Color? = null,
)

private data class ColorCombo(
    val surface: DescribedColor,
    val onSurface: DescribedColor
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ColorsView() {
    val colorCombos = listOf(
        ColorCombo(
            DescribedColor("surface", dsColors.backgroundSecondary),
            DescribedColor("onSurface", dsColors.textPrimary)
        ),
        ColorCombo(
            DescribedColor("background", MaterialTheme.colorScheme.background),
            DescribedColor("onBackground", MaterialTheme.colorScheme.onBackground)
        ),
        ColorCombo(
            DescribedColor("surfaceNeutral", dsColors.surfaceNeutral),
            DescribedColor("textPrimary", dsColors.textPrimary)
        ),
        ColorCombo(
            DescribedColor("surfaceSuccess", dsColors.surfaceSuccess),
            DescribedColor("onSurfaceSuccess", dsColors.onSurfaceSuccess)
        ),
        ColorCombo(
            DescribedColor("surfaceInformationHighlight", dsColors.surfaceHighlight),
            DescribedColor("onSurfaceInformationHighlight", dsColors.onSurfaceHighlight)
        ),
        ColorCombo(
            DescribedColor("surfaceInformationTemporary", dsColors.surfaceInfo),
            DescribedColor("onSurfaceInformationTemporary", dsColors.onSurfaceInfo)
        ),
        ColorCombo(
            DescribedColor("surfaceError", dsColors.surfaceError),
            DescribedColor("onSurfaceError", dsColors.onSurfaceError)
        ),
        ColorCombo(
            DescribedColor("surfaceErrorLight", dsColors.surfaceErrorLight),
            DescribedColor("onSurfaceErrorLight", dsColors.onSurfaceErrorLight)
        ),
        ColorCombo(
            DescribedColor("disabledSurface", dsColors.disabledSurface),
            DescribedColor("onDisabledSurface", dsColors.onDisabledSurface)
        ),
        ColorCombo(
            DescribedColor("sharedSurface", dsColors.sharedSurface),
            DescribedColor("onSharedSurface", dsColors.onSharedSurface)
        ),
    )
    Expandable("Color scales") {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(dsDimensions.defaultSpace)
        ) {
            DsMediumSectionHeader(label = "Color scales".uiText())
            FlowRow {
                colorCombos.forEach {
                    ColorComboTile(it)
                }
                ColorScale(
                    colorName = "Amber",
                    scale = listOf(
                        DescribedColor("100", dsColors.amber100),
                        DescribedColor("200", dsColors.amber200),
                        DescribedColor("300", dsColors.amber300),
                        DescribedColor("400", dsColors.amber400),
                        DescribedColor("500", dsColors.amber500),
                    )
                )
                ColorScale(
                    colorName = "Green",
                    scale = listOf(
                        DescribedColor("100", dsColors.green100),
                        DescribedColor("200", dsColors.green200),
                        DescribedColor("300", dsColors.green300),
                        DescribedColor("400", dsColors.green400),
                        DescribedColor("500", dsColors.green500),
                    )
                )
                ColorScale(
                    colorName = "Indigo",
                    scale = listOf(
                        DescribedColor("100", dsColors.indigo100),
                        DescribedColor("200", dsColors.indigo200),
                        DescribedColor("300", dsColors.indigo300),
                        DescribedColor("400", dsColors.indigo400),
                        DescribedColor("500", dsColors.indigo500),
                    )
                )
                ColorScale(
                    colorName = "Background",
                    scale = listOf(
                        DescribedColor("primary", dsColors.backgroundPrimary),
                        DescribedColor("secondary", dsColors.backgroundSecondary),
                        DescribedColor(
                            "tertiary",
                            dsColors.backgroundTertiary,
                            dsColors.textPrimary
                        ),
                        DescribedColor("white", dsColors.backgroundWhite, dsColors.textBlack),
                        DescribedColor("inverted", dsColors.backgroundInverted),
                    )
                )
            }
            DsSpace.default()
            DsMediumSectionHeader(label = "Other colors".uiText())
            DsTextButton(
                leadingIcon = {
                    DsIcon(UiImage.of(R.drawable.ic_question), Modifier.size(16.dp))
                },
                onClick = { },
                contentColor = dsColors.activeHighlight
            ) {
                DsText("activeHighlight".uiText())
            }
            DsSpace.default()
            Row {
                DsText("Notification".uiText(), color = dsColors.notification)
                DsSpace.default()
                DsCircle(color = dsColors.notification, size = 16.dp)
            }
            DsSpace.default()
            DsLinkButton(text = "linkPrimary".uiText()) { }
            DsSpace.default()
            DsText(text = "errorText".uiText(), color = dsColors.errorText)
            DsSpace.default()
            BorderPreview("borderDistinct", dsColors.borderDistinct)
            DsSpace.default()
            BorderPreview("borderInput", dsColors.borderInput)
            DsSpace.default()
            BorderPreview("borderSubtle", dsColors.borderSubtle)
            DsSpace.default()
            BorderPreview("buttonBorder", dsColors.buttonBorder)
            DsSpace.default()
        }
    }
}

@Composable
private fun BorderPreview(
    borderName: String,
    borderColor: Color,
) {
    DsSurface(
        shape = dsShapes.mediumRounding,
        border = BorderStroke(2.dp, borderColor),
    ) {
        DsText(
            modifier = Modifier.padding(16.dp),
            text = borderName.uiText(),
        )
    }
}

@Composable
private fun ColorComboTile(
    colorCombo: ColorCombo
) {
    DsSurface(
        color = colorCombo.surface.color,
    ) {
        Box(
            Modifier
                .size(152.dp)
                .padding(8.dp), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DsText(
                    text = colorCombo.surface.label.uiText(),
                    color = colorCombo.onSurface.color,
                    style = dsTypography.Caption,
                    textAlign = TextAlign.Center,
                )
                DsText(
                    text = "+".uiText(),
                    color = colorCombo.onSurface.color,
                    style = dsTypography.Caption,
                )
                DsText(
                    text = colorCombo.onSurface.label.uiText(),
                    color = colorCombo.onSurface.color,
                    style = dsTypography.Caption,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
private fun ColorScale(
    colorName: String,
    scale: List<DescribedColor>,
) {
    Box(contentAlignment = Alignment.CenterStart) {
        Row(Modifier.size(152.dp), verticalAlignment = Alignment.CenterVertically) {
            DsSpace.xlarge()
            Column(Modifier.weight(1f)) {
                scale.forEachIndexed { index, describedColor ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(describedColor.color),
                        contentAlignment = Alignment.Center
                    ) {
                        val color = describedColor.labelColor ?: if (index > scale.size / 2) {
                            dsColors.textInverted
                        } else {
                            dsColors.textPrimary
                        }
                        DsText(
                            text = describedColor.label.uiText(),
                            style = dsTypography.Caption,
                            textAlign = TextAlign.Center,
                            color = color,
                        )
                    }
                }
            }
        }
        DsText(
            modifier = Modifier
                .size(152.dp)
                .padding(8.dp)
                .rotate(-90f),
            text = colorName.uiText(),
            textAlign = TextAlign.Center
        )
    }
}

@DsPreviews
@Composable
private fun PreviewColors() {
    DesignSystemTheme {
        ColorsView()
    }
}
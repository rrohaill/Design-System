package dev.rrohaill.designsystem.util

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import dev.rrohaill.designsystem.placeholder.DsPlaceholderHighlight
import dev.rrohaill.designsystem.placeholder.placeholder
import dev.rrohaill.designsystem.placeholder.shimmer
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsColors
import dev.rrohaill.designsystem.ui.theme.DsTheme.dsShapes

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.dsPlaceholder(
    isLoading: Boolean,
    backgroundColor: Color = Color.Unspecified,
    shape: Shape? = null,
    showShimmerAnimation: Boolean = true
): Modifier = composed {
    val highlight = if (showShimmerAnimation) {
        DsPlaceholderHighlight.shimmer(highlightColor = dsColors.backgroundTertiary)
    } else {
        null
    }
    val specifiedBackgroundColor = backgroundColor.takeOrElse { dsColors.borderDistinct.copy(0.6f) }
    val resolvedShape = shape ?: dsShapes.mediumRounding
    Modifier.placeholder(
        color = specifiedBackgroundColor,
        visible = isLoading,
        shape = resolvedShape,
        highlight = highlight
    )
}

@Composable
fun Expandable(
    title: String,
    expandedContent: @Composable () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ) {
        Row(
            modifier = Modifier.clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                    contentDescription = if (expanded) "Show less" else "Show more",
                )
            }
        }
        if (expanded) {
            expandedContent()
        }
    }
}
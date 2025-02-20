# Android Design System

A modern, flexible design system library example built with Jetpack Compose, providing a comprehensive set of reusable UI components, consistent theming, and design tokens for Android applications.

![Platform](https://img.shields.io/badge/platform-Android-green.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
[![API](https://img.shields.io/badge/API-26%2B-brightgreen.svg)](https://android-arsenal.com/api?level=26)

## Features

- 🎨 **Modern UI Components**: Pre-built, customizable Jetpack Compose components
- 🎯 **Design Tokens**: Centralized design values for colors, typography, spacing, and more
- 🌈 **Theming System**: Flexible theming with light/dark mode support
- 📱 **Responsive Design**: Components that adapt to different screen sizes
- ♿ **Accessibility**: Built-in accessibility support with semantic properties
- 📚 **Documentation**: Comprehensive documentation and usage examples

## Setup

1. Wrap your app content with the Design System theme:

```kotlin
@Composable
fun MyApp() {
    DesignSystemTheme {
        // Your app content here
    }
}
```

## Basic Usage

### Buttons

```kotlin

@Composable
fun MyScreen() {
   DsPrimaryButton(
                leadingIcon = {
                    DsIcon(UiImage.of(R.drawable.ic_person))
                },
                label = {
                    DsText("DsPrimaryButtonM".uiText())
                },
                onClick = {}
            )
}
```

### Typography

```kotlin

@Composable
fun TextExample() {
    DsText(
        text = "Heading",
        style = dsTypography.HeadingM
    )
    
    Text(
        text = "Body text",
        style = dsTypography.TitleS
    )
}
```

### Colors

```kotlin

@Composable
fun ColorExample() {
    DsSurface(
        color = dsColors.backgroundPrimary,
        content = { /* Content */ }
    )

 DsScaffold(
        color = dsColors.backgroundPrimary,
        content = { /* Content */ }
    )
}
```

## And many more, you can explore in the code sample.



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


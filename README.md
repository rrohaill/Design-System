# Android Design System

A modern, flexible design system built with Jetpack Compose, providing a comprehensive set of reusable UI components, consistent theming, and design tokens for Android applications.

![Platform](https://img.shields.io/badge/platform-Android-green.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)

## Features

- 🎨 **Modern UI Components**: Pre-built, customizable Jetpack Compose components
- 🎯 **Design Tokens**: Centralized design values for colors, typography, spacing, and more
- 🌈 **Theming System**: Flexible theming with light/dark mode support
- 📱 **Responsive Design**: Components that adapt to different screen sizes
- ♿ **Accessibility**: Built-in accessibility support with semantic properties
- 📚 **Documentation**: Comprehensive documentation and usage examples

## Installation

Add the following dependency to your app's `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.rrohaill:design-system:1.0.0'
}
```

Add the Maven repository in your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

## Setup

1. Initialize the Design System in your Application class:

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DesignSystem.init()
    }
}
```

2. Wrap your app content with the Design System theme:

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
import com.designsystem.components.Button

@Composable
fun MyScreen() {
    Button(
        text = "Click Me",
        onClick = { /* Handle click */ }
    )
    
    Button.Secondary(
        text = "Cancel",
        onClick = { /* Handle click */ }
    )
}
```

### Typography

```kotlin
import com.designsystem.theme.Typography

@Composable
fun TextExample() {
    Text(
        text = "Heading",
        style = Typography.h1
    )
    
    Text(
        text = "Body text",
        style = Typography.body1
    )
}
```

### Colors

```kotlin
import com.designsystem.theme.Colors

@Composable
fun ColorExample() {
    Surface(
        color = Colors.primary,
        content = { /* Content */ }
    )
}
```

## Documentation

For detailed documentation and more examples, visit our [Wiki](https://github.com/rrohaill/Design-System/wiki).

## Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for more details.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


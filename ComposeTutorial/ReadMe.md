# ComposeTutorial

**Tutorial link:** [Android Developers]

### Notes

* Compose is Android's modern toolkit for building native UI, which simplifies and accelerates UI development. It requires less code to implement a UI compared to the Android View system, which makes your app easier to maintain.
* Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.
* Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the `@Composable` annotation to the function name.
* The `setContent` block defines the activity's layout where composable functions are called. 
* Composable functions can only be called from other composable functions.
* Jetpack Compose uses a Kotlin compiler plugin to transform these composable functions into the app's UI elements.
* the `Text` composable function that is defined by the Compose UI library displays a text label on the screen.
* **Define a composable function:** To make a function composable, add the `@Composable` annotation.
* **Preview your function in Android Studio:** The `@Preview `annotation lets you preview your composable functions within Android Studio without having to build and install the app to an Android device or emulator. The annotation must be used on a composable function that does not take in parameters. Add the `@Preview` annotation before `@Composable`.
* UI elements are hierarchical, with elements contained in other elements. In Compose, you build a UI hierarchy by calling composable functions from other composable functions.
* The `Column` function lets you arrange elements vertically. You can use `Row` to arrange items horizontally and `Box` to stack elements.
* To decorate or configure a composable, Compose uses **modifiers**. They allow you to change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable. You can chain them to create richer composables. 
* Compose is built to support Material Design principles. Many of its UI elements implement Material Design out of the box.Jetpack Compose provides an implementation of Material Design 3 and its UI elements out of the box. 
* Material Design is built around three pillars: `Color`, `Typography`, and `Shape`. 
* The Empty Compose Activity template generates a default theme for your project that allows you to customize MaterialTheme.
* Use `MaterialTheme.colorScheme` to style with colors from the wrapped theme. You can use these values from the theme anywhere a color is needed.
* Material `Typography` styles are available in the MaterialTheme
* [Dark theme] (or night mode) can be enabled to avoid a bright display especially at night, or simply to save the device battery. Thanks to the Material Design support, Jetpack Compose can handle the dark theme by default. Having used Material Design colors, text and backgrounds will automatically adapt to the dark background. Color choices for the light and dark themes are defined in the IDE-generated `Theme.kt` file.
* You can create multiple previews in your file as separate functions, or add multiple annotations to the same function.
* Create list: For this use case, use Compose’s `LazyColumn` and `LazyRow`. These composables render only the elements that are visible on screen, so they are designed to be very efficient for long lists.
* To store local UI state, you need to keep track of whether a message has been expanded or not. To keep track of this state change, you have to use the functions `remember` and `mutableStateOf`. Composable functions can store local state in memory by using `remember`, and track changes to the value passed to `mutableStateOf`. Composables (and their children) using this state will get redrawn automatically when the value is updated. This is called [recomposition]. By using Compose’s state APIs like `remember` and `mutableStateOf`, any changes to state automatically update the UI.

> **Note:** You need to add the following imports to correctly use Kotlin's delegated property syntax (the by keyword). Alt+Enter or Option+Enter adds them for you.
> `import androidx.compose.runtime.getValue` 
> `import androidx.compose.runtime.setValue`

* The `clickable` modifier is used to handle click events on the composable. Instead of just toggling the background color of the `Surface`, you will animate the background color by gradually modifying its value from `MaterialTheme.colorScheme.surface` to `MaterialTheme.colorScheme.primary` and vice versa. To do so, you will use the `animateColorAsState` function.

Here’s what you've learned so far:
- Defining composable functions
- Adding different elements in your composable
- Structuring your UI component using layout composables
- Extending composables by using modifiers
- Creating an efficient list
- Keeping track of state and modifying it
- Adding user interaction on a composable
- Animating messages while expanding them



[Android Developers]: https://developer.android.com/develop/ui/compose/tutorial
[Dark theme]: https://developer.android.com/guide/topics/ui/look-and-feel/darktheme
[recomposition]: https://developer.android.com/develop/ui/compose/mental-model#recomposition

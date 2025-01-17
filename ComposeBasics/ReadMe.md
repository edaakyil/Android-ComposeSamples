# ComposeBasics

**[Tutorial link]**

<img src="images/codelab.gif" alt="codelab-img" style="width:50%;margin:0px 25%"/>


**Other useful links:**
- [Compose Quick start]
- [Compose Material Catalog]
- [List of Compose Modifiers]
- [Lambda expression]
- [Higher-order functions and lambdas]
- [How Compose uses Kotlin features here]
- [Function Types documentation]


### Steps of App
- How to build UIs with Compose
  - Reusing composables
  - Creating columns and rows
- How to manage state in composable functions
  - State in Compose
  - State hoisting
  - Persisting state
- How to create a performant list
  - Creating a performant lazy list
- How to add animations
  - Animating custom list
- How to style and theme an app
  - Styling and theming your app


### Jetpack Compose
  [Jetpack Compose] is a modern toolkit designed to simplify UI development. It combines a reactive programming model with the conciseness and ease of use of the Kotlin programming language. It is fully declarative, meaning you describe your UI by calling a series of functions that transform data into a UI hierarchy. When the underlying data changes, the framework automatically re-executes these functions, updating the UI hierarchy for you.

  A Compose app is made up of composable functions - just regular functions marked with `@Composable`, which can call other composable functions. A function is all you need to create a new UI component. The annotation tells Compose to add special support to the function for updating and maintaining your UI over time. Compose lets you structure your code into small chunks. Composable functions are often referred to as "**composables**" for short.

  By making small reusable composables, it's easy to build up a library of UI elements used in your app. Each one is responsible for one part of the screen and can be edited independently.

  With Compose, an `Activity` remains the entry point to an Android app.  In our project, `MainActivity` is launched when the user opens the app (as it's specified in the `AndroidManifest.xml` file). You use `setContent` to define your layout, but instead of using an XML file as you'd do in the traditional View system, you call Composable functions within it.


### Composable functions
A composable function is a regular function annotated with `@Composable`. In other words, Composable functions are Kotlin functions that are marked with the `@Composable` annotation. This enables your function to call other `@Composable` functions within it. 

> ***Note:*** The terms "**UI Components**", "**Composable functions**", and "**composables**" may be used interchangeably to refer to the same concept.

Composable functions can be used like any other function in Kotlin. This makes building UIs really powerful since you can add statements to influence how the UI will be displayed.

For example, you can use a `for` loop to add elements to the `Column`:


### Modifiers
Most Compose UI elements such as `Surface` and `Text` accept an optional `modifier` parameter. Modifiers tell a UI element how to lay out, display, or behave within its parent layout.

For example, the `padding` modifier will apply an amount of space around the element it decorates. You can create a padding modifier with `Modifier.padding()`. You can also add multiple modifiers by chaining them.

There are dozens of modifiers which can be used to align, animate, lay out, make clickable or scrollable, transform, etc. For a comprehensive list, check out the [List of Compose Modifiers].

### Reusing composables
The more components you add to the UI, the more levels of nesting you create. This can affect readability if a function becomes really large. By making small reusable components it's easy to build up a library of UI elements used in your app. Each one is responsible for one small part of the screen and can be edited independently.

<mark>As a best practice, your function should include a Modifier parameter that is assigned an empty Modifier by default. Forward this modifier to the first composable you call inside your function. This way, the calling site can adapt layout instructions and behaviors from outside of your composable function.</mark>


### State in Compose
Compose apps transform data into UI by calling composable functions. If your data changes, Compose re-executes these functions with the new data, creating an updated UI—this is called **recomposition**. Compose also looks at what data is needed by an individual composable so that it only needs to recompose components whose data has changed and skip recomposing those that are not affected.

As mentioned in [Thinking in Compose]:

Composable functions can execute frequently and in any order, you must not rely on the ordering in which the code is executed, or on how many times this function will be recomposed.

To add internal state to a composable, you can use the `mutableStateOf` function, which makes Compose recompose functions that read that `State`.

`State` and `MutableState` are interfaces that hold some value and trigger UI updates (recompositions) whenever that value changes.

However you can't just assign `mutableStateOf` to a variable inside a composable. To preserve state across recompositions, _remember_ the mutable state using `remember`. `remember` is used to **guard** against recomposition, so the state is not reset.

Note that if you call the same composable from different parts of the screen you will create different UI elements, each with its own version of the state. You can think of internal state as a private variable in a class.


### Notes: 
* To use the Android Studio preview, you just have to mark any parameterless Composable function or functions with default parameters with the @Preview annotation and build your project. You can already see a Preview Composable function in the MainActivity.kt file. You can have multiple previews in the same file and give them names.
* <mark>**`Surface` and `MaterialTheme` are concepts related to [Material Design], which is a design system created by Google to help you create user interfaces and experiences.**</mark> The components nested inside `Surface` will be drawn on top of that background color. The Material components, such as `androidx.compose.material3.Surface`, are built to make your experience better by taking care of common features that you probably want in your app, such as choosing an appropriate color for text. We say Material is opinionated because it provides good defaults and patterns that are common to most apps. The Material components in Compose are built on top of other foundational components (in `androidx.compose.foundation`), which are also accessible from your app components in case you need more flexibility.
* The three basic standard layout elements in Compose are `Column`, `Row` and `Box`. They are Composable functions that take Composable content, so you can place items inside. For example, each child inside of a `Column` will be placed vertically.
* `Button` is a composable provided by the material3 package which takes a composable as the last argument. Since [trailing lambdas] can be moved outside of the parentheses, you can add any content to the button as a child. For example, a `Text`:

  ```kt
  Button(
      onClick = { } 
  ) {
      Text("Show less")
  }
  ```
  Compose provides different types of Button according to the [Material Design Buttons spec] — `Button`, `ElevatedButton`, `FilledTonalButton`, `OutlinedButton`, and `TextButton`.
* The `weight` modifier makes the element fill all available space, making it _flexible_, effectively pushing away the other elements that don't have a weight, which are called _inflexible_. It also makes the `fillMaxWidth` modifier redundant.


<!-- Links -->

[Tutorial link]: https://developer.android.com/codelabs/jetpack-compose-basics

[Jetpack Compose]: https://developer.android.com/jetpack/compose
[Compose Quick start]: https://developer.android.com/jetpack/compose/setup
[Material Design]: https://m3.material.io/
[Compose Material Catalog]: https://play.google.com/store/apps/details?id=androidx.compose.material.catalog
[List of Compose Modifiers]: https://developer.android.com/jetpack/compose/modifiers-list
[trailing lambdas]: https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas
[Material Design Buttons spec]: https://m3.material.io/components/buttons/implementation/android
[Thinking in Compose]: https://developer.android.com/jetpack/compose/mental-model#recomposition
[Higher-order functions and lambdas]: https://kotlinlang.org/docs/lambdas.html
[How Compose uses Kotlin features here]: https://developer.android.com/jetpack/compose/kotlin#higher-order
[Function Types documentation]: https://kotlinlang.org/docs/lambdas.html#function-types
[Lambda expression]: https://kotlinlang.org/docs/lambdas.html#lambda-expression-syntax
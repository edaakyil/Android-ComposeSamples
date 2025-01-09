# Compose-ViewModel

**[Tutorial link]** | **[Original GitHub Repos]**


**Other Usefull Links:**
  - [State and Jetpack Compose]
  - [Android app architecture]
  - [ViewModel]


**Tutorial Content:**
  - Introduction to the Android app architecture
  - How to use the ViewModel class in your app
  - How to retain UI data through device configuration changes using a ViewModel
  

### App overview:
The Unscramble app is a single player word scrambler game. The app displays a scrambled word, and the player has to guess the word using all the letters shown. The player scores points if the word is correct. Otherwise, the player can try to guess the word any number of times. The app also has an option to skip the current word. In the top right corner, the app displays the word count, which is the number of scrambled words played in the current game. There are 10 scrambled words per game.

|         |        |         |
|:-------:|:------:|:-------:|
| ![img1] |![img2] | ![img3] |


### Notes:
* When a configuration change occurs, you can save an app's data through different ways, such as using `rememberSaveable` or saving the instance state. However, these options can create problems. Most of the time, you can use `rememberSaveable` but that might mean keeping the logic in or near composables. When apps grow, you should move data and logic away from composables. In this codelab, you will learn about a robust way to design your app and preserve app data during configuration changes by taking advantage of the Android Jetpack library, `ViewModel` and Android app architecture guidelines.
* Android Jetpack libraries are a collection of libraries to make it easier for you to develop great Android apps.
* App architecture is a set of design rules for an app. Much like the blueprint of a house, your architecture provides the structure for your app. A good app architecture can make your code robust, flexible, scalable, testable, and maintainable for years to come. The [Guide to app architecture] provides recommendations on app architecture and recommended best practices.
* <mark>[`ViewModel`] is one of the architecture components from Android Jetpack libraries that can store your app data.  The stored data is not lost if the framework destroys and recreates the activities during a configuration change or other events. However, the data is lost if the activity is destroyed because of process death. The ViewModel only caches data through quick activity recreations.</mark>

<!-- Links -->
[Tutorial link]: https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state?hl=en
[Original GitHub Repos]: https://github.com/google-developer-training/basic-android-kotlin-compose-training-unscramble
[Guide to app architecture]: https://developer.android.com/topic/libraries/architecture
[`ViewModel`]: https://developer.android.com/topic/libraries/architecture/viewmodel
[State and Jetpack Compose]: https://developer.android.com/develop/ui/compose/state
[Android app architecture]: https://developer.android.com/topic/architecture#recommended-app-arch
[ViewModel]: https://developer.android.com/reference/androidx/lifecycle/ViewModel

[img1]: ./img/ac79bf1ed6375a27_856.png 
[img2]: ./img/a1bc55781d627b38_856.png
[img3]: ./img/c6727347fe0db265_856.png
<p align="center">
  <a href=""><img width="200" height="200" src="https://github.com/fpaulpalis/PennyWise-GreenStash/blob/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp"></a>
</p>
<h1 align="center">PennyWise Savings App</h1>

------

**PennyWise Savings App** is a fork of *[GreenStash](https://github.com/Pool-Of-Tears/GreenStash)*, a FOSS Android app by *[Pool-Of-Tears](https://github.com/Pool-Of-Tears)*. It helps users manage savings goals while maintaining *GreenStash*’s core functionality with project-specific modifications.
------

<h2 align="center">Screenshots</h2>

| ![](https://github.com/user-attachments/assets/abfc2f9c-bbe6-47cc-b172-f22ae73d28ae) | ![](https://github.com/user-attachments/assets/e51303eb-dbb4-476b-8c58-cb5c6ba43663) | ![](https://github.com/user-attachments/assets/0f46e1f2-60af-48ce-9501-73ee2cf51056) |
|------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| ![](https://github.com/user-attachments/assets/b7d86f8b-1861-4ee0-8c85-0382e4b806a0) | ![](https://github.com/user-attachments/assets/6d18e19e-f5fa-49e4-bc55-24d5ffa944f7) | ![](https://github.com/user-attachments/assets/74037d17-0191-404b-b413-f68fbcaec667) |

------

<h2 align="center">Highlights</h2>

- Clean & beautiful UI based on Google's [Material Design 3](https://m3.material.io/)
  guidelines.
- View how much you need to save daily/weekly/monthly to achieve your goal before deadline.
- View detailed transaction (withdraw/deposit) history.
- Fully offline—_PennyWise Savings App_ does not require internet permissions to function.
- Compatible with Android 7.0 and above (API 24+)
- Supports [Material You](https://www.androidpolice.com/everything-we-love-about-material-you/amp/) theming in devices running on Android 12+
- MAD: UI and logic written with pure Kotlin. Single activity, no fragments, only composable
  destinations.

------

<h2 align="center">Tech Stack</h2>

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android
  development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - To improve
  performance by doing I/O tasks out of main thread asynchronously.
- [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) -
  A cold asynchronous data stream that sequentially emits values and completes normally or with an
  exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) -
  Collection of libraries that help you design robust, testable, and maintainable apps.
    - [Jetpack Compose](https://developer.android.com/jetpack/compose?gclsrc=ds&gclsrc=ds) - Jetpack
      Compose is Android’s recommended modern toolkit for building native UI
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects
      that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores
      UI-related data that isn't destroyed on UI changes.
- [Lottie](https://airbnb.design/lottie) - Lottie is an Android, iOS and React Native library that
  renders After Effects animations in real time.
- [Coil](https://coil-kt.github.io/coil/compose) - An image loading library for Android backed by
  Kotlin Coroutines.
- [Kotlinx.serialization](https://kotlinlang.org/docs/serialization.html) - Provides sets of
  libraries for various serialization formats – JSON, CBOR, protocol buffers, and others.
- [Dagger-Hilt](https://dagger.dev/hilt)
  For [Dependency injection (DI)](https://developer.android.com/training/dependency-injection)
- [Room database](https://developer.android.com/jetpack/androidx/releases/room) - Persistence
  library provides an abstraction layer over SQLite to allow for more robust database access while
  harnessing the full power of SQLite.

------



<h2 align="center">License</h2>

[MIT License][license] © [Stɑrry Shivɑm][github]

[license]: /LICENSE

[github]: https://github.com/starry-shivam

```
MIT License

Copyright (c) [2022 - Present] Stɑrry Shivɑm

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

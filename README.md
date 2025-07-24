# Kotlin Multiplatform Project

This is a Kotlin Multiplatform project targeting Android, iOS, Web, and Desktop.

## Project Structure

* `/composeApp` - Shared code for Compose Multiplatform applications.
  - `commonMain` - Code common to all targets.
  - Other folders (e.g., `androidMain`, `iosMain`, `desktopMain`, `wasmJsMain`) - Platform-specific code.

* `/iosApp` - iOS application entry point. Add SwiftUI code and iOS-specific configuration here.

## Running on Different Platforms

### Android
1. Open the project in Android Studio.
2. Select an Android device or emulator.
3. Run the `androidApp` configuration or use the green Run button.

### iOS
1. Open `iosApp/iosApp.xcodeproj` in Xcode.
2. Select an iOS simulator or a real device.
3. Build and run the app using Xcode.

### Desktop (Compose Desktop)
1. In the terminal, run:
   ```sh
   ./gradlew :composeApp:run
   ```
2. The desktop app will launch on your machine.

### Web (Wasm)
1. In the terminal, run:
   ```sh
   ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
   ```
2. Open the provided local URL in your browser to view the web app.

## Running on Multiple Devices Simultaneously
- You can run the Android, iOS, Desktop, and Web apps at the same time on different devices or emulators.
- Each platform is independent; changes in shared code will reflect across all targets after rebuilding.

## Production/Final Package Builds

### Android (APK/AAB)
- **APK:**
  1. In Android Studio, select the `androidApp` module.
  2. Go to **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
  3. The APK will be in `composeApp/build/outputs/apk/`.
- **AAB (Android App Bundle):**
  1. Go to **Build > Build Bundle(s) / APK(s) > Build Bundle (AAB)**.
  2. The AAB will be in `composeApp/build/outputs/bundle/`.

### iOS (IPA)
1. Open `iosApp/iosApp.xcodeproj` in Xcode.
2. Select **Any iOS Device (arm64)** as the target.
3. Go to **Product > Archive** to create an IPA for App Store/TestFlight.

### Desktop (Compose Desktop)
- **Windows:**
  - `.exe` and `.msi` installers will be in `composeApp/build/compose/binaries/main/msi/` and `composeApp/build/compose/binaries/main/exe/`.
- **Linux:**
  - `.deb` and `.rpm` packages will be in `composeApp/build/compose/binaries/main/deb/` and `composeApp/build/compose/binaries/main/rpm/`.
- **macOS:**
  - `.dmg` installer will be in `composeApp/build/compose/binaries/main/dmg/`.
- To build all, run:
  ```sh
  ./gradlew :composeApp:package
  ```

### Web (Wasm) Production Build
1. In the terminal, run:
   ```sh
   ./gradlew :composeApp:wasmJsBrowserProductionWebpack
   ```
2. The production-ready web files will be in `composeApp/build/dist/wasmJs/productionExecutable/`.
3. Deploy the contents of this folder to your web server.

## Resources
- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform)
- [Kotlin/Wasm](https://kotl.in/wasm/)

For feedback or issues, join the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web) or report on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).

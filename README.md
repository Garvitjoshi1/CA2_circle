# CA2_circle
 
# Android Canvas Animation: Moving Circles

## Overview

This project demonstrates how to animate two circles on an Android canvas using Kotlin and XML.

## Features

* **Two circles**: The canvas displays two large circles, one red and one blue.
* **Different colors**: The circles are visually distinct with different colors.
* **Touch interaction**: When the user touches the screen, the circles animate towards each other.
* **Reset**: A second touch on the screen resets the circles to their initial positions.
* **Smooth animation**: The movement of the circles is animated using `ValueAnimator` for a smooth visual effect.

## Code Structure

* **MainActivity.kt**: Contains the main activity and the custom `CustomCanvas` view.
* **activity_main.xml**: Contains the layout definition for the activity (not required in this case, as the custom view is directly set as content).

## How to Use

1. Create a new Android project in Android Studio.
2. Copy the code provided in the `MainActivity.kt` file into your project.
3. Run the app on an emulator or device.
4. Tap the screen to start the animation.
5. Tap the screen again to reset the circles.

## Key Concepts

* **Canvas**: The `Canvas` object is used to draw on the screen.
* **Paint**: The `Paint` object defines the properties of the circles, such as color and size.
* **ValueAnimator**: `ValueAnimator` is used to create animations and update the positions of the circles over time.
* **MotionEvent**: The `MotionEvent` object is used to detect user touch events on the screen.

## Further Improvements

* **Custom animations**: You can explore different animation types (e.g., linear, bounce, etc.) using different interpolators.
* **More complex interactions**: You could add additional touch events, such as dragging the circles or changing their colors.
* **Background and other elements**: You can add more visual elements to the canvas, such as a background image or other shapes.

## License

This project is licensed under the MIT License.

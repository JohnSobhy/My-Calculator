# MyCalculator: A simple calculator app with constraint layout

MyCalculator is a simple calculator app that I created for Android devices using Kotlin and XML. It has a simple and easy UI with comfortable colors and a cool design. It supports light and dark modes and works in portrait orientation only. It allows the user to perform basic everyday calculations such as addition, subtraction, multiplication, and division.

## Features

- The app only allows digits as the first entry, not any other symbols.
- The app requires the user to follow an operation symbol with another digit to complete the operation.
- The app allows positive and negative values and compound calculations. A result of one operation can be used as an operand for the next one.
- The app uses ConstraintLayout to achieve a flexible and responsive UI that adapts to different screen sizes and orientations.
- The app uses Buttons, EditTexts, and TextViews to display the input and output of the calculations.

## How to use

To use MyCalculator, you need to have an Android device with Android 4.4 or higher. You can download the app from the GitHub repository or build it from the source code using Android Studio SDK.

To perform a calculation, enter a digit using the numeric keypad, then choose an operation symbol (+, -, x, /) using the operator keypad, then enter another digit using the numeric keypad. The app will display the result in the output field. You can use the result as an operand for another operation by choosing another operation symbol. You can clear the input and output fields by pressing the C button. You can switch between light and dark modes by pressing the sun/moon icon in the top right corner.

## Source code

The source code of MyCalculator is available on GitHub at https://github.com/JohnSobhy/My-Calculator. 
You can clone or fork the repository and modify it as you wish. The app logic is in the MainActivity.kt file and the UI is in the activity_main.xml file. You can also open an issue or a pull request if you have any feedback or suggestions for improvement.



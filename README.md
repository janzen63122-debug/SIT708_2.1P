# Pass Task 2.1 - Travel Companion App

## About the task
This task is about making a Travel Companion App in an Android smartphone, learning how to manage Android Studio & its foundamental function

## Features
In this app you can have simple coversion of: 
  * **Currency:** Converts USD to AUD, EUR, JPY, and GBP using fixed 2026 rates.
  * **Fuel & Volume:** Converts MPG to km/L and US Gallons to Liters.
  * **Distance:** Converts Nautical Miles to Kilometers.
  * **Temperature:** Handles bidirectional conversions between Celsius, Fahrenheit, and Kelvin.
* **Dynamic UI Color-Coding (Optional Feature Achieved):** A dynamic banner automatically updates its color and text (Green for Currency, Red for Temperature, Blue for Fuel/Distance) based on the user's selected unit category.
* **Smart Number Formatting:** Currency and Temperature results are formatted to 2 decimal places, while Fuel and Distance results are formatted to 3 decimal places for enhanced precision.
* **Robust Input Validation:**
  * Crash-proof against empty inputs and non-numeric characters.
  * Detects and alerts the user of "Identity Conversions" (e.g., USD to USD).
  * Prevents logically impossible conversions, such as entering negative numbers for Fuel, Volume, or Distance.

## 🛠️ Technical Details
* **IDE:** Android Studio
* **Language:** Java
* **UI Layout:** `LinearLayout` (Vertical) utilizing `Spinner`, `EditText`, `TextView`, and `Button` components.

## 🚀 How to Run
1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Sync the Gradle files if prompted.
4. Run the app on an Android Emulator or a physical Android device via USB debugging.

## 📂 Submission Components
This repository is part of a larger assignment submission which also includes:
1. A 4-5 minute YouTube demonstration video explaining the code and UI.
2. A 500-word research report on Gemini Nano and its on-device AI capabilities.
3. An LLM Usage Declaration statement.

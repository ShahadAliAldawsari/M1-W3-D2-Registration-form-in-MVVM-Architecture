<h1>Registration and Sign-In using MVVM Architecture</h1>
This project is a simple implementation of a Sign-Up and Sign-In application using the Model-View-ViewModel (MVVM) architecture pattern. The application allows users to create an account and log in with basic input validation. The UI is built using Jetpack Compose, and navigation between screens is handled using Jetpack Navigation.<br>

<h2>Features</h2>

<h3>Sign-Up Screen:</h3>
- Users can create a new account by providing their name, email, password, and confirming the password.
- Basic input validation ensures all fields are filled, the email is valid, and passwords match.

<h3>Sign-In Screen:</h3>
- Existing users can log in using their email and password.
- Navigation to the Sign-Up screen is available for new users.

<h3>Input Validation:</h3>
- Email format validation.
- Password matching validation.
- Checks to ensure all fields are filled.

<h3>Navigation:</h3>
Seamless navigation between the Sign-Up and Sign-In screens using Jetpack Navigation.

<h2>Screenshots</h2>
<h3>Sign-Up</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/a8d83496-a47a-4909-968e-0f2e202adf69" />

<h3>Sign-Up</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/b821f866-5b3f-40c5-839f-a27770e82c97" />

<h3>Backages Structure</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/f9e40f63-8ecc-4161-88e4-84f71795cad8" />

<h2>Project Structure</h2>
The project follows the MVVM architecture and is organized as follows:

<h3>1. Model</h3>
- UserData: A data class representing user information (name, email, password, and confirm password).
- Repository: A placeholder class for handling data operations (e.g., saving user data to a database or making network requests).
- SignUp_Screen and SignIn_Screen: Objects representing navigation destinations.

<h3>2. View</h3>
- SignUpScreen: A composable function for the Sign-Up UI.
- SignInScreen: A composable function for the Sign-In UI.

<h3>3. ViewModel</h3>
HomeViewModel: Handles the business logic, including input validation and data saving.

<h3>4. MainActivity</h3>
- Entry point of the application.
- Sets up the navigation and UI using Jetpack Compose.

<h2>How to Run the Project</h2>

<h3>Prerequisites</h3>
- Android Studio (latest version recommended).
- Android Emulator or a physical device with USB debugging enabled.

<h3>Steps</h3>
1- Clone the Repository
2- Open the Project in Android Studio
3- Build the Project
4- Run the Project

<h2>References</h2>
MVVM Tutorial: https://www.youtube.com/watch?v=9eIhMFTs1Q8
Navigation Tutorial: https://www.youtube.com/watch?v=AIC_OFQ1r3k

<h2>Using the App</h2>
<h3>Sign-Up</h3>
- Navigate to the Sign-Up screen.
- Enter your name, email, password, and confirm the password.
- Click the Sign Up button.
If the input is valid, you will be redirected to the Sign-In screen.
If the input is invalid, appropriate validation messages will be displayed (to be implemented).

<h3>Sign-In</h3>
- Navigate to the Sign-In screen.
- Enter your email and password.
- Click the Sign In button.
If the credentials are valid, you will be logged in (to be implemented).
If the credentials are invalid, appropriate error messages will be displayed (to be implemented).
















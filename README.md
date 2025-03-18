<h1>Registration and Sign-In using MVVM Architecture</h1>
This project is a simple implementation of a Sign-Up and Sign-In application using the Model-View-ViewModel (MVVM) architecture pattern. The application allows users to create an account and log in with basic input validation. The UI is built using Jetpack Compose, and navigation between screens is handled using Jetpack Navigation.<br>

<h2>Features</h2>

<h3>Sign-Up Screen:</h3>
- Users can create a new account by providing their name, email, and password, and confirming the password.<br>
- Basic input validation ensures all fields are filled out, the email is valid, and the passwords match.<br>

<h3>Sign-In Screen:</h3>
- Existing users can log in using their email and password.<br>
- Navigation to the Sign-Up screen is available for new users.<br>

<h3>Input Validation:</h3>
- Email format validation.<br>
- Password matching validation.<br>
- Checks to ensure all fields are filled.<br>

<h3>Navigation:</h3>
Seamless navigation between the Sign-Up and Sign-In screens using Jetpack Navigation.<br>

<h2>Screenshots</h2>
<h3>Sign-Up Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/a8d83496-a47a-4909-968e-0f2e202adf69" />

<h3>Sign-Ip Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/b821f866-5b3f-40c5-839f-a27770e82c97" />

<h3>Backages Structure</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/f9e40f63-8ecc-4161-88e4-84f71795cad8" />

<h2>Project Structure</h2>
The project follows the MVVM architecture and is organized as follows:

<h3>1. Model</h3>
- UserData: A data class representing user information (name, email, password, and confirm password).<br>
- Repository: A placeholder class for handling data operations (e.g., saving user data to a database or making network requests).<br>
- SignUp_Screen and SignIn_Screen: Objects representing navigation destinations.<br>

<h3>2. View</h3>
- SignUpScreen: A composable function for the Sign-Up UI.<br>
- SignInScreen: A composable function for the Sign-In UI.<br>

<h3>3. ViewModel</h3>
HomeViewModel: Handles the business logic, including input validation and data saving.<br>

<h3>4. MainActivity</h3>
- Entry point of the application.<br>
- Sets up the navigation and UI using Jetpack Compose.<br>

<h2>How to Run the Project</h2>

<h3>Prerequisites</h3>
- Android Studio (latest version recommended).<br>
- Android Emulator or a physical device with USB debugging enabled.<br>

<h3>Steps</h3>
1- Clone the Repository<br>
2- Open the Project in Android Studio<br>
3- Build the Project<br>
4- Run the Project<br>

<h2>References</h2>
MVVM Tutorial: https://www.youtube.com/watch?v=9eIhMFTs1Q8<br>
Navigation Tutorial: https://www.youtube.com/watch?v=AIC_OFQ1r3k<br>

<h2>Using the App</h2>
<h3>Sign-Up</h3>
- Navigate to the Sign-Up screen.<br>
- Enter your name, email, and password, and confirm the password.<br>
- Click the Sign-Up button.<br>
If the input is valid, you will be redirected to the Sign-In screen.<br>
If the input is invalid, appropriate validation messages will be displayed (to be implemented).<br>

<h3>Sign-In</h3>
- Navigate to the Sign-In screen.<br>
- Enter your email and password.<br>
- Click the Sign In button.<br>
If the credentials are valid, you will be logged in (to be implemented).<br>
If the credentials are invalid, appropriate error messages will be displayed (to be implemented).<br>
















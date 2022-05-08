# jetpack-data-security
Learn data encryption with Jetpack Security


Key management
The Security library uses a 2-part system for key management:

A keyset that contains one or more keys to encrypt a file or shared preferences data. The keyset itself is stored in SharedPreferences.

A primary (master) key that encrypts all keysets. This key is stored using the Android keystore system.

# Include the library in your project
dependencies {
    implementation("androidx.security:security-crypto:1.0.0")
}

## Sample screen attched.

![Screenshot_20220508_124119](https://user-images.githubusercontent.com/16761010/167285883-674ff9a4-ef16-4b3b-bf77-bee41ba8a5f0.png)

### encrypted shared preferences data file
![Screenshot 2022-05-08 124217](https://user-images.githubusercontent.com/16761010/167285896-617676a4-e4c3-45e4-bb46-99dd00787c34.png)

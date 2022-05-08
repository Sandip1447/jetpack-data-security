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


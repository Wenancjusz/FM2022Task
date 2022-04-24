# FM2022Task

This is an Android app for Freeport Metrics 2022 Interview. 
The app requires user to put in a number between 5 to 20, then it downloads the exact random words using Random Words API next after click of a button the app sorts words alphabetically and looks for a recording which includes the word in its' title using MusicBrainz API. Finally the app shows to the user Word, Title, Artist and Album name.

The app is written in Kotlin

Random-Word-API: https://random-words-api.vercel.app/word
MusicBrainz API documentation: https://musicbrainz.org/doc/MusicBrainz_API

The app was tested on Android Studio Emulator with Android 12 installed. 


To clone the project click "Code" button, copy the link or download the ZIP file. 

In case downloading a ZIP file:
Unpack it where you want the project files to be. Run Android Studio ( my version 2021.1.1 patch 3) click File -> Open -> select the directory of the project and Click "OK" button.

In case of copying the link:
Run Android Studio ( my version 2021.1.1 patch 3) click File -> New -> Project From Version Control then paste the copied URL and select directory to store the project files. Click Clone.

Compiling the app:
Open the project using Android Studio. Click Build -> Make Project or alternatively CTRL + F9.

Running the app:
Open the project using Android Studio. Click Build -> Build Bundle(s)/APK(s) -> Build APK(s). Wait for the APK to be built. Move the APK to a phone and install it. Another way to run the project: setup android emulator and click Run -> Run 'app' or alternatively Shift + F10.

Usage of the app:
after running it enter number between 5 and 20 to get that amount of random words. Click "RUN" button. Wait for the words to be downloaded. After downloading the words click the "GET SONGS" button. Wait for the songs to be downloaded. Now you can see the word, aritst, album and title.

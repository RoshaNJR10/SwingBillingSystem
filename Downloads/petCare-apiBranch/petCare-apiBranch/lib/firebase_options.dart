// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyCGCKQt1Da87-lyHj0j5EYVaHyBoWo12_Q',
    appId: '1:223739083133:web:5f730ccbac2b054f4db414',
    messagingSenderId: '223739083133',
    projectId: 'petcare-71741',
    authDomain: 'petcare-71741.firebaseapp.com',
    storageBucket: 'petcare-71741.appspot.com',
    measurementId: 'G-0CP2FH6P52',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyAR6zFuNHsvRt0DquWuRYC6C5J_olNoliQ',
    appId: '1:223739083133:android:fe23a7a77223760b4db414',
    messagingSenderId: '223739083133',
    projectId: 'petcare-71741',
    storageBucket: 'petcare-71741.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyD8TAhvw4weabMUNCX_7QC_u6BCph5qcyI',
    appId: '1:223739083133:ios:c125c6a001da53b44db414',
    messagingSenderId: '223739083133',
    projectId: 'petcare-71741',
    storageBucket: 'petcare-71741.appspot.com',
    iosBundleId: 'com.example.projectPetcare',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyD8TAhvw4weabMUNCX_7QC_u6BCph5qcyI',
    appId: '1:223739083133:ios:a4cbe3a5ef98408a4db414',
    messagingSenderId: '223739083133',
    projectId: 'petcare-71741',
    storageBucket: 'petcare-71741.appspot.com',
    iosBundleId: 'com.example.projectPetcare.RunnerTests',
  );
}

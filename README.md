# BNVR
[![](https://jitpack.io/v/adityaikhbalm/bottomnavigationrounded.svg)](https://jitpack.io/#adityaikhbalm/bottomnavigationrounded) ![GitHub release (latest by date)](https://img.shields.io/github/v/release/adityaikhbalm/bottomnavigationrounded) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21) [![GitHub license](https://img.shields.io/github/license/adityaikhbalm/bottomnavigationrounded)](https://github.com/adityaikhbalm/bottomnavigationrounded/blob/master/LICENSE)

Bottom Navigation View Rounded short BNVR it's basically BottomNavigationView with some custom to create navigation with rounded corners.

#### Latest version
See the latest released BNVR version [here](https://github.com/adityaikhbalm/bottomnavigationrounded/releases).

## ✍️ Installation
#### Gradle setup
```gradle
// project level gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
// module level gradle
dependencies {
        implementation 'com.github.adityaikhbalm:bottomnavigationrounded:2.1'
}
```

#### Maven setup
```xml
<!-- <repositories> section of pom.xml -->
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```
```xml
<!-- <dependencies> section of pom.xml -->
<dependency>
    <groupId>com.github.adityaikhbalm</groupId>
    <artifactId>bottomnavigationrounded</artifactId>
    <version>1.0</version>
</dependency>
```

## 💻 Compatibility
 * **Minimum Android SDK**: Requires a minimum API level of 21.
 * **Compile Android SDK**: Requires you to compile against API 30 or later.

## 🚀️ Getting Started
#### XML Layout
BNVR usage is pretty simple, you just need put code in your xml layout.
```xml
<com.adityaikhbalm.bottomnavigationviewrounded.BottomNavigationViewRounded
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:menu="@menu/my_menu"
        app:bottomNavigationColor="@color/colorPrimary"
        app:bottomNavigationCornerRadius="10dp" />
```

#### Properties
The BNVR has default properties and you can change it as what you want, here are the properties:

| Property | Value Type | Default Value | Information |
| -------- | ---------- | ------------- | ----------- |
| app:bottomNavigationColor | reference/color | Black / #000 | Change the background color |
| app:bottomNavigationCornerRadius | dimension | 10dp  | Change corner radius |

## 📝 License
This project is under MIT License. See the [LICENSE]('https://github.com/bumptech/glide/blob/master/LICENSE') file for details.

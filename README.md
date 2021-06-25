# jUserDirectories

Java library for detecting the path of the common user directories:
- Documents
- Downloads
- Pictures
- Videos
- Music
- Desktop

## Supported systems

- Windows 7, 8, 8.1, 10

## Usage

```java
UserDirectories userDirectories = UserDirectories.get();

System.out.println("Documents directory: " + userDirectories.documentsDirectoryPath());
System.out.println("Music directory: " + userDirectories.musicDirectoryPath());
System.out.println("Videos directory: " + userDirectories.videosDirectoryPath());
System.out.println("Pictures directory: " + userDirectories.picturesDirectoryPath());
System.out.println("Downloads directory: " + userDirectories.downloadsDirectoryPath());
System.out.println("Desktop directory: " + userDirectories.desktopDirectoryPath(System.getProperty("user.home"))); // you can specify a "fallback" path, if the given directory is not available on your system
```

## Using with a build system

...

## Used third-party libraries

- [Jetbrains Annotations](https://github.com/JetBrains/java-annotations) - Annotations for JVM-based languages
- [JNA](https://github.com/java-native-access/jna) - Java Native Access
- [OSHI](https://github.com/oshi/oshi) - Operating system & hardware information
- [Version Compare](https://github.com/G00fY2/version-compare) - Lightweight Android & Java library to compare version strings.
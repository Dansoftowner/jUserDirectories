package com.juserdirs;

public class Demo {

    public static void main(String... args) {

        UserDirectories userDirectories = UserDirectories.get();

        System.out.println("Documents directory: " + userDirectories.documentsDirectoryPath("Missing"));
        System.out.println("Music directory: " + userDirectories.musicDirectoryPath("Missing"));
        System.out.println("Videos directory: " + userDirectories.videosDirectoryPath("Missing"));
        System.out.println("Pictures directory: " + userDirectories.picturesDirectoryPath("Missing"));
        System.out.println("Downloads directory: " + userDirectories.downloadsDirectoryPath("Missing"));
        System.out.println("Desktop directory: " + userDirectories.desktopDirectoryPath("Missing"));

    }
}

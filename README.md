Web Port Scanner

Overview

This Java application provides a simple multi-threaded port scanner. It allows users to scan a specified host for open ports within a given range. The application is designed to be user-friendly, with prompts for the user to input the target host.
Features

    Port Scanning: Scans a specified host for open ports within a user-defined range.
    Multi-threading: Utilizes a fixed thread pool for efficient parallel port scanning.
    Input Validation: Validates user input for the target host using a custom domain validator.

Usage

    Run the application by executing the Main class.
    Enter the target host when prompted. The host can be either "localhost" or a valid http address in the format yourwebpage.com.
    The application will then scan ports within the specified range and display the open ports.

Acknowledgments

    The application uses Java's Socket for port scanning.
    Web address validation is performed using a custom regex pattern.

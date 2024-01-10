# Crunch Admin - Client-Server Dictionary Generation System

## Overview

Develop a client-server based system where clients interact with the Crunch Admin server through a Command-Line Interface (CLI) to request dictionary generation for specified keywords and parameters. The system employs Java programming, socket programming for communication, and aims to understand bruteforce attacks.

### Learning Outcomes

- Implement a CLI for user interactions.
- Utilize Socket Programming for communication between clients and servers.
- Gain insights into bruteforce attacks.

### Features

- **Network Administrator**: A system that generates a dictionary and uploads it to the client-defined directory.
- **Understanding Bruteforce Attacks**: The project delves into the workings of bruteforce attacks.
- **Command-Line Interface**: Users can interact with the server via the command line, requesting file operations and dictionary generation.

## Implementation

### Server Side

```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Server {

    // Insert provided Server code here
}

```
### Client Side

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // Insert provided Client code here
}
```
### Usage
## Server Setup:

Run the server-side code (Server.java) to initialize the Crunch Admin server.
Client Operations:

Compile and run the client-side code (Client.java) to interact with the server via the command line.
Input keywords, word length, file path, and number of words for dictionary generation.
Review the confirmation message from the server upon successful dictionary generation.
Contribution
Contributions are welcome! If you'd like to contribute, please fork the repository, make your changes, and create a pull request.

### Disclaimer
The project's purpose is educational, focusing on network administration, socket programming, and understanding bruteforce attacks. It's crucial to use this knowledge responsibly and ethically, refraining from any unauthorized or malicious activities.




# Start with a base image containing Java runtime
FROM openjdk:17-jdk

# Specify the working directory in Docker
WORKDIR /usr/src/app

# Copy the rest of your app's source code from your host to your image filesystem.
COPY . .

# instructions to build the Docker image and run the Docker container:

# Build the Docker image
# docker build -t my-java-app .

# Run the Docker container
# docker run -it --rm my-java-app bash

# Inside the Docker container, compile your Java program
# javac Time2.java Time2Test.java

# Run your Java program
# java Time2Test
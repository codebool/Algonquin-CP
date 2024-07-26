CREATE DATABASE twitter_clone;

USE twitter_clone;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE tweets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_email) REFERENCES users(email)
);

ALTER TABLE users ADD COLUMN profile_picture VARCHAR(255);
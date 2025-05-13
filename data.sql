CREATE DATABASE student_feedback;

USE student_feedback;

CREATE TABLE feedbacks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    course VARCHAR(100),
    rating INT,
    aspects TEXT,
    message TEXT,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


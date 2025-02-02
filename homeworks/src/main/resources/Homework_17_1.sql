CREATE DATABASE test_db;
CREATE TABLE tests (
    test_id SERIAL PRIMARY KEY,
    test_name VARCHAR(255) NOT NULL);

CREATE TABLE questions (
    question_id SERIAL PRIMARY KEY,
    test_id INT REFERENCES tests(test_id) ON DELETE CASCADE,
    question_content TEXT NOT NULL
);

CREATE TABLE answers (
 answer_id SERIAL PRIMARY KEY,
 question_id INT REFERENCES questions(question_id) ON DELETE CASCADE,
 answer_content text NOT NULL,
 is_right_answer BOOLEAN NOT NULL
);

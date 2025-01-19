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

INSERT INTO tests (test_name) VALUES ('Тест по математике');

INSERT INTO questions (test_id, question_content) VALUES 
(1, '2 + 2 = ?'),
(1, '16 / 4 = ?'),
(1, '25 * 4 = ?');

INSERT INTO answers (question_id, answer_content, is_right_answer) VALUES 
(1, '3', FALSE),
(1, '5', FALSE),
(1, '10', FALSE),
(1, '4', TRUE),
(2, '4', TRUE),
(2, '2', FALSE),
(2, '8', FALSE),
(3, '80', FALSE),
(3, '100', TRUE);
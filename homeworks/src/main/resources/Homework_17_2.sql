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
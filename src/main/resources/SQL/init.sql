-- Create codes table
CREATE TABLE codes (
    id SERIAL PRIMARY KEY,
    code UUID NOT NULL UNIQUE,
    is_expired BOOLEAN DEFAULT FALSE,
    player_name VARCHAR(255)
);
CREATE SCHEMA IF NOT EXISTS worldbuilder;

CREATE TABLE worldbuilder.worlds (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
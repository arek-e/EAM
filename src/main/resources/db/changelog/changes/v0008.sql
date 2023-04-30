-- Modify the id in users to be a generated always as identity column
ALTER TABLE users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY;

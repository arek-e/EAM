DROP TABLE authorities;

ALTER TABLE users ALTER COLUMN id TYPE BIGINT USING id::BIGINT;

CREATE TABLE roles (
    id BIGINT NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE users_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_users_roles_user_id FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_users_roles_role_id FOREIGN KEY (role_id) REFERENCES roles(id)
);
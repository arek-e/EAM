-- Add foreign key constraint to the users table
ALTER TABLE users_roles ADD CONSTRAINT fk_user_roles_users
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE;

-- Add foreign key constraint to the roles table
ALTER TABLE users_roles ADD CONSTRAINT fk_user_roles_roles
    FOREIGN KEY (role_id)
        REFERENCES roles(id)
        ON DELETE CASCADE;

-- Drop the current primary key constraint
ALTER TABLE users_roles DROP CONSTRAINT users_roles_pkey;

-- Add primary key constraint to the users_roles table
ALTER TABLE users_roles ADD CONSTRAINT pk_users_roles
    PRIMARY KEY (user_id, role_id);